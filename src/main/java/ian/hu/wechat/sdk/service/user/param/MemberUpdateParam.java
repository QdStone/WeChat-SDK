package ian.hu.wechat.sdk.service.user.param;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 移动分组参数
 */
public class MemberUpdateParam implements Serializable {
    @JsonProperty("openid")
    private String openId;
    @JsonProperty("to_groupid")
    private Integer toGroupId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getToGroupId() {
        return toGroupId;
    }

    public void setToGroupId(Integer toGroupId) {
        this.toGroupId = toGroupId;
    }

    public MemberUpdateParam() {
    }

    public MemberUpdateParam(String openId, Integer toGroupId) {
        this.openId = openId;
        this.toGroupId = toGroupId;
    }
}
