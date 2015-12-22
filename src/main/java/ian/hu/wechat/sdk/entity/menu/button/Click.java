package ian.hu.wechat.sdk.entity.menu.button;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.menu.Menu;

/**
 * Created by ian on 15/12/12.
 */
public class Click extends Button {

    @JsonProperty("key")
    protected String key;

    public Click() {
        super();
    }

    public Click(String name, String key) {
        this();
        this.setName(name);
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
        return Menu.TYPE_CLICK.toLowerCase();
    }

    @Override
    public String toString() {
        return "Click{" +
                "type=" + type +
                ",name=" + getName() +
                ",key='" + key + '\'' +
                '}';
    }
}
