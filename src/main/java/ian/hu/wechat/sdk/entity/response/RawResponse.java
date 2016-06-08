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

package ian.hu.wechat.sdk.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 对微信的原始回复
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class RawResponse implements Serializable {

    public static final String TYPE_TEXT = "text";
    public static final String TYPE_IMAGE = "image";
    public static final String TYPE_VOICE = "voice";
    public static final String TYPE_VIDEO = "video";
    public static final String TYPE_MUSIC = "music";
    public static final String TYPE_NEWS = "news";
    private static final long serialVersionUID = 1127462516748673430L;

    private boolean stop;

    @XmlElement(name = "ToUserName")
    private String toUserName;
    @XmlElement(name = "FromUserName")
    private String fromUserName;
    @SuppressWarnings("FieldMayBeFinal")
    @XmlElement(name = "CreateTime")
    private Long createTime = System.currentTimeMillis();

    /**
     * 消息类型
     */
    @XmlElement(name = "MsgType")
    private String msgType;

    /**
     * text:文本内容
     */
    @XmlElement(name = "Content")
    private String content;

    @XmlElement(name = "Image")
    private MediaIdHolder image;

    @XmlElement(name = "Voice")
    private MediaIdHolder voice;

    @XmlElement(name = "Video")
    private Video video;

    @XmlElement(name = "Music")
    private Music music;

    @XmlElementWrapper(name = "Articles")
    @XmlElements(@XmlElement(name = "item", type = Article.class))
    private ArrayList<Article> articles;

    @XmlElement(name = "ArticleCount")
    public Integer getArticleCount() {
        return getArticles() == null || getArticles().size() < 1 ? null : getArticles().size();
    }

    public Boolean addArticle(Article article) {
        if (getArticles() == null) {
            setArticles(new ArrayList<Article>());
        }
        if (getArticles().size() >= 10) {
            return Boolean.FALSE;
        }
        getArticles().add(article);
        return Boolean.TRUE;
    }

    public static boolean isStop(RawResponse response) {
        return response != null && response.stop;
    }

    public static boolean isVoid(RawResponse response) {
        return response == null || Builder.NO_RESPONSE.equals(response);
    }

    @Data

    @NoArgsConstructor
    @AllArgsConstructor
    @XmlAccessorType(XmlAccessType.NONE)
    public static class MediaIdHolder implements Serializable {
        private static final long serialVersionUID = -8769121318036495411L;
        @XmlElement(name = "MediaId")
        private String mediaId;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Video extends MediaIdHolder {
        private static final long serialVersionUID = 3591760585510187834L;
        @XmlElement(name = "Title")
        private String title;
        @XmlElement(name = "Description")
        private String description;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Music implements Serializable {
        private static final long serialVersionUID = 4844265006661582146L;
        @XmlElement(name = "Title")
        private String title;
        @XmlElement(name = "Description")
        private String description;
        @XmlElement(name = "MusicUrl")
        private String musicUrl;
        @XmlElement(name = "HQMusicUrl")
        private String musicUrlHQ;
        @XmlElement(name = "ThumbMediaId")
        private String thumbMediaId;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlAccessorType(XmlAccessType.NONE)
    public static class Article implements Serializable {
        private static final long serialVersionUID = 8452528763717866381L;
        @XmlElement(name = "Title")
        private String title;
        @XmlElement(name = "Description")
        private String description;
        @XmlElement(name = "PicUrl")
        private String picUrl;
        @XmlElement(name = "Url")
        private String url;
    }


    public static class Builder {

        public static final RawResponse NO_RESPONSE = new RawResponse();

        protected Builder() {
        }

        protected RawResponse response = new RawResponse();

        protected static Builder build(String from, String to, Long createTime, String type) {
            Builder builder = new Builder();
            builder.response.setFromUserName(from);
            builder.response.setToUserName(to);
            if (createTime != null) {
                builder.response.setCreateTime(createTime);
            }
            builder.response.setMsgType(type);
            return builder;
        }

        /**
         * 构建文本回复
         *
         * @param from 公众号id
         * @param to   用户id
         * @param text 文本内容
         * @return Builder.getService()获得构建的回复
         */
        public static Builder text(String from, String to, String text) {
            return build(from, to, null, TYPE_TEXT).setContent(text);
        }

        /**
         * 构建图片回复
         *
         * @param from    公众号id
         * @param to      用户Id
         * @param mediaId 图片的MediaId
         * @return Builder.getService()获得构建的回复
         */
        public static Builder image(String from, String to, String mediaId) {
            return build(from, to, null, TYPE_IMAGE).setImage(mediaId);
        }

        public static Builder voice(String from, String to, String mediaId) {
            return build(from, to, null, TYPE_VOICE).setVoice(mediaId);
        }

        public static Builder video(String from, String to, String mediaId, String title, String decription) {
            return build(from, to, null, TYPE_VIDEO).setVideo(mediaId, title, decription);
        }

        public static Builder news(String from, String to) {
            return build(from, to, null, TYPE_NEWS);
        }

        public static Builder music(String from, String to, String title, String description, String musicUrl, String musicUrlHQ, String thumbMediaId) {
            return build(from, to, null, TYPE_MUSIC).setMusic(title, description, musicUrl, musicUrlHQ, thumbMediaId);
        }

        public static Builder music(String from, String to) {
            return build(from, to, null, TYPE_MUSIC);
        }


        public Builder reset(String type) {
            RawResponse resp = new RawResponse();
            resp.setFromUserName(response.getFromUserName());
            resp.setToUserName(response.getToUserName());
            resp.setCreateTime(response.getCreateTime());
            resp.setMsgType(type);
            response = resp;
            return this;
        }

        public Builder ensure(String type) {
            if (!type.equals(response.getMsgType())) {
                reset(type);
            }
            return this;
        }

        public Builder setImage(String mediaId) {
            ensure(TYPE_IMAGE);
            response.setImage(new MediaIdHolder(mediaId));
            return this;
        }

        public Builder setVoice(String mediaId) {
            ensure(TYPE_VOICE);
            response.setVoice(new MediaIdHolder(mediaId));
            return this;
        }

        public Builder setVideo(String mediaId, String title, String description) {
            ensure(TYPE_VIDEO);
            Video v = new Video(title, description);
            v.setMediaId(mediaId);
            response.setVideo(v);
            return this;
        }

        public Builder setContent(String content) {
            ensure(TYPE_TEXT);
            response.setContent(content);
            return this;
        }

        public Builder setArticles(Article... articles) {
            ensure(TYPE_NEWS);
            response.setArticles(new ArrayList<Article>());
            Collections.addAll(response.getArticles(), articles);
            return this;
        }

        public Builder addArticle(Article article) {
            ensure(TYPE_NEWS);
            if (response.getArticles() == null) {
                response.setArticles(new ArrayList<Article>());
            }
            response.getArticles().add(article);
            return this;
        }

        public Builder addArticle(String title, String description, String picUrl, String url) {
            return addArticle(new Article(title, description, picUrl, url));
        }

        public Builder setMusic(String title, String description, String musicUrl, String musicUrlHQ, String thumbMediaId) {
            ensure(TYPE_MUSIC);
            response.setMusic(new Music(title, description, musicUrl, musicUrlHQ, thumbMediaId));
            return this;
        }

        /**
         * 获得构建的回复
         *
         * @return RawResponse
         */
        public RawResponse get() {
            return response;
        }

        /**
         * 取得停止回复
         *
         * @return StopResponse
         */
        public RawResponse stop() {
            response.stop = true;
            return get();
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "response=" + response +
                    '}';
        }
    }
}

