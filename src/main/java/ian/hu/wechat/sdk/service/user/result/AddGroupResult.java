package ian.hu.wechat.sdk.service.user.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.user.Group;
import ian.hu.wechat.sdk.service.core.result.Result;
import lombok.*;

/**
 * 新建分组结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AddGroupResult extends Result {
    private static final long serialVersionUID = 434039065758856026L;
    @JsonProperty("group")
    private Group group;

    @Override
    public Integer getErrorCode() {
        return getGroup() != null ? 0 : super.getErrorCode();
    }
}
