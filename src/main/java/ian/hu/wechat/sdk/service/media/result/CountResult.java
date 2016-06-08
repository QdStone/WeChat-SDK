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

package ian.hu.wechat.sdk.service.media.result;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import ian.hu.wechat.sdk.entity.media.MediaCount;
import ian.hu.wechat.sdk.service.core.result.Result;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CountResult extends Result {
    private static final long serialVersionUID = 3973137835057125082L;
    @JsonUnwrapped
    private MediaCount mediaCount;
}
