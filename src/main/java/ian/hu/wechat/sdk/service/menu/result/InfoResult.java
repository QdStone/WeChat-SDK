package ian.hu.wechat.sdk.service.menu.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import ian.hu.wechat.sdk.entity.menu.Menu;
import ian.hu.wechat.sdk.entity.menu.button.AbstractButton;
import ian.hu.wechat.sdk.entity.menu.button.SubButton;
import ian.hu.wechat.sdk.service.core.result.Result;
import lombok.*;
import lombok.extern.apachecommons.CommonsLog;

import java.io.Serializable;
import java.util.List;

/**
 * 查询菜单信息的返回结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@CommonsLog
public class InfoResult extends Result {

    private static final long serialVersionUID = -1716371176898911069L;

    @JsonProperty("is_menu_open")
    protected Integer open;
    @JsonProperty("selfmenu_info")
    protected MenuInfo info;

    @Override
    public Integer getErrorCode() {
        return open != null ? 0 : super.getErrorCode();
    }

    public Menu getDeveloperMenu() {
        // TODO 针对media_id和view_limited未测试
        if (!isFromDevloper()) {
            return null;
        }
        Menu menu = new Menu();
        for (MenuInfo.MenuItem item :
                getInfo().getButtons()) {
            if (item.getSubMenu() == null || item.getSubMenu().getList() == null) {
                try {
                    menu.add(AbstractButton.createAbstractButton(item.getName(), item.getKey(), item.getUrl(), item.getType(), null, null));
                } catch (JsonMappingException e) {
                    log.warn("faild to mapping developer menu", e);
                }
            } else {
                SubButton button = new SubButton();
                for (MenuInfo.MenuItem i :
                        item.getSubMenu().getList()) {
                    try {
                        button.add(AbstractButton.createAbstractButton(i.getName(), i.getKey(), item.getUrl(), item.getType(), null, null));
                    } catch (JsonMappingException e) {
                        log.warn("faild to mapping developer menu", e);
                    }
                }
                menu.add(button);
            }
        }
        return menu;
    }

    public boolean isFromWeChat() {
        for (MenuInfo.MenuItem item :
                info.getButtons()) {
            if (item.getValue() != null || item.getNewsInfo() != null) {
                return true;
            } else if (item.getKey() != null) {
                return false;
            } else if (item.getSubMenu() != null && item.getSubMenu().getList() != null) {
                for (MenuInfo.MenuItem itemi :
                        item.getSubMenu().getList()) {
                    if (itemi.getValue() != null || itemi.getNewsInfo() != null) {
                        return true;
                    } else if (itemi.getKey() != null) {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public boolean isFromDevloper() {
        return !isFromWeChat();
    }


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MenuInfo implements Serializable {

        private static final long serialVersionUID = -4342846635434414251L;
        @JsonProperty("button")
        private Iterable<MenuItem> buttons;


        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class MenuItem implements Serializable {
            private static final long serialVersionUID = -3739665413783973262L;
            @JsonProperty("name")
            private String name;
            @JsonProperty("type")
            private String type;
            @JsonProperty("url")
            private String url;
            @JsonProperty("value")
            private String value;
            @JsonProperty("key")
            private String key;
            @JsonProperty("sub_button")
            private ItemsHolder subMenu;
            @JsonProperty("news_info")
            private NewsHolder newsInfo;

            @Data
            @Builder
            @NoArgsConstructor
            @AllArgsConstructor
            public static class ItemsHolder implements Serializable {
                private static final long serialVersionUID = -9083596949049016787L;
                @JsonProperty("list")
                private List<MenuItem> list;
            }

            @Data
            @Builder
            @NoArgsConstructor
            @AllArgsConstructor
            public static class NewsHolder implements Serializable {
                private static final long serialVersionUID = 6392661375489315277L;
                @JsonProperty("list")
                private List<NewsInfo> list;
            }

            @Data
            @Builder
            @NoArgsConstructor
            @AllArgsConstructor
            public static class NewsInfo implements Serializable {
                private static final long serialVersionUID = -5632997040055918048L;
                @JsonProperty("title")
                private String title;
                @JsonProperty("author")
                private String author;
                @JsonProperty("digest")
                private String digest;
                @JsonProperty("show_cover")
                private int showCover;
                @JsonProperty("cover_url")
                private String coverUrl;
                @JsonProperty("content_url")
                private String contentUrl;
                @JsonProperty("source_url")
                private String sourceUrl;
            }
        }
    }
}
