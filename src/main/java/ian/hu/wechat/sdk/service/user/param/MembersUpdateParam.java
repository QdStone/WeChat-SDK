package ian.hu.wechat.sdk.service.user.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 批量移动分组
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MembersUpdateParam implements Serializable {
    private static final long serialVersionUID = -4627714453887345524L;
    @JsonProperty("openid_list")
    private List<String> openIds;
    @JsonProperty("to_groupid")
    private Integer toGroupId;

    public MembersUpdateParam(Integer toGroupId, String... openIds) {
        this.toGroupId = toGroupId;
        this.openIds = Arrays.asList(openIds);
    }
}
