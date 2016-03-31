package ian.hu.wechat.sdk.entity.menu.button;

import ian.hu.wechat.sdk.entity.menu.Menu;

/**
 * 选择系统照片
 */
public class PicSysPhoto extends Click {

    private static final long serialVersionUID = 500637750169218955L;

    public PicSysPhoto() {
    }

    public PicSysPhoto(String name, String key) {
        super(name, key);
    }

    @Override
    public String defaultType() {
        return Menu.TYPE_PIC_SYSPHOTO;
    }
}
