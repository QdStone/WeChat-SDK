package ian.hu.wechat.sdk.service.media.result;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import ian.hu.wechat.sdk.service.core.result.Result;
import ian.hu.wechat.sdk.entity.media.Media;
import ian.hu.wechat.sdk.rest.annotation.OverrideMediaType;

import javax.ws.rs.core.MediaType;

/**
 * 创建临时素材的结果
 */
@OverrideMediaType(value = MediaType.APPLICATION_JSON, from = MediaType.TEXT_PLAIN)
public class CreateResult extends Result {
    @JsonUnwrapped
    private Media media;

    public Media getMedia() {
        return media == null || media.getMediaId() == null ? null : media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    @Override
    public Integer getErrorCode() {
        return getMedia() == null ? super.getErrorCode() : 0;
    }

    @Override
    public String toString() {
        return "CreateResult{" +
                "media=" + getMedia() +
                ", errorCode=" + getErrorCode() +
                ", errorMessage='" + getErrorMessage() + '\'' +
                '}';
    }
}
