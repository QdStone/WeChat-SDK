package ian.hu.wechat.sdk.entity.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.menu.button.AbstractButton;
import ian.hu.wechat.sdk.entity.menu.button.Click;
import ian.hu.wechat.sdk.entity.menu.button.ViewLimited;
import ian.hu.wechat.sdk.entity.message.RawMessage;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 自定义菜单结构
 */
public class Menu implements Serializable {

    public static final String TYPE_CLICK = RawMessage.EVENT_MENU_CLICK.toLowerCase();
    public static final String TYPE_VIEW = RawMessage.EVENT_MENU_VIEW.toLowerCase();
    public static final String TYPE_VIEW_LIMIT = "view_limited";
    public static final String TYPE_MEDIA_ID = "media_id";
    public static final String TYPE_LOCATION_SELECT = RawMessage.EVENT_MENU_LOCATION_SELECT;
    public static final String TYPE_SCANCODE_WAITMSG = RawMessage.EVENT_MENU_SCANCODE_WAITMSG;
    public static final String TYPE_SCANCODE_PUSH = RawMessage.EVENT_MENU_SCANCODE_PUSH;
    public static final String TYPE_PIC_WEIXIN = RawMessage.EVENT_MENU_PIC_WEIXIN;
    public static final String TYPE_PIC_PHOTO_OR_ALBUM = RawMessage.EVENT_MENU_PIC_PHOTO_OR_ALBUM;
    public static final String TYPE_PIC_SYSPHOTO = RawMessage.EVENT_MENU_PIC_SYSPHOTO;

    @JsonProperty("button")
    private ArrayList<AbstractButton> buttons = new ArrayList<AbstractButton>();

    public ArrayList<AbstractButton> getButtons() {
        return buttons;
    }

    public void setButtons(ArrayList<AbstractButton> buttons) {
        this.buttons = buttons;
    }

    public Boolean add(AbstractButton button) {
        if (buttons.size() >= 3) {
            return false;
        }
        buttons.add(button);
        return true;
    }

    public void remove(int index) {
        buttons.remove(index);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "buttons=" + buttons +
                '}';
    }

}

