package ian.hu.wechat.sdk.entity.response;

import java.io.Serializable;

/**
 * 加密的消息的接口
 */
public interface EncryptResponse extends Serializable {
    /**
     * 转化为RawResponse
     *
     * @param args 解密相关参数
     * @return 转化失败反悔null
     */
    RawResponse toRaw(String... args);

    /**
     * 从RawResponse填充此对象
     *
     * @param response response
     * @param args     加密相关参数
     * @return 加密失败反回null
     */
    EncryptResponse fromRaw(RawResponse response, String... args);
}
