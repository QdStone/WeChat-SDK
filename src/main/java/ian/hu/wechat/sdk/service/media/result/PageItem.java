package ian.hu.wechat.sdk.service.media.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

/**
 * 每一页里的单个项目
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageItem implements Serializable {
    private static final long serialVersionUID = 3122608384349984392L;
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
}
