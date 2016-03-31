package ian.hu.wechat.sdk.service.core.result;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import ian.hu.wechat.sdk.entity.core.AccessToken;

/**
 * 获取AccessToken的结果
 */
public class AccessTokenResult extends Result {
    private static final long serialVersionUID = -1840549668432357528L;
    @JsonUnwrapped
    private AccessToken accessToken;

    /**
     * 返回获取到的accessToken
     *
     * @return 获取失败时为null
     */
    public AccessToken getAccessToken() {
        return accessToken == null || accessToken.getAccessToken() == null ? null : accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public Integer getErrorCode() {
        return getAccessToken() == null ? super.getErrorCode() : 0;
    }

    @Override
    public String toString() {
        return "AccessTokenResult{" +
                "accessToken=" + getAccessToken() +
                ", errorCode=" + getErrorCode() +
                ", errorMessage='" + getErrorMessage() + '\'' +
                '}';
    }
}
