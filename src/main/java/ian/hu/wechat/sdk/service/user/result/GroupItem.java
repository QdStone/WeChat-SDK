package ian.hu.wechat.sdk.service.user.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.user.Group;
import lombok.*;

/**
 * 单个分组情况
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupItem extends Group {
    private static final long serialVersionUID = 191907320973352227L;
    @JsonProperty("count")
    private Integer count;
}
