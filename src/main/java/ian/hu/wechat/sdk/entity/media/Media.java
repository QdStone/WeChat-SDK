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
public class Media implements Serializable {
    private static final long serialVersionUID = -1401141441845308774L;
    @JsonProperty("type")
    private String type;
    @JsonProperty("media_id")
    private String mediaId;
    @JsonProperty("created_at")
    private Long createAt;
}
