package ian.hu.wechat.sdk.service.user.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.user.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 删除分组参数
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteGroupParam implements Serializable {
    private static final long serialVersionUID = 2051526489066138500L;
    @JsonProperty("group")
    private Group group;

    public DeleteGroupParam(Integer groupId) {
        this.group = new Group(groupId, null);
    }
}
