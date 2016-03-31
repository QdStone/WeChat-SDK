package ian.hu.wechat.sdk.service.media.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.media.NewsItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor
public class UpdateNewsParam implements Serializable {
    private static final long serialVersionUID = 6007607297032539395L;
    @JsonProperty("media_id")
    private String mediaId;
    @JsonProperty("index")
    private int index;
    @JsonProperty("articles")
    private NewsItem articles;
}
