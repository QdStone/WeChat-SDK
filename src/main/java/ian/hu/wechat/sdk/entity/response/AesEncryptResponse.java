/*
 * Copyright 2014-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ian.hu.wechat.sdk.entity.response;

import ian.hu.wechat.sdk.utils.MashallerUtils;
import ian.hu.wechat.sdk.utils.WeChatUtils;

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

    private static final long serialVersionUID = 327205894803250977L;

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
        } catch (Exception ignored) {
            //logger.debug("decrypt failed", e);
            return null;
        }
    }


    @Override
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
            timeStamp = timestamp;
            return this;
        } catch (Exception ignored) {
            //logger.debug("encrypt failed", e);
            return null;
        }
    }

    @Override
    public EncryptResponse fromRaw(RawResponse response, String... args) {
        if (args.length != 5) {
            throw new IllegalArgumentException("'args' should have 5 elements");
        }
        return fromRaw(response, args[0], args[1], args[2], args[3], Long.valueOf(args[4]));
    }
}
