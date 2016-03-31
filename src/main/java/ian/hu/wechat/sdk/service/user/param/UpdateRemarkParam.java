package ian.hu.wechat.sdk.service.user.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 修改备注参数
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRemarkParam implements Serializable {
    private static final long serialVersionUID = -1457201580758543609L;
    private String openId;
    private String remark;}
