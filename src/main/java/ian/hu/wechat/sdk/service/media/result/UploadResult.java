package ian.hu.wechat.sdk.service.media.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.rest.annotation.OverrideMediaType;
import ian.hu.wechat.sdk.service.core.result.Result;
import lombok.*;

import javax.ws.rs.core.MediaType;

/**
 * 上传图片获取链接的结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@OverrideMediaType(MediaType.APPLICATION_JSON)
public class UploadResult extends Result {
    private static final long serialVersionUID = -7666528763346094177L;
    @JsonProperty("url")
    private String url;

    @Override
    public Integer getErrorCode() {
        return url == null ? super.getErrorCode() : 0;
    }

}
