package ian.hu.wechat.sdk.service.media.param;

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
public class MediaIdHolder implements Serializable {

    private static final long serialVersionUID = 8185055795464186642L;
    @JsonProperty("media_id")
    private String mediaId;
}
