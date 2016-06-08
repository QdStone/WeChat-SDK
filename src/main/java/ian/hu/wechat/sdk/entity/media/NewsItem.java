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

package ian.hu.wechat.sdk.entity.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 单条图文素材
 */
@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor
public class NewsItem implements Serializable {
    private static final long serialVersionUID = -5674160610668369393L;

    /**
     * 图文消息的标题
     */
    @JsonProperty("title")
    private String title;

    /**
     * 图文消息的封面图片素材id（必须是永久mediaID）
     */
    @JsonProperty("thumb_media_id")
    private String thumbMediaId;

    /**
     * 是否显示封面，0为false，即不显示，1为true，即显示
     */
    @JsonProperty("show_cover_pic")
    private Integer showCoverPic;

    /**
     * 作者
     */
    @JsonProperty("author")
    private String author;

    /**
     * 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
     */
    @JsonProperty("digest")
    private String digest;

    /**
     * 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
     */
    @JsonProperty("content")
    private String content;

    @JsonProperty("url")
    private String url;

    /**
     * 图文消息的原文地址，即点击“阅读原文”后的URL
     */
    @JsonProperty("content_source_url")
    private String contentSourceUrl;

}
