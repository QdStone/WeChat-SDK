package ian.hu.wechat.sdk.service.user.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.user.Group;

/**
 * 单个分组情况
 */
public class GroupItem extends Group {
    @JsonProperty("count")
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "GroupItem{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", count=" + count +
                '}';
    }
}
