package ian.hu.wechat.sdk.service.media.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.media.NewsItem;

import java.io.Serializable;

public class UpdateNewsParam implements Serializable {
    @JsonProperty("media_id")
    private String mediaId;
    @JsonProperty("index")
    private int index;
    @JsonProperty("articles")
    private NewsItem articles;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public NewsItem getArticles() {
        return articles;
    }

    public void setArticles(NewsItem articles) {
        this.articles = articles;
    }
}
