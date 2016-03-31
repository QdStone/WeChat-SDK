package ian.hu.wechat.sdk.entity.menu.button;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.menu.Menu;

/**
 * 点击拉取信息
 */
public class Click extends Button {

    private static final long serialVersionUID = -6116631433572736144L;
    @JsonProperty("key")
    protected String key;

    public Click() {
    }

    public Click(String name, String key) {
        this();
        setName(name);
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String defaultType() {
        return Menu.TYPE_CLICK;
    }
}
