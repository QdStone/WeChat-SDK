package ian.hu.wechat.sdk.entity.response;

import ian.hu.wechat.sdk.utils.MashallerUtils;
import ian.hu.wechat.sdk.utils.WeChatUtils;
import ian.hu.wechat.sdk.entity.message.AesEncryptMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 使用AES加密的响应
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class AesEncryptResponse implements EncryptResponse {

    private static final Log logger = LogFactory.getLog(AesEncryptMessage.class);

    @XmlElement(name = "Encrypt")
    private String encrypt;
    @XmlElement(name = "MsgSignature")
    private String msgSignature;
    @XmlElement(name = "TimeStamp")
    private Long timeStamp;
    @XmlElement(name = "Nonce")
    private String nonce;

    public String getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }

    public String getMsgSignature() {
        return msgSignature;
    }

    public void setMsgSignature(String msgSignature) {
        this.msgSignature = msgSignature;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    @Override
    public String toString() {
        return "AesEncryptResponse{" +
                "encrypt='" + encrypt + '\'' +
                ", msgSignature='" + msgSignature + '\'' +
                ", timeStamp=" + timeStamp +
                ", nonce='" + nonce + '\'' +
                '}';
    }

    public RawResponse toRaw(String aesKey) {
        try {
            String raw = WeChatUtils.decrypt(encrypt, aesKey);
            return MashallerUtils.fromXml(raw, RawResponse.class);
        } catch (Exception e) {
            logger.debug("decrypt failed", e);
            return null;
        }
    }


    public RawResponse toRaw(String... args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("'args' should be only 1 elements as it will be the aesKey");
        }
        return toRaw(args[0]);
    }

    public EncryptResponse fromRaw(RawResponse response, String aesKey, String appId, String token, String nonce, Long timestamp) {
        try {
            String raw = MashallerUtils.toXml(response);
            encrypt = WeChatUtils.encrypt(raw, aesKey, appId);
            msgSignature = WeChatUtils.getSHA1ForMessage(encrypt, token, nonce, timestamp);
            nonce = nonce;
            timeStamp = timestamp;
            return this;
        } catch (Exception e) {
            logger.debug("encrypt failed", e);
            return null;
        }
    }

    public EncryptResponse fromRaw(RawResponse response, String... args) {
        if (args.length != 5) {
            throw new IllegalArgumentException("'args' should have 5 elements");
        }
        return fromRaw(response, args[0], args[1], args[2], args[3], Long.valueOf(args[4]));
    }
}
