package ian.hu.wechat.sdk.service.media.result;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import ian.hu.wechat.sdk.entity.media.Media;
import ian.hu.wechat.sdk.rest.annotation.OverrideMediaType;
import ian.hu.wechat.sdk.service.core.result.Result;
import lombok.*;

import javax.ws.rs.core.MediaType;

/**
 * 创建临时素材的结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@OverrideMediaType(value = MediaType.APPLICATION_JSON, from = MediaType.TEXT_PLAIN)
public class CreateResult extends Result {
    private static final long serialVersionUID = -7620327976698205912L;
    @JsonUnwrapped
    private Media media;
}
