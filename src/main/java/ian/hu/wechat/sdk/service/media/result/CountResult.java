package ian.hu.wechat.sdk.service.media.result;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import ian.hu.wechat.sdk.entity.media.MediaCount;
import ian.hu.wechat.sdk.service.core.result.Result;


public class CountResult extends Result {
    @JsonUnwrapped
    private MediaCount mediaCount;

    public MediaCount getMediaCount() {
        return mediaCount;
    }

    public void setMediaCount(MediaCount mediaCount) {
        this.mediaCount = mediaCount;
    }

    @Override
    public Integer getErrorCode() {
        return super.getErrorCode() == null ? 0 : super.getErrorCode();
    }

    @Override
    public String toString() {
        return "CountResult{" +
                "mediaCount=" + mediaCount +
                ", errorCode=" + getErrorCode() +
                ", errorMsg=" + getErrorMessage() +
                '}';
    }
}
