package ian.hu.wechat.sdk.entity.menu.button;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 跳转图文页
 */
public class ViewLimited extends Button {

    private static final long serialVersionUID = 5225646528702063546L;
    /**
     * 图文素材的media_id
     */
    @JsonProperty("media_id")
    protected String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    /**
     * @param mediaId 图文素材media_id
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public ViewLimited() {
        super();
    }

    public ViewLimited(String name, String mediaId) {
        this();
    }

    @Override
    public String defaultType() {
        return "view_limited";
    }

    @Override
    public String toString() {
        return "ViewLimited{" +
                "type=" + type +
                ",name=" + getName() +
                ",mediaId='" + mediaId + '\'' +
                '}';
    }
}
