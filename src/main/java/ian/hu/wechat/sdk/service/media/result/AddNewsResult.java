package ian.hu.wechat.sdk.service.media.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.rest.annotation.OverrideMediaType;
import ian.hu.wechat.sdk.service.core.result.Result;

import javax.ws.rs.core.MediaType;

/**
 * 添加图文的结果
 */
@OverrideMediaType(MediaType.APPLICATION_JSON)
public class AddNewsResult extends Result {
    @JsonProperty("media_id")
    private String mediaId;

    /**
     * mediaId
     */
    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public Integer getErrorCode() {
        return mediaId == null ? super.getErrorCode() : 0;
    }

    @Override
    public String toString() {
        return "AddNewsResult{" +
                "mediaId='" + mediaId + '\'' +
                ", errorCode=" + getErrorCode() +
                ", errorMessage='" + getErrorMessage() + '\'' +
                '}';
    }
}
