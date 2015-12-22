package ian.hu.wechat.sdk.service.user.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.service.core.result.Result;

/**
 * 获取用户所在分组
 */
public class GetUserGroupResult extends Result {
    @JsonProperty("groupid")
    private Integer groupId;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public Integer getErrorCode() {
        return groupId != null ? 0 : super.getErrorCode();
    }

    @Override
    public String toString() {
        return "GetUserGroupResult{" +
                "errorCode=" + getErrorCode() +
                ", errorMessage='" + getErrorMessage() + '\'' +
                ", groupId=" + groupId +
                '}';
    }
}
