package ian.hu.wechat.sdk.service.media.param;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MediaIdHolder implements Serializable {

    @JsonProperty("media_id")
    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public MediaIdHolder() {
    }

    public MediaIdHolder(String mediaId) {
        this.mediaId = mediaId;
    }
}
