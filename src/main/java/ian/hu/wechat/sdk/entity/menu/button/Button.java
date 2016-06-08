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

package ian.hu.wechat.sdk.entity.menu.button;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 带type的按钮
 */
public abstract class Button extends AbstractButton {

    private static final long serialVersionUID = 2916012291360524910L;

    protected Button() {
        //type = defaultType();
    }

    @JsonProperty("type")
    protected String type;

    public String getType() {
        if (type == null) {
            type = defaultType();
        }
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract String defaultType();
}
