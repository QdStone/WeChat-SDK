package ian.hu.wechat.sdk.entity.response;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 对微信的原始回复
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class RawResponse implements Serializable {

    public static final String TYPE_TEXT = "text";
    public static final String TYPE_IMAGE = "image";
    public static final String TYPE_VOICE = "voice";
    public static final String TYPE_VIDEO = "video";
    public static final String TYPE_MUSIC = "music";
    public static final String TYPE_NEWS = "news";

    private boolean stop = false;

    @XmlElement(name = "ToUserName")
    private String toUserName;
    @XmlElement(name = "FromUserName")
    private String fromUserName;
    @XmlElement(name = "CreateTime")
    private Long createTime = System.currentTimeMillis();

    @XmlElement(name = "MsgType")
    private String msgType;

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

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 消息类型
     */
    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    /**
     * text:文本内容
     */
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MediaIdHolder getImage() {
        return image;
    }

    public void setImage(MediaIdHolder image) {
        this.image = image;
    }

    public MediaIdHolder getVoice() {
        return voice;
    }

    public void setVoice(MediaIdHolder voice) {
        this.voice = voice;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }


    public static boolean isStop(RawResponse response) {
        return response != null && response.stop;
    }

    public static boolean isVoid(RawResponse response) {
        return response == null || Builder.NO_RESPONSE.equals(response);
    }

    @XmlAccessorType(XmlAccessType.NONE)
    public static class MediaIdHolder implements Serializable {
        @XmlElement(name = "MediaId")
        private String mediaId;

        public MediaIdHolder() {
        }

        public MediaIdHolder(String mediaId) {
            this.setMediaId(mediaId);
        }

        @Override
        public String toString() {
            return "MediaIdHolder{" +
                    "mediaId='" + getMediaId() + '\'' +
                    '}';
        }

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    @XmlAccessorType(XmlAccessType.NONE)
    public static class Video extends MediaIdHolder {
        @XmlElement(name = "Title")
        private String title;
        @XmlElement(name = "Description")
        private String description;

        public Video() {
        }

        public Video(String mediaId, String title, String description) {
            this.setMediaId(mediaId);
            this.setTitle(title);
            this.setDescription(description);
        }

        @Override
        public String toString() {
            return "Video{" +
                    "mediaId='" + getMediaId() + '\'' +
                    ", title='" + getTitle() + '\'' +
                    ", description='" + getDescription() + '\'' +
                    '}';
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    @XmlAccessorType(XmlAccessType.NONE)
    public static class Music implements Serializable {
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

        public Music() {
        }

        public Music(String title, String description, String musicUrl, String musicUrlHQ, String thumbMediaId) {
            this.setTitle(title);
            this.setDescription(description);
            this.setMusicUrl(musicUrl);
            this.setMusicUrlHQ(musicUrlHQ);
            this.setThumbMediaId(thumbMediaId);
        }

        @Override
        public String toString() {
            return "Music{" +
                    "title='" + getTitle() + '\'' +
                    ", description='" + getDescription() + '\'' +
                    ", musicUrl='" + getMusicUrl() + '\'' +
                    ", musicUrlHQ='" + getMusicUrlHQ() + '\'' +
                    ", thumbMediaId='" + getThumbMediaId() + '\'' +
                    '}';
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getMusicUrl() {
            return musicUrl;
        }

        public void setMusicUrl(String musicUrl) {
            this.musicUrl = musicUrl;
        }

        public String getMusicUrlHQ() {
            return musicUrlHQ;
        }

        public void setMusicUrlHQ(String musicUrlHQ) {
            this.musicUrlHQ = musicUrlHQ;
        }

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }
    }

    @XmlAccessorType(XmlAccessType.NONE)
    public static class Article implements Serializable {
        @XmlElement(name = "Title")
        private String title;
        @XmlElement(name = "Description")
        private String description;
        @XmlElement(name = "PicUrl")
        private String picUrl;
        @XmlElement(name = "Url")
        private String url;

        public Article() {
        }

        public Article(String title, String description, String picUrl, String url) {
            this.setTitle(title);
            this.setDescription(description);
            this.setPicUrl(picUrl);
            this.setUrl(url);
        }

        @Override
        public String toString() {
            return "Article{" +
                    "title='" + getTitle() + '\'' +
                    ", description='" + getDescription() + '\'' +
                    ", picUrl='" + getPicUrl() + '\'' +
                    ", url='" + getUrl() + '\'' +
                    '}';
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
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
         * @return Builder.get()获得构建的回复
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
         * @return Builder.get()获得构建的回复
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
            response.setVideo(new Video(mediaId, title, description));
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "toUserName='" + getToUserName() + '\'' +
                ", fromUserName='" + getFromUserName() + '\'' +
                ", createTime=" + getCreateTime() +
                ", msgType='" + getMsgType() + '\'' +
                ", content='" + getContent() + '\'' +
                ", image=" + getImage() +
                ", voice=" + getVoice() +
                ", video=" + getVideo() +
                ", music=" + getMusic() +
                ", articles=" + getArticles() +
                '}';
    }
}

