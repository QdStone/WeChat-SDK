package ian.hu.wechat.sdk.entity.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * AccessToken
 */
public class AccessToken implements Serializable {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private Integer expiresIn;

    /**
     * 获取AccessToken的文本值
     * @return AccessToken的文本值
     */
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * 获取有效时长
     * @return 单位：秒
     */
    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "accessToken='" + accessToken + '\'' +
                ", expiresIn=" + expiresIn +
                '}';
    }
}
