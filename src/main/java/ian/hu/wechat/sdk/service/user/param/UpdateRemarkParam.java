package ian.hu.wechat.sdk.service.user.param;

import java.io.Serializable;

/**
 * 修改备注参数
 */
public class UpdateRemarkParam implements Serializable {
    private String openId;
    private String remark;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "UpdateRemarkParam{" +
                "openId='" + openId + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public UpdateRemarkParam() {
    }

    public UpdateRemarkParam(String openId, String remark) {
        this.openId = openId;
        this.remark = remark;
    }
}
