package ian.hu.wechat.sdk.service.media.result;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 每一页里的单个项目
 */
public class PageItem implements Serializable {
    @JsonProperty("media_id")
    private String mediaId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("update_time")
    private Long updateTime;
    @JsonProperty("url")
    private String url;

    @JsonProperty("content")
    private ContentHolder content;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ContentHolder getContent() {
        return content;
    }

    public void setContent(ContentHolder content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PageItem{" +
                "mediaId='" + mediaId + '\'' +
                ", name='" + name + '\'' +
                ", updateTime=" + updateTime +
                ", url='" + url + '\'' +
                ", content=" + content +
                '}';
    }
}
