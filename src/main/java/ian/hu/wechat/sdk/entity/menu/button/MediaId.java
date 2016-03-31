package ian.hu.wechat.sdk.entity.menu.button;

/**
 * 限制图文
 */
public class MediaId extends ViewLimited {
    private static final long serialVersionUID = -3502527872728404305L;

    public MediaId() {
        super();
    }

    /**
     * @param name    菜单名称
     * @param mediaId 永久素材media_id
     */
    public MediaId(String name, String mediaId) {
        super(name, mediaId);
    }

    @Override
    public String defaultType() {
        return "media_id";
    }
}
