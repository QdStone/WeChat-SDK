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

package ian.hu.wechat.sdk.service.media.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.rest.annotation.OverrideMediaType;
import ian.hu.wechat.sdk.service.core.result.Result;
import lombok.*;

import javax.ws.rs.core.MediaType;

/**
 * 添加其他素材的结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@OverrideMediaType(MediaType.APPLICATION_JSON)
public class AddMaterialResult extends Result {
    private static final long serialVersionUID = -8984221831942768245L;
    @JsonProperty("media_id")
    private String mediaId;
    @JsonProperty("url")
    private String url;
}
