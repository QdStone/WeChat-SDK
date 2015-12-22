package ian.hu.wechat.sdk.service.media.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.rest.annotation.OverrideMediaType;
import ian.hu.wechat.sdk.service.core.result.Result;

import javax.ws.rs.core.MediaType;

/**
 * 添加其他素材的结果
 */
@OverrideMediaType(MediaType.APPLICATION_JSON)
public class AddMaterialResult extends Result {
    @JsonProperty("media_id")
    private String mediaId;
    @JsonProperty("url")
    private String url;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Integer getErrorCode() {
        return mediaId == null ? super.getErrorCode() : 0;
    }

    @Override
    public String toString() {
        return "AddMaterialResult{" +
                "mediaId='" + mediaId + '\'' +
                ", url='" + url + '\'' +
                ", errorCode=" + getErrorCode() +
                ", errorMessage='" + getErrorMessage() + '\'' +
        '}';
    }
}
