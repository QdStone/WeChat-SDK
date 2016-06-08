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

package ian.hu.wechat.sdk.service.user.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.user.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 删除分组参数
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteGroupParam implements Serializable {
    private static final long serialVersionUID = 2051526489066138500L;
    @JsonProperty("group")
    private Group group;

    public DeleteGroupParam(Integer groupId) {
        group = new Group(groupId, null);
    }
}
