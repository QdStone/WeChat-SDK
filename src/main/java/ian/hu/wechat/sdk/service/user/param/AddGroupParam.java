package ian.hu.wechat.sdk.service.user.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.user.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 添加分组参数
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddGroupParam implements Serializable {
    private static final long serialVersionUID = -6742776224461987802L;
    @JsonProperty("group")
    private Group group;

    public AddGroupParam(String name) {
        group = new Group(null, name);
    }
}
