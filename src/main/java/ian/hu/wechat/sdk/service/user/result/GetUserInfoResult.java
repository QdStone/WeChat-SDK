package ian.hu.wechat.sdk.service.user.result;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import ian.hu.wechat.sdk.entity.user.UserInfo;
import ian.hu.wechat.sdk.service.core.result.Result;
import lombok.*;

/**
 * 获取用户信息结果
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GetUserInfoResult extends Result {
    private static final long serialVersionUID = 8490626923960650562L;
    @JsonUnwrapped
    private UserInfo info;

    @Override
    public Integer getErrorCode() {
        return info != null && info.getSubscribe() != null ? 0 : super.getErrorCode();
    }
}