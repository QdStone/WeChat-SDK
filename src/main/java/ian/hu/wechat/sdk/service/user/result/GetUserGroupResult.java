package ian.hu.wechat.sdk.service.user.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.service.Errors;
import ian.hu.wechat.sdk.service.core.result.Result;
import lombok.*;

/**
 * 获取用户所在分组
 */
@Data
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GetUserGroupResult extends Result {
    private static final long serialVersionUID = 7556032087460434999L;
    @JsonProperty("groupid")
    private Integer groupId;
    @Override
    public Long getErrorCode() {
        return groupId != null ? Errors.OK.getCode() : super.getErrorCode();
    }
}
