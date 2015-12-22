package ian.hu.wechat.sdk.entity.media;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 单条图文素材
 */
public class NewsItem implements Serializable {
    @JsonProperty("title")
    private String title;

    @JsonProperty("thumb_media_id")
    private String thumbMediaId;

    @JsonProperty("show_cover_pic")
    private Integer showCoverPic;

    @JsonProperty("author")
    private String author;

    @JsonProperty("digest")
    private String digest;

    @JsonProperty("content")
    private String content;

    @JsonProperty("url")
    private String url;

    @JsonProperty("content_source_url")
    private String contentSourceUrl;

    /**
     * 图文消息的标题
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 图文消息的封面图片素材id（必须是永久mediaID）
     */
    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    /**
     * 是否显示封面，0为false，即不显示，1为true，即显示
     */
    public Integer getShowCoverPic() {
        return showCoverPic;
    }

    public void setShowCoverPic(Integer showCoverPic) {
        this.showCoverPic = showCoverPic;
    }

    /**
     * 作者
     */
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
     */
    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    /**
     * 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
     */
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 图文页的URL
     */
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 图文消息的原文地址，即点击“阅读原文”后的URL
     */
    public String getContentSourceUrl() {
        return contentSourceUrl;
    }

    public void setContentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = contentSourceUrl;
    }

    @Override
    public String toString() {
        return "NewsItem{" +
                "title='" + title + '\'' +
                ", thumbMediaId='" + thumbMediaId + '\'' +
                ", showCoverPic=" + showCoverPic +
                ", author='" + author + '\'' +
                ", digest='" + digest + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                ", contentSourceUrl='" + contentSourceUrl + '\'' +
                '}';
    }
}
