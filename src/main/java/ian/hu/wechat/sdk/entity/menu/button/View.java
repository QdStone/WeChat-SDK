package ian.hu.wechat.sdk.entity.menu.button;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.menu.Menu;

/**
 * Created by ian on 15/12/12.
 */
public class View extends Button {

    @JsonProperty("url")
    protected String url;

    public View() {
        super();
    }

    public View(String name, String url) {
        this();
        this.setName(name);
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
        return Menu.TYPE_VIEW.toLowerCase();
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
