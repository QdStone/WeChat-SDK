package ian.hu.wechat.sdk.service.media.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.rest.annotation.OverrideMediaType;
import ian.hu.wechat.sdk.service.core.result.Result;
import lombok.*;

import javax.ws.rs.core.MediaType;

/**
 * 添加图文的结果
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@OverrideMediaType(MediaType.APPLICATION_JSON)
public class AddNewsResult extends Result {
    private static final long serialVersionUID = 6500544822283285412L;
    @JsonProperty("media_id")
    private String mediaId;
}
