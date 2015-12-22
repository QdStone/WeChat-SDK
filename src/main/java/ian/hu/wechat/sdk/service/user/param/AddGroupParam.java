package ian.hu.wechat.sdk.service.user.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.user.Group;

import java.io.Serializable;

/**
 * 添加分组参数
 */
public class AddGroupParam implements Serializable {
    @JsonProperty("group")
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "AddGroupParam{" +
                "group=" + group +
                '}';
    }

    public AddGroupParam() {
    }

    public AddGroupParam(String name) {
        this.group = new Group(null, name);
    }
}
