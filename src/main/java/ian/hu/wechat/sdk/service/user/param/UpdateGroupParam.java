package ian.hu.wechat.sdk.service.user.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.user.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 修改分组参数
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateGroupParam {
    @JsonProperty("group")
    private Group group;
}