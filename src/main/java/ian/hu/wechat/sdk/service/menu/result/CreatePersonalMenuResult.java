package ian.hu.wechat.sdk.service.menu.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.service.Errors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 创建个性化菜单
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CreatePersonalMenuResult extends CreateResult {
    private static final long serialVersionUID = 6317736134979773391L;
    @JsonProperty("menuid")
    private Long menuId;

    @Override
    public Long getErrorCode() {
        return menuId != null ? Errors.OK.getCode() : super.getErrorCode();
    }
}
