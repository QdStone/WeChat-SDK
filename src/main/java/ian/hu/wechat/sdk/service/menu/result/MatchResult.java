package ian.hu.wechat.sdk.service.menu.result;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import ian.hu.wechat.sdk.entity.menu.Menu;
import ian.hu.wechat.sdk.service.Errors;
import ian.hu.wechat.sdk.service.core.result.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 菜单匹配结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MatchResult extends Result {
    private static final long serialVersionUID = 7894644579965879068L;

    @JsonUnwrapped
    private Menu menu;

    @Override
    public Long getErrorCode() {
        return menu != null && menu.getButtons() != null ? Errors.OK.getCode() : super.getErrorCode();
    }
}
