package ian.hu.wechat.sdk.service.menu.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import ian.hu.wechat.sdk.entity.menu.Menu;
import ian.hu.wechat.sdk.entity.menu.button.AbstractButton;
import ian.hu.wechat.sdk.entity.menu.button.SubButton;
import ian.hu.wechat.sdk.service.core.result.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 查询菜单信息的返回结果
 */
public class InfoResult extends Result {

    private static final Log logger = LogFactory.getLog(InfoResult.class);

    @JsonProperty("is_menu_open")
    protected Integer open;
    @JsonProperty("selfmenu_info")
    protected MenuInfo info;

    @Override
    public Integer getErrorCode() {
        return open != null ? 0 : super.getErrorCode();
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }

    public MenuInfo getInfo() {
        return info;
    }

    public void setInfo(MenuInfo info) {
        this.info = info;
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
                    logger.warn("faild to mapping developer menu", e);
                }
            } else {
                SubButton button = new SubButton();
                for (MenuInfo.MenuItem i :
                        item.getSubMenu().getList()) {
                    try {
                        button.add(AbstractButton.createAbstractButton(i.getName(), i.getKey(), item.getUrl(), item.getType(), null, null));
                    } catch (JsonMappingException e) {
                        logger.warn("faild to mapping developer menu", e);
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

    @Override
    public String toString() {
        return "InfoResult{" +
                "errorCode = " + getErrorCode() +
                ", errorMsg='" + getErrorMessage() + '\'' +
                ", open=" + open +
                ", info=" + info +
                '}';
    }

    public static class MenuInfo implements Serializable {

        @JsonProperty("button")
        private ArrayList<MenuInfo.MenuItem> buttons;

        public ArrayList<MenuInfo.MenuItem> getButtons() {
            return buttons;
        }

        public void setButtons(ArrayList<MenuInfo.MenuItem> buttons) {
            this.buttons = buttons;
        }

        @Override
        public String toString() {
            return "MenuInfo{" +
                    "buttons=" + buttons +
                    '}';
        }

        public static class MenuItem implements Serializable {
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
            private MenuInfo.MenuItem.ItemsHolder subMenu;
            @JsonProperty("news_info")
            private MenuInfo.MenuItem.NewsHolder newsInfo;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public MenuInfo.MenuItem.ItemsHolder getSubMenu() {
                return subMenu;
            }

            public void setSubMenu(MenuInfo.MenuItem.ItemsHolder subMenu) {
                this.subMenu = subMenu;
            }

            public MenuInfo.MenuItem.NewsHolder getNewsInfo() {
                return newsInfo;
            }

            public void setNewsInfo(MenuInfo.MenuItem.NewsHolder newsInfo) {
                this.newsInfo = newsInfo;
            }

            @Override
            public String toString() {
                return "MenuItem{" +
                        "name='" + name + '\'' +
                        ", type='" + type + '\'' +
                        ", url='" + url + '\'' +
                        ", value='" + value + '\'' +
                        ", key='" + key + '\'' +
                        ", subMenu=" + subMenu +
                        ", newsInfo=" + newsInfo +
                        '}';
            }

            public static class ItemsHolder implements Serializable {
                @JsonProperty("list")
                private ArrayList<MenuInfo.MenuItem> list;

                public ArrayList<MenuInfo.MenuItem> getList() {
                    return list;
                }

                public void setList(ArrayList<MenuInfo.MenuItem> list) {
                    this.list = list;
                }

                @Override
                public String toString() {
                    return "ItemsHolder{" +
                            "list=" + list +
                            '}';
                }
            }

            public static class NewsHolder implements Serializable {
                @JsonProperty("list")
                private ArrayList<MenuInfo.MenuItem.NewsInfo> list;

                public ArrayList<MenuInfo.MenuItem.NewsInfo> getList() {
                    return list;
                }

                public void setList(ArrayList<MenuInfo.MenuItem.NewsInfo> list) {
                    this.list = list;
                }

                @Override
                public String toString() {
                    return "NewsHolder{" +
                            "list=" + list +
                            '}';
                }
            }

            public static class NewsInfo implements Serializable {
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

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }

                public String getDigest() {
                    return digest;
                }

                public void setDigest(String digest) {
                    this.digest = digest;
                }

                public int getShowCover() {
                    return showCover;
                }

                public void setShowCover(int showCover) {
                    this.showCover = showCover;
                }

                public String getCoverUrl() {
                    return coverUrl;
                }

                public void setCoverUrl(String coverUrl) {
                    this.coverUrl = coverUrl;
                }

                public String getContentUrl() {
                    return contentUrl;
                }

                public void setContentUrl(String contentUrl) {
                    this.contentUrl = contentUrl;
                }

                public String getSourceUrl() {
                    return sourceUrl;
                }

                public void setSourceUrl(String sourceUrl) {
                    this.sourceUrl = sourceUrl;
                }

                @Override
                public String toString() {
                    return "NewsInfo{" +
                            "title='" + title + '\'' +
                            ", author='" + author + '\'' +
                            ", digest='" + digest + '\'' +
                            ", showCover=" + showCover +
                            ", coverUrl='" + coverUrl + '\'' +
                            ", contentUrl='" + contentUrl + '\'' +
                            ", sourceUrl='" + sourceUrl + '\'' +
                            '}';
                }
            }
        }
    }
}
