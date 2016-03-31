package ian.hu.wechat.sdk.entity.menu.button;

import ian.hu.wechat.sdk.entity.menu.Menu;

/**
 * 拍照或选择相片
 */
public class PicPhotoOrAlbum extends Click {
    private static final long serialVersionUID = -1386046795516963014L;

    public PicPhotoOrAlbum() {
    }

    public PicPhotoOrAlbum(String name, String key) {
        super(name, key);
    }

    @Override
    public String defaultType() {
        return Menu.TYPE_PIC_PHOTO_OR_ALBUM;
    }
}
