package ian.hu.wechat.sdk.service.media.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.media.NewsItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 新增图文的参数
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddNewsParam implements Serializable {

    private static final long serialVersionUID = -3986279935503063304L;
    @JsonProperty("articles")
    private List<NewsItem> news;

    public static AddNewsParam fromNews(NewsItem... news) {
        AddNewsParam param = new AddNewsParam();
        param.news.addAll(Arrays.asList(news));
        return param;
    }
}
