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
