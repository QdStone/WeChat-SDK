/*
 * Copyright 2014-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ian.hu.wechat.sdk.entity.menu.button;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import ian.hu.wechat.sdk.entity.menu.Menu;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 抽象的菜单按钮
 */
public abstract class AbstractButton implements Serializable {

    private static final long serialVersionUID = -6432583450368104661L;

    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 用于给JSON反序列化构建
     *
     * @param name       菜单名称
     * @param key        菜单key值
     * @param url        菜单url
     * @param type       菜单类型
     * @param mediaId    如果是view_limited，则为其media_id
     * @param subButtons 子菜单，如果有
     * @return 菜单按钮
     * @throws JsonMappingException
     */
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
