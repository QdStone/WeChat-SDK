package ian.hu.wechat.sdk.entity.message;

import ian.hu.wechat.sdk.utils.MashallerUtils;
import ian.hu.wechat.sdk.utils.WeChatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 使用AES加密的消息
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class AesEncryptMessage implements EncryptMessage {

    private static final Log logger = LogFactory.getLog(AesEncryptMessage.class);

    @XmlElement(name = "ToUserName")
    private String toUserName;

    @XmlElement(name = "Encrypt")
    private String encrypt;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }

    @Override
    public String toString() {
        return "AesEncryptMessage{" +
                "toUserName='" + toUserName + '\'' +
                ", encrypt='" + encrypt + '\'' +
                '}';
    }

    public AesEncryptMessage fromRaw(RawMessage message, String aesKey, String appId) {
        AesEncryptMessage msg = this;
        msg.setToUserName(message.getToUserName());
        try {
            String raw = MashallerUtils.toXml(message);
            String aes = WeChatUtils.encrypt(raw, aesKey, appId);
            msg.setEncrypt(aes);
        } catch (Exception e) {
            logger.debug("encrypt failed", e);
            return null;
        }
        return msg;
    }

    public RawMessage toRaw(String aesKey) {
        try {
            String raw = WeChatUtils.decrypt(encrypt, aesKey);
            return MashallerUtils.fromXml(raw, RawMessage.class);
        } catch (Exception e) {
            logger.debug("decrypt failed", e);
            return null;
        }

    }

    public RawMessage toRaw(String... args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("'args' should contains only 1 element as it will be the aesKey");
        }
        return toRaw(args[0]);
    }

    public EncryptMessage fromRaw(RawMessage message, String... args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("'args' should contains only 2 elements as it will be the aesKey and appId");
        }
        return fromRaw(message, args[0], args[1]);
    }

    public String getSignature(String... args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("'args' should be only 3 elements.");
        }
        return WeChatUtils.getSHA1ForMessage(encrypt, args[0], args[1], Long.valueOf(args[2]));
    }

    public String getSignature(String token, String nonce, Long timestamp) {
        return WeChatUtils.getSHA1ForMessage(encrypt, token, nonce, timestamp);
    }
}
