package ian.hu.wechat.sdk.service.media.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.media.NewsItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * News列表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentHolder implements Serializable {
    private static final long serialVersionUID = 6412661055293050235L;
    @JsonProperty("news_item")
    private List<NewsItem> newsItems = new ArrayList<NewsItem>();
}
