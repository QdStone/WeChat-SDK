package ian.hu.wechat.sdk.utils;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 包含微信加解密相关工具方法
 *
 * @see #getSHA1ForMessage(String, String, String, Long) 消息体签名
 * @see #getSHA1ForValidate(String, String, Long) url签名
 * @see #encrypt(String, String, String) 加密方法
 * @see #decrypt(String, String) 解密方法
 */
@CommonsLog
public final class WeChatUtils {

    private static final Charset CHARSET = Charset.forName("utf-8");

    private WeChatUtils() {
    }

    /**
     * 生成消息签名
     *
     * @param token     服务器提供的token
     * @param nonce     随机串
     * @param timestamp 时间戳
     * @return 三个参数的签名
     * @see #getSHA1ForMessage(String, String, String, Long)
     */
    public static String getSHA1ForValidate(String token, String nonce, Long timestamp) {
        return getSHA1ForMessage("", token, nonce, timestamp);
    }

    /**
     * 对消息体进行签名
     *
     * @param text      消息内容
     * @param token     token
     * @param nonce     随机串
     * @param timestamp 时间戳
     * @return 返回签名
     */
    public static String getSHA1ForMessage(String text, String token, String nonce, Long timestamp) {
        String[] strings = {text, token, nonce, String.valueOf(timestamp)};
        Arrays.sort(strings);
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        return DigestUtils.shaHex(sb.toString());
    }

    /**
     * 加密消息内容
     *
     * @param text   消息原文
     * @param aesKey 微信生成的AesKey
     * @param appId  公众号AppId
     * @return 加密后的密文
     * @throws NoSuchPaddingException             找不到对齐方式
     * @throws NoSuchAlgorithmException           找不到加密算法
     * @throws InvalidAlgorithmParameterException 传递给加密算法的参数不正确
     * @throws InvalidKeyException                使用的Key不正确
     * @throws BadPaddingException                不正确的对齐方式
     * @throws IllegalBlockSizeException          非法的块大小
     */
    @SuppressWarnings("MethodWithTooExceptionsDeclared")
    public static String encrypt(String text, String aesKey, String appId) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        String randomStr = RandomStringUtils.random(16, true, true);
        byte[] aesKeyBytes = Base64.decodeBase64(aesKey + "=");
        byte[] randomBytes = randomStr.getBytes(CHARSET);
        byte[] textBytes = text.getBytes(CHARSET);
        byte[] networkOrderBytes = getNetworkBytesOrder(textBytes.length);
        byte[] appidBytes = appId.getBytes(CHARSET);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bytes = null;
        try {
            // randomStr + networkBytesOrder + text + appid
            bos.write(randomBytes);
            bos.write(networkOrderBytes);
            bos.write(textBytes);
            bos.write(appidBytes);
            // +pads
            bos.write(encodePKCS7(bos.size()));
            // 获得最终的字节流, 未加密
            bytes = bos.toByteArray();
            bos.close();
        } catch (IOException ignored) {
            // 不可能有异常除非内存不足
        }


