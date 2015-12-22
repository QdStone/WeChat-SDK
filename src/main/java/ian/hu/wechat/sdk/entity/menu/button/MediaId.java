package ian.hu.wechat.sdk.entity.menu.button;

/**
 * Created by ian on 15/12/12.
 */
public class MediaId extends ViewLimited {
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
