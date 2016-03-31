package ian.hu.wechat.sdk.service.user.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 移动分组参数
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberUpdateParam implements Serializable {
    private static final long serialVersionUID = 5071617844045644529L;
    @JsonProperty("openid")
    private String openId;
    @JsonProperty("to_groupid")
    private Integer toGroupId;
}
