package ian.hu.wechat.sdk.service.menu.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.service.core.result.Result;
import ian.hu.wechat.sdk.entity.menu.Menu;

/**
 * 获取菜单的返回结果
 */
public class GetResult extends Result {
    @JsonProperty("menu")
    protected Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public Integer getErrorCode() {
        return menu != null ? 0 : super.getErrorCode();
    }

    @Override
    public String toString() {
        return "GetResult{" +
                "errorCode=" + getErrorCode() +
                ", errorMsg='" + getErrorMessage() + '\'' +
                ", menu=" + menu +
                '}';
    }
}
