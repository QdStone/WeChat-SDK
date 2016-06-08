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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 跳转图文页
 */
public class ViewLimited extends Button {

    private static final long serialVersionUID = 5225646528702063546L;
    /**
     * 图文素材的media_id
     */
    @JsonProperty("media_id")
    protected String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    /**
     * @param mediaId 图文素材media_id
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public ViewLimited() {
    }

    public ViewLimited(String name, String mediaId) {
        this();
    }

    @Override
    public String defaultType() {
        return "view_limited";
    }

    @Override
    public String toString() {
        return "ViewLimited{" +
                "type=" + type +
                ",name=" + getName() +
                ",mediaId='" + mediaId + '\'' +
                '}';
    }
}
