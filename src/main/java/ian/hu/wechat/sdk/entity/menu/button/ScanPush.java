package ian.hu.wechat.sdk.entity.menu.button;

import ian.hu.wechat.sdk.entity.menu.Menu;

/**
 * 扫码推送事件
 */
public class ScanPush extends Click {

    private static final long serialVersionUID = 5874588727044574626L;

    public ScanPush() {
        super();
    }

    public ScanPush(String name, String key) {
        super(name, key);
    }

    @Override
    public String defaultType() {
        return Menu.TYPE_SCANCODE_PUSH;
    }

}
