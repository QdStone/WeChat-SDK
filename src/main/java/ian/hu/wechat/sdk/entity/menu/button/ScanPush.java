package ian.hu.wechat.sdk.entity.menu.button;

import ian.hu.wechat.sdk.entity.menu.Menu;

/**
 * Created by ian on 15/12/12.
 */
public class ScanPush extends Click {

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
