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
import ian.hu.wechat.sdk.entity.media.NewsItem;
import ian.hu.wechat.sdk.service.Errors;
import ian.hu.wechat.sdk.service.core.result.Result;
import lombok.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.List;

/**
 * 获取永久素材的结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GetMaterialResult extends Result implements CompositeResult {
    private static final long serialVersionUID = -2834498108596951457L;
    private String fileName;
    private File file;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("down_url")
    private String downloadUrl;
    @JsonProperty("news_item")
    private List<NewsItem> newsItems;

    public String getFileName() {
        return fileName;
    }

    @Override
    public MediaType fromMediaType() {
        return MediaType.valueOf("text/plain");
    }

    @Override
    public MediaType toMediaType() {
        return MediaType.APPLICATION_JSON_TYPE;
    }

    @Override
    public void setErrorCode(Integer errorCode) {
        super.setErrorCode(errorCode);
    }


    @Override
    public Long getErrorCode() {
        return newsItems != null || downloadUrl != null || file != null ? Errors.OK.getCode() : super.getErrorCode();
    }


    public static GetMaterialResult from(Response response) {
        return ResultHelper.from(response, GetMaterialResult.class);
    }
}
