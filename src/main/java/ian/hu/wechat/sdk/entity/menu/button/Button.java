package ian.hu.wechat.sdk.entity.menu.button;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ian on 15/12/12.
 */
public abstract class Button extends AbstractButton {

    public Button() {
        type = defaultType();
    }

    @JsonProperty("type")
    protected String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract String defaultType();
}
