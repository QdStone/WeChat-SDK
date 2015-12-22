package ian.hu.wechat.sdk.entity.menu.button;

import ian.hu.wechat.sdk.entity.menu.Menu;

/**
 * Created by ian on 15/12/12.
 */
public class ScanWait extends Click {

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
