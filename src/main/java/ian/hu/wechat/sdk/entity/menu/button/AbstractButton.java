package ian.hu.wechat.sdk.entity.menu.button;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import ian.hu.wechat.sdk.entity.menu.Menu;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ian on 15/12/12.
 */
public abstract class AbstractButton implements Serializable {

    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonCreator
    public static AbstractButton createAbstractButton(@JsonProperty("name") String name, @JsonProperty("key") String key, @JsonProperty("url") String url, @JsonProperty("type") String type, @JsonProperty("media_id") String mediaId, @JsonProperty("sub_button") ArrayList<AbstractButton> subButtons) throws JsonMappingException {
        if (Menu.TYPE_CLICK.equals(type)) {
            return new Click(name, key);
        }
        if (Menu.TYPE_SCANCODE_WAITMSG.equals(type)) {
            return new ScanWait(name, key);
        }
        if (Menu.TYPE_SCANCODE_PUSH.equals(type)) {
            return new ScanPush(name, key);
        }
        if (Menu.TYPE_LOCATION_SELECT.equals(type)) {
            return new LocationSelect(name, key);
        }
        if (Menu.TYPE_PIC_SYSPHOTO.equals(type)) {
            return new PicSysPhoto(name, key);
        }
        if (Menu.TYPE_PIC_PHOTO_OR_ALBUM.equals(type)) {
            return new PicPhotoOrAlbum(name, key);
        }
        if (Menu.TYPE_PIC_WEIXIN.equals(type)) {
            return new PicWeiXin(name, key);
        }
        if (Menu.TYPE_VIEW.equals(type)) {
            return new View(name, url);
        }
        if (Menu.TYPE_MEDIA_ID.equals(type)) {
            return new MediaId(name, mediaId);
        }
        if (Menu.TYPE_VIEW_LIMIT.equals(type)) {
            return new ViewLimited(name, mediaId);
        }
        if (subButtons != null) {
            SubButton button = new SubButton(name);
            button.setSubButtons(subButtons);
            return button;
        }
        throw new JsonMappingException(String.format("Menu item for type: %s is not supported yet.", type));
    }
}
