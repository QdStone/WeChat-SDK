package ian.hu.wechat.sdk.service.media.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.media.NewsItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 新增图文的参数
 */
public class AddNewsParam implements Serializable {

    @JsonProperty("articles")
    private ArrayList<NewsItem> news;

    public ArrayList<NewsItem> getNews() {
        return news;
    }

    public void setNews(ArrayList<NewsItem> news) {
        this.news = news;
    }

    public static AddNewsParam fromNews(NewsItem... news) {
        AddNewsParam param = new AddNewsParam();
        param.news.addAll(Arrays.asList(news));
        return param;
    }
}
