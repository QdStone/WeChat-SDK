package ian.hu.wechat.sdk.entity.menu.button;

import ian.hu.wechat.sdk.entity.menu.Menu;

/**
 * 扫码拉取信息
 */
public class ScanWait extends Click {

    private static final long serialVersionUID = -8435159693314793267L;

    public ScanWait() {
        super();
    }

    public ScanWait(String name, String key) {
        super(name, key);
    }

    @Override
    public String defaultType() {
        return Menu.TYPE_SCANCODE_WAITMSG;
    }
}
