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

package ian.hu.wechat.sdk.service.user.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.user.Group;
import ian.hu.wechat.sdk.service.Errors;
import ian.hu.wechat.sdk.service.core.result.Result;
import lombok.*;

/**
 * 新建分组结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AddGroupResult extends Result {
    private static final long serialVersionUID = 434039065758856026L;
    @JsonProperty("group")
    private Group group;

    @Override
    public Long getErrorCode() {
        return getGroup() != null ? Errors.OK.getCode() : super.getErrorCode();
    }
}
