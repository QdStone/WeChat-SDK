/*
 *
 *  * Copyright 2014-2016 the original author or authors.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package ian.hu.wechat.sdk.entity.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.menu.button.AbstractButton;
import ian.hu.wechat.sdk.entity.message.RawMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * 自定义菜单结构
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Menu implements Serializable {

    public static final String TYPE_CLICK = RawMessage.EVENT_MENU_CLICK.toLowerCase(Locale.ENGLISH);
    public static final String TYPE_VIEW = RawMessage.EVENT_MENU_VIEW.toLowerCase(Locale.ENGLISH);
    public static final String TYPE_VIEW_LIMIT = "view_limited";
    public static final String TYPE_MEDIA_ID = "media_id";
    public static final String TYPE_LOCATION_SELECT = RawMessage.EVENT_MENU_LOCATION_SELECT;
    public static final String TYPE_SCANCODE_WAITMSG = RawMessage.EVENT_MENU_SCANCODE_WAITMSG;
    public static final String TYPE_SCANCODE_PUSH = RawMessage.EVENT_MENU_SCANCODE_PUSH;
    public static final String TYPE_PIC_WEIXIN = RawMessage.EVENT_MENU_PIC_WEIXIN;
    public static final String TYPE_PIC_PHOTO_OR_ALBUM = RawMessage.EVENT_MENU_PIC_PHOTO_OR_ALBUM;
    public static final String TYPE_PIC_SYSPHOTO = RawMessage.EVENT_MENU_PIC_SYSPHOTO;
    private static final long serialVersionUID = -2759175785334240452L;

    /**
     * 菜单按钮
     */
    @SuppressWarnings("FieldMayBeFinal")
    @JsonProperty("button")
    private final List<AbstractButton> buttons = new ArrayList<AbstractButton>();
    @JsonProperty("menuid")
    private Long menuId;

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

}

