package ian.hu.wechat.sdk.service.user.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.service.core.result.Result;

import java.util.ArrayList;

/**
 * 获取所有分组结果
 */
public class GetGroupsResult extends Result {
    @JsonProperty("groups")
    private ArrayList<GroupItem> groups;

    public ArrayList<GroupItem> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<GroupItem> groups) {
        this.groups = groups;
    }

    @Override
    public Integer getErrorCode() {
        return groups != null ? 0 : super.getErrorCode();
    }

    @Override
    public String toString() {
        return "GetGroupsResult{" +
                "errorCode=" + getErrorCode() +
                ", errorMessage='" + getErrorMessage() + '\'' +
                ", groups=" + groups +
                '}';
    }
}
