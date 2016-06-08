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

package ian.hu.wechat.sdk.service.menu.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.menu.Menu;
import ian.hu.wechat.sdk.entity.menu.PersonalMenu;
import ian.hu.wechat.sdk.service.Errors;
import ian.hu.wechat.sdk.service.core.result.Result;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 获取菜单的返回结果
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GetResult extends Result {
    private static final long serialVersionUID = 5776975408194272503L;
    @JsonProperty("menu")
    protected Menu menu;
    @JsonProperty("conditionalmenu")
    protected List<PersonalMenu> personalMenus;


    @Override
    public Long getErrorCode() {
        return menu != null ? Errors.OK.getCode() : super.getErrorCode();
    }

}
