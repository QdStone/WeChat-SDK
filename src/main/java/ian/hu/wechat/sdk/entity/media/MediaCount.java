package ian.hu.wechat.sdk.entity.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor
public class MediaCount implements Serializable {
    private static final long serialVersionUID = -6547940921246751417L;
    @JsonProperty("voice_count")
    private int voice;
    @JsonProperty("image_count")
    private int image;
    @JsonProperty("video_count")
    private int video;
    @JsonProperty("news_count")
    private int news;
}
