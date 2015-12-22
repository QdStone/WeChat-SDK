package ian.hu.wechat.sdk.service.user.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.user.Group;

/**
 * 修改分组参数
 */
public class UpdateGroupParam {
    @JsonProperty("group")
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public UpdateGroupParam() {
    }

    public UpdateGroupParam(Group group) {
        this.group = group;
    }
}