        // 设置加密模式为AES的CBC模式
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec keySpec = new SecretKeySpec(aesKeyBytes, "AES");
        IvParameterSpec iv = new IvParameterSpec(aesKeyBytes, 0, 16);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);

        // 加密
        byte[] encrypted = cipher.doFinal(bytes);

        // 使用BASE64对加密后的字符串进行编码
        return Base64.encodeBase64String(encrypted);
    }

    @SuppressWarnings("MethodWithTooExceptionsDeclared")
    public static String decrypt(String encrypt, String aesKey) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException, InvalidKeyException {
        // 设置解密模式为AES的CBC模式
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        byte[] aesKeyBytes = Base64.decodeBase64(aesKey + "=");
        SecretKeySpec keySpec = new SecretKeySpec(aesKeyBytes, "AES");
        IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(aesKeyBytes, 0, 16));
        cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);

        // 使用BASE64对密文进行解码
        byte[] encrypted = Base64.decodeBase64(encrypt);
        // 解密
        byte[] decrypted = cipher.doFinal(encrypted);
        // 去除补齐
        decrypted = decodePKCS7(decrypted);
        // 分离16位随机字符串,网络字节序和AppId
        byte[] networkOrder = Arrays.copyOfRange(decrypted, 16, 20);
        // 还原长度
        int xmlLength = recoverNetworkBytesOrder(networkOrder);
        return new String(Arrays.copyOfRange(decrypted, 20, 20 + xmlLength), CHARSET);
    }

    private static byte[] encodePKCS7(int count) {
        int blockSize = 32;
        // 计算需要填充的位数
        int amountToPad = blockSize - count % blockSize;
        if (amountToPad == 0) {
            amountToPad = blockSize;
        }
        // 获得补位所用的字符
        //noinspection NumericCastThatLosesPrecision
        char padChr = (char) (amountToPad & 0xff);
        StringBuilder tmp = new StringBuilder();
        for (int index = 0; index < amountToPad; index++) {
            tmp.append(padChr);
        }
        return tmp.toString().getBytes(CHARSET);
    }

    private static byte[] decodePKCS7(byte... bytes) {
        int pad = bytes[bytes.length - 1];
        if (pad < 1 || pad > 32) {
            pad = 0;
        }
        return Arrays.copyOfRange(bytes, 0, bytes.length - pad);
    }

    // 还原4个字节的网络字节序
    private static int recoverNetworkBytesOrder(byte... orderBytes) {
        int sourceNumber = 0;
        for (int i = 0; i < 4; i++) {
            sourceNumber <<= 8;
            sourceNumber |= orderBytes[i] & 0xff;
        }
        return sourceNumber;
    }

    // 生成4个字节的网络字节序
    @SuppressWarnings("NumericCastThatLosesPrecision")
    private static byte[] getNetworkBytesOrder(int length) {
        byte[] orderBytes = new byte[4];
        orderBytes[3] = (byte) (length & 0xFF);
        orderBytes[2] = (byte) (length >> 8 & 0xFF);
        orderBytes[1] = (byte) (length >> 16 & 0xFF);
        orderBytes[0] = (byte) (length >> 24 & 0xFF);
        return orderBytes;
    }

    public static HashMap<String, Object> parseXml(String xml) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xml)));
            // 解析
            return parse(doc.getDocumentElement().getChildNodes());
        } catch (ParserConfigurationException | IOException | SAXException e) {
            log.error(e);
        }
        return null;
    }

    private static HashMap<String, Object> parse(NodeList nodeList) {
        HashMap<String, Object> data = new HashMap<>();
        boolean foundChild = false;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                // 有子节点
                foundChild = true;
                Element child = (Element) node;
                Map<String, Object> childData = null;
                if (child.hasChildNodes()) {
                    // 进一步parse
                    childData = parse(child.getChildNodes());
                }
                data.put(child.getTagName(), childData == null ? child.getTextContent() : childData);
            }
        }
        // 无子节点
        if (!foundChild) {
            return null;
        }
        return data;
    }

    public static String generateXml(HashMap<String, Object> data) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("Can't build a document factory", e);
        }
        Document doc = builder.newDocument();
        Element root = doc.createElement("xml");
        doc.appendChild(root);
        // 构造DOM
        generateElement(root, data);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException("Can't build a document transformer", e);
        }
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        // unchecked
        DOMSource domSource = new DOMSource(doc);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        StreamResult result = new StreamResult(bos);
        // 输出
        try {
            transformer.transform(domSource, result);
        } catch (TransformerException e) {
            //e.printStackTrace();
            throw new IllegalArgumentException(String.format("Can't transform for %s", data), e);
        }

        try {
            return bos.toString("utf-8");
        } catch (UnsupportedEncodingException e) {
            log.error(e);
            return null;
        }

    }

    private static void generateElement(Element parent, Map<String, Object> data) {
        Document doc = parent.getOwnerDocument();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            Element element = doc.createElement(entry.getKey());
            parent.appendChild(element);
            Object value = entry.getValue();
            if (value instanceof HashMap) {
                //noinspection unchecked
                generateElement(element, (Map<String, Object>) value);
            } else {
                element.setTextContent(value.toString());
            }
        }
    }
}
