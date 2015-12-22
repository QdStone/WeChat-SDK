package ian.hu.wechat.sdk.service.media.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.media.NewsItem;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * News列表
 */
public class ContentHolder implements Serializable {
    @JsonProperty("news_item")
    private ArrayList<NewsItem> newsItems = new ArrayList<NewsItem>();

    public ArrayList<NewsItem> getNewsItems() {
        return newsItems;
    }

    public void setNewsItems(ArrayList<NewsItem> newsItems) {
        this.newsItems = newsItems;
    }

    @Override
    public String toString() {
        return "ContentHolder{" +
                "newsItems=" + newsItems +
                '}';
    }
}
