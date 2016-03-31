package ian.hu.wechat.sdk.entity.menu.button;

import ian.hu.wechat.sdk.entity.menu.Menu;

/**
 * 选择微笑那图片
 */
public class PicWeiXin extends Click {
    private static final long serialVersionUID = 1475160432426205607L;

    public PicWeiXin() {
        super();
    }

    public PicWeiXin(String name, String key) {
        super(name, key);
    }

    @Override
    public String defaultType() {
        return Menu.TYPE_PIC_WEIXIN;
    }
}
