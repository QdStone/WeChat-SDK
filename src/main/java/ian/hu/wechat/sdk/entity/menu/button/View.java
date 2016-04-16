package ian.hu.wechat.sdk.entity.menu.button;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.menu.Menu;

/**
 * 打开链接
 */
public class View extends Button {

    private static final long serialVersionUID = -4564228043958260200L;
    @JsonProperty("url")
    protected String url;

    public View() {
    }

    public View(String name, String url) {
        this();
        setName(name);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String defaultType() {
        return Menu.TYPE_VIEW;
    }

    @Override
    public String toString() {
        return "View{" +
                "type=" + type +
                ",name=" + getName() +
                ",url='" + url + '\'' +
                '}';
    }
}
