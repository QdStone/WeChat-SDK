package ian.hu.wechat.sdk.service.menu.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.menu.Menu;
import ian.hu.wechat.sdk.entity.menu.PersonalMenu;
import ian.hu.wechat.sdk.service.Errors;
import ian.hu.wechat.sdk.service.core.result.Result;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 获取菜单的返回结果
 */
@Data
@EqualsAndHashCode
public class GetResult extends Result {
    private static final long serialVersionUID = 5776975408194272503L;
    @JsonProperty("menu")
    protected Menu menu;
    @JsonProperty("conditionalmenu")
    protected List<PersonalMenu> personalMenus;


    @Override
    public Long getErrorCode() {
        return menu != null ? Errors.OK.getCode() : super.getErrorCode();
    }

}
