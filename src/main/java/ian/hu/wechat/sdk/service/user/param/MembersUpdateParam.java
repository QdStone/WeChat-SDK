package ian.hu.wechat.sdk.service.user.param;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 批量移动分组
 */
public class MembersUpdateParam implements Serializable {
    @JsonProperty("openid_list")
    private ArrayList<String> openIds;
    @JsonProperty("to_groupid")
    private Integer toGroupId;

    public ArrayList<String> getOpenIds() {
        return openIds;
    }

    public void setOpenIds(ArrayList<String> openIds) {
        this.openIds = openIds;
    }

    public Integer getToGroupId() {
        return toGroupId;
    }

    public void setToGroupId(Integer toGroupId) {
        this.toGroupId = toGroupId;
    }

    public MembersUpdateParam() {
    }

    public MembersUpdateParam(ArrayList<String> openIds, Integer toGroupId) {
        this.openIds = openIds;
        this.toGroupId = toGroupId;
    }

    public MembersUpdateParam(Integer toGroupId, String... openIds) {
        this.toGroupId = toGroupId;
        this.openIds = new ArrayList<String>(Arrays.asList(openIds));
    }
}
