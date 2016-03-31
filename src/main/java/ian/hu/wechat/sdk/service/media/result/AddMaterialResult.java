package ian.hu.wechat.sdk.service.media.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.rest.annotation.OverrideMediaType;
import ian.hu.wechat.sdk.service.core.result.Result;
import lombok.*;

import javax.ws.rs.core.MediaType;

/**
 * 添加其他素材的结果
 */
@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@OverrideMediaType(MediaType.APPLICATION_JSON)
public class AddMaterialResult extends Result {
    private static final long serialVersionUID = -8984221831942768245L;
    @JsonProperty("media_id")
    private String mediaId;
    @JsonProperty("url")
    private String url;
    @Override
    public Integer getErrorCode() {
        return mediaId == null ? super.getErrorCode() : 0;
    }
}
