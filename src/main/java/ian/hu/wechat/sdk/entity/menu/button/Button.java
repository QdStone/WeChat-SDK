package ian.hu.wechat.sdk.entity.menu.button;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 带type的按钮
 */
public abstract class Button extends AbstractButton {

    private static final long serialVersionUID = 2916012291360524910L;

    protected Button() {
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
