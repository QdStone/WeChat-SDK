package ian.hu.wechat.sdk.entity.message;

import java.io.Serializable;

/**
 * 加密的消息
 */
public interface EncryptMessage extends Serializable {
    /**
     * 解密
     *
     * @param args 解密参数
     * @return 解密失败反悔null
     */
    RawMessage toRaw(String... args);

    /**
     * 加密
     *
     * @param message
     * @param args    加密参数
     * @return 加密失败返回null
     */
    EncryptMessage fromRaw(RawMessage message, String... args);

    /**
     * 计算签名
     *
     * @param args 签名所用参数
     * @return 签名
     */
    String getSignature(String... args);
}
