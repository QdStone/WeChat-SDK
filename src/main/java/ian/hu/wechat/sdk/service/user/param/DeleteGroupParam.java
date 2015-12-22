package ian.hu.wechat.sdk.service.user.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.user.Group;

import java.io.Serializable;

/**
 * 删除分组参数
 */
public class DeleteGroupParam implements Serializable {
    @JsonProperty("group")
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public DeleteGroupParam() {
    }

    public DeleteGroupParam(Integer groupId) {
        this.group = new Group(groupId, null);
    }
}
