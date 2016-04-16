package ian.hu.wechat.sdk.entity.menu.button;

import ian.hu.wechat.sdk.entity.menu.Menu;

/**
 * 选择位置信息
 */
public class LocationSelect extends Click {
    private static final long serialVersionUID = -4042932464902927288L;

    public LocationSelect() {
    }

    public LocationSelect(String name, String key) {
        super(name, key);
    }

    @Override
    public String defaultType() {
        return Menu.TYPE_LOCATION_SELECT;
    }
}
