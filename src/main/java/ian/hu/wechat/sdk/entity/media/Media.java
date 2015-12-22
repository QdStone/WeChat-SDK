package ian.hu.wechat.sdk.entity.media;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Media implements Serializable {
    @JsonProperty("type")
    private String type;
    @JsonProperty("media_id")
    private String mediaId;
    @JsonProperty("created_at")
    private Long createAt;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Media{" +
                "type='" + type + '\'' +
                ", mediaId='" + mediaId + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}
