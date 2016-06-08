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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 子菜单
 */
public class SubButton extends AbstractButton {

    private static final long serialVersionUID = 6910110003783707954L;
    @JsonProperty("sub_button")
    protected List<AbstractButton> subButtons = new ArrayList<AbstractButton>();

    public SubButton() {
    }

    public SubButton(String name) {
        setName(name);
    }

    public List<AbstractButton> getSubButtons() {
        return Collections.unmodifiableList(subButtons);
    }

    public void setSubButtons(List<AbstractButton> subButtons) {
        this.subButtons = subButtons;
    }

    public Boolean add(AbstractButton button) {
        if (subButtons.size() >= 5) {
            return false;
        }
        subButtons.add(button);
        return true;
    }

    @Override
    public String toString() {
        return "SubButton{" +
                "name=" + getName() +
                ",subButtons=" + subButtons +
                '}';
    }
}
