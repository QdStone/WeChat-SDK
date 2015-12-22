package ian.hu.wechat.sdk.entity.menu.button;

import ian.hu.wechat.sdk.entity.menu.Menu;

/**
 * Created by ian on 15/12/12.
 */
public class LocationSelect extends Click {
    public LocationSelect() {
        super();
    }

    public LocationSelect(String name, String key) {
        super(name, key);
    }

    @Override
    public String defaultType() {
        return Menu.TYPE_LOCATION_SELECT;
    }
}
