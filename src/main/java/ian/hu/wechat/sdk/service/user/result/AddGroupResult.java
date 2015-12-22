package ian.hu.wechat.sdk.service.user.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.user.Group;
import ian.hu.wechat.sdk.service.core.result.Result;

/**
 * 新建分组结果
 */
public class AddGroupResult extends Result {
    @JsonProperty("group")
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public Integer getErrorCode() {
        return getGroup() != null ? 0 : super.getErrorCode();
    }

    @Override
    public String toString() {
        return "AddGroupResult{" +
                "errorCode=" + getErrorCode() +
                ", errorMessage='" + getErrorMessage() + '\'' +
                ", group=" + group +
                '}';
    }
}
