package ian.hu.wechat.sdk.entity.menu.button;

import ian.hu.wechat.sdk.entity.menu.Menu;

/**
 * Created by ian on 15/12/12.
 */
public class PicPhotoOrAlbum extends Click {
    public PicPhotoOrAlbum() {
        super();
    }

    public PicPhotoOrAlbum(String name, String key) {
        super(name, key);
    }

    @Override
    public String defaultType() {
        return type = Menu.TYPE_PIC_PHOTO_OR_ALBUM;
    }
}
