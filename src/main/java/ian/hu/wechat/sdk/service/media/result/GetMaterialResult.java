package ian.hu.wechat.sdk.service.media.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.media.NewsItem;
import ian.hu.wechat.sdk.service.core.result.Result;
import lombok.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取永久素材的结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GetMaterialResult extends Result implements CompositeResult {
    private static final long serialVersionUID = -2834498108596951457L;
    private String fileName;
    private File file;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("down_url")
    private String downloadUrl;
    @JsonProperty("news_item")
    private List<NewsItem> newsItems;

    public String getFileName() {
        return fileName;
    }

    @Override
    public MediaType fromMediaType() {
        return MediaType.valueOf("text/plain");
    }

    @Override
    public MediaType toMediaType() {
        return MediaType.APPLICATION_JSON_TYPE;
    }


    @Override
    public Integer getErrorCode() {
        return newsItems != null || downloadUrl != null || file != null ? 0 : super.getErrorCode();
    }


    public static GetMaterialResult from(Response response) {
        return ResultHelper.from(response, GetMaterialResult.class);
    }
}
