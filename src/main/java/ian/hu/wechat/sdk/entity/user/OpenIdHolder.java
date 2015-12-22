package ian.hu.wechat.sdk.entity.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * OpenId
 */
public class OpenIdHolder implements Serializable {
    @JsonProperty("openid")
    private String openId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "OpenIdHolder{" +
                "openId='" + openId + '\'' +
                '}';
    }

    public OpenIdHolder() {
    }

    public OpenIdHolder(String openId) {
        this.openId = openId;
    }
}
