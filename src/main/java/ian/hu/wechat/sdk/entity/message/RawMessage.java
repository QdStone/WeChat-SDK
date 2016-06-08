/*
 *
 *  * Copyright 2014-2016 the original author or authors.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package ian.hu.wechat.sdk.entity.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 微信发送给开发者的消息
 *
 * @see <a href="http://mp.weixin.qq.com/wiki/17/fc9a27730e07b9126144d9c96eaf51f9.html">接收消息</a>
 */
@SuppressWarnings("PublicStaticCollectionField")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class RawMessage implements Serializable {
    /**
     * 消息类型 事件
     *
     * @see <a href="http://mp.weixin.qq.com/wiki/14/f79bdec63116f376113937e173652ba2.html">接收事件推送</a>
     */
    public static final String TYPE_EVENT = "event";
    /**
     * 消息类型 文本
     *
     * @see <a href="http://mp.weixin.qq.com/wiki/17/fc9a27730e07b9126144d9c96eaf51f9.html#.E6.96.87.E6.9C.AC.E6.B6.88.E6.81.AF">文本消息</a>
     */
    public static final String TYPE_TEXT = "text";
    /**
     * 消息类型 图片
     *
     * @see <a href="http://mp.weixin.qq.com/wiki/17/fc9a27730e07b9126144d9c96eaf51f9.html#.E5.9B.BE.E7.89.87.E6.B6.88.E6.81.AF">图片消息</a>
     */
    public static final String TYPE_IMAGE = "image";
    /**
     * 消息类型 语音
     *
     * @see <a href="http://mp.weixin.qq.com/wiki/17/fc9a27730e07b9126144d9c96eaf51f9.html#.E8.AF.AD.E9.9F.B3.E6.B6.88.E6.81.AF">语音消息</a>
     */
    public static final String TYPE_VOICE = "voice";
    /**
     * 消息类型 视频
     *
     * @see <a href="http://mp.weixin.qq.com/wiki/17/fc9a27730e07b9126144d9c96eaf51f9.html#.E8.A7.86.E9.A2.91.E6.B6.88.E6.81.AF">视频消息</a>
     */
    public static final String TYPE_VIDEO = "video";
    /**
     * 消息类型 短视频
     *
     * @see <a href="http://mp.weixin.qq.com/wiki/17/fc9a27730e07b9126144d9c96eaf51f9.html#.E5.B0.8F.E8.A7.86.E9.A2.91.E6.B6.88.E6.81.AF">小视频消息</a>
     */
    public static final String TYPE_SHORTVIDEO = "shortvideo";
    /**
     * 消息类型 定位
     *
     * @see <a href="http://mp.weixin.qq.com/wiki/17/fc9a27730e07b9126144d9c96eaf51f9.html#.E5.9C.B0.E7.90.86.E4.BD.8D.E7.BD.AE.E6.B6.88.E6.81.AF">地理位置消息</a>
     */
    public static final String TYPE_LOCATION = "location";
    /**
     * 消息类型 链接
     *
     * @see <a href="http://mp.weixin.qq.com/wiki/17/fc9a27730e07b9126144d9c96eaf51f9.html#.E9.93.BE.E6.8E.A5.E6.B6.88.E6.81.AF">链接消息</a>
     */
    public static final String TYPE_LINK = "link";

    /**
     * 事件类型
     * - subscribe 关注
     * - unsubscribe 取消关注
     * - SCAN 已关注用户扫码
     * - LOCATION 上报地理位置
     * - CLICK 点击菜单拉取消息时的事件推送
     * - VIEW 点击菜单跳转链接时的事件推送
     * - scancode_push 菜单-扫码推事件的事件推送
     * - scancode_waitmsg 菜单-扫码推事件且弹出“消息接收中”提示框的事件推送
     * - pic_sysphoto 菜单-弹出系统拍照发图的事件推送
     * - pic_photo_or_album：菜单-弹出拍照或者相册发图的事件推送
     * - pic_weixin：菜单-弹出微信相册发图器的事件推送
     * - location_select：菜单-弹出地理位置选择器的事件推送
     *
     * @see <a href="http://mp.weixin.qq.com/wiki/14/f79bdec63116f376113937e173652ba2.html#.E5.85.B3.E6.B3.A8.2F.E5.8F.96.E6.B6.88.E5.85.B3.E6.B3.A8.E4.BA.8B.E4.BB.B6">关注/取消关注</a>
     */
    public static final String EVENT_SUBSCRIBE = "subscribe";
    public static final String EVENT_UNSUBSCRIBE = "unsubscribe";

    /**
     * @see <a href="http://mp.weixin.qq.com/wiki/14/f79bdec63116f376113937e173652ba2.html#.E6.89.AB.E6.8F.8F.E5.B8.A6.E5.8F.82.E6.95.B0.E4.BA.8C.E7.BB.B4.E7.A0.81.E4.BA.8B.E4.BB.B6">扫码事件</a>
     */
    public static final String EVENT_SCAN = "SCAN";
    /**
     * @see <a href="http://mp.weixin.qq.com/wiki/14/f79bdec63116f376113937e173652ba2.html#.E4.B8.8A.E6.8A.A5.E5.9C.B0.E7.90.86.E4.BD.8D.E7.BD.AE.E4.BA.8B.E4.BB.B6">上报地理位置事件</a>
     */
    public static final String EVENT_LOCATION = "LOCATION";

    /**
     * @see <a href="http://mp.weixin.qq.com/wiki/3/f42b10b80e52f4fdf921b4b6ad78b37f.html#.E7.82.B9.E5.87.BB.E8.8F.9C.E5.8D.95.E6.8B.89.E5.8F.96.E6.B6.88.E6.81.AF.E6.97.B6.E7.9A.84.E4.BA.8B.E4.BB.B6.E6.8E.A8.E9.80.81">点击菜单拉取消息事件</a>
     */
    public static final String EVENT_MENU_CLICK = "CLICK";
    /**
     * @see <a href="http://mp.weixin.qq.com/wiki/3/f42b10b80e52f4fdf921b4b6ad78b37f.html#.E7.82.B9.E5.87.BB.E8.8F.9C.E5.8D.95.E8.B7.B3.E8.BD.AC.E9.93.BE.E6.8E.A5.E6.97.B6.E7.9A.84.E4.BA.8B.E4.BB.B6.E6.8E.A8.E9.80.81">点击菜单跳转链接时的事件推送</a>
     */
    public static final String EVENT_MENU_VIEW = "VIEW";
    /**
     * @see <a href="http://mp.weixin.qq.com/wiki/3/f42b10b80e52f4fdf921b4b6ad78b37f.html#scancode_push.EF.BC.9A.E6.89.AB.E7.A0.81.E6.8E.A8.E4.BA.8B.E4.BB.B6.E7.9A.84.E4.BA.8B.E4.BB.B6.E6.8E.A8.E9.80.81">scancode_push：扫码推事件的事件推送</a>
     */
    public static final String EVENT_MENU_SCANCODE_PUSH = "scancode_push";
    /**
     * @see <a href="http://mp.weixin.qq.com/wiki/3/f42b10b80e52f4fdf921b4b6ad78b37f.html#scancode_waitmsg.EF.BC.9A.E6.89.AB.E7.A0.81.E6.8E.A8.E4.BA.8B.E4.BB.B6.E4.B8.94.E5.BC.B9.E5.87.BA.E2.80.9C.E6.B6.88.E6.81.AF.E6.8E.A5.E6.94.B6.E4.B8.AD.E2.80.9D.E6.8F.90.E7.A4.BA.E6.A1.86.E7.9A.84.E4.BA.8B.E4.BB.B6.E6.8E.A8.E9.80.81">scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框的事件推送</a>
     */
    public static final String EVENT_MENU_SCANCODE_WAITMSG = "scancode_waitmsg";
    /**
     * @see <a href="http://mp.weixin.qq.com/wiki/3/f42b10b80e52f4fdf921b4b6ad78b37f.html#pic_sysphoto.EF.BC.9A.E5.BC.B9.E5.87.BA.E7.B3.BB.E7.BB.9F.E6.8B.8D.E7.85.A7.E5.8F.91.E5.9B.BE.E7.9A.84.E4.BA.8B.E4.BB.B6.E6.8E.A8.E9.80.81">pic_sysphoto：弹出系统拍照发图的事件推送</a>
     */
    public static final String EVENT_MENU_PIC_SYSPHOTO = "pic_sysphoto";
    /**
     * @see <a href="http://mp.weixin.qq.com/wiki/3/f42b10b80e52f4fdf921b4b6ad78b37f.html#pic_photo_or_album.EF.BC.9A.E5.BC.B9.E5.87.BA.E6.8B.8D.E7.85.A7.E6.88.96.E8.80.85.E7.9B.B8.E5.86.8C.E5.8F.91.E5.9B.BE.E7.9A.84.E4.BA.8B.E4.BB.B6.E6.8E.A8.E9.80.81">pic_photo_or_album：弹出拍照或者相册发图的事件推送</a>
     */
    public static final String EVENT_MENU_PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
    /**
     * @see <a href="http://mp.weixin.qq.com/wiki/3/f42b10b80e52f4fdf921b4b6ad78b37f.html#pic_weixin.EF.BC.9A.E5.BC.B9.E5.87.BA.E5.BE.AE.E4.BF.A1.E7.9B.B8.E5.86.8C.E5.8F.91.E5.9B.BE.E5.99.A8.E7.9A.84.E4.BA.8B.E4.BB.B6.E6.8E.A8.E9.80.81">pic_weixin：弹出微信相册发图器的事件推送</a>
     */
    public static final String EVENT_MENU_PIC_WEIXIN = "pic_weixin";
    /**
     * @see <a href="http://mp.weixin.qq.com/wiki/3/f42b10b80e52f4fdf921b4b6ad78b37f.html#location_select.EF.BC.9A.E5.BC.B9.E5.87.BA.E5.9C.B0.E7.90.86.E4.BD.8D.E7.BD.AE.E9.80.89.E6.8B.A9.E5.99.A8.E7.9A.84.E4.BA.8B.E4.BB.B6.E6.8E.A8.E9.80.81">location_select：弹出地理位置选择器的事件推送</a>
     */
    public static final String EVENT_MENU_LOCATION_SELECT = "location_select";

    public static final String FORMAT_VOICE_AMR = "amr";
    public static final String FORMAT_VOICE_SPEEX = "speex";

    /**
     * 所有的菜单事件
     */
    public static final List<String> MENU_EVENTS = Collections.unmodifiableList(Arrays.asList(
            EVENT_MENU_CLICK, EVENT_MENU_VIEW, EVENT_MENU_LOCATION_SELECT,
            EVENT_MENU_SCANCODE_PUSH, EVENT_MENU_SCANCODE_WAITMSG,
            EVENT_MENU_PIC_PHOTO_OR_ALBUM, EVENT_MENU_PIC_SYSPHOTO, EVENT_MENU_PIC_WEIXIN
    ));

    /**
     * 所有的不能回复的事件
     */
    public static final List<String> VOID_EVENTS = Collections.unmodifiableList(Arrays.asList(EVENT_UNSUBSCRIBE, EVENT_MENU_VIEW));
    private static final long serialVersionUID = 5542409336326926132L;

    @XmlElement(name = "ToUserName")
    private String toUserName;
    @XmlElement(name = "FromUserName")
    private String fromUserName;

    /**
     * 消息类型
     * - text 文本
     * - image 图片
     * - voice 语音
     * - video 视频
     * - shortvideo 小视频
     * - location 地理位置
     * - link 链接消息
     */
    @XmlElement(name = "MsgType")
    private String msgType;

    /**
     * text:文本消息的内容
     */
    @XmlElement(name = "Content")
    private String content;

    /**
     * all:创建时间
     */
    @XmlElement(name = "CreateTime")
    private Long createTime;

    /**
     * all:消息Id
     */
    @XmlElement(name = "MsgId")
    private String msgId;

    /**
     * image:图片消息的图片链接
     */
    @XmlElement(name = "PicUrl")
    private String picUrl;

    /**
     * image,voice,video,shortvideo:媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    @XmlElement(name = "MediaId")
    private String mediaId;

    /**
     * voice:语音消息的格式amr/speex
     */
    @XmlElement(name = "Format")
    private String format;

    /**
     * voice:语音识别结果
     */
    @XmlElement(name = "Recognition")
    private String recognition;

    /**
     * video,shortvideo:视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    @XmlElement(name = "ThumbMediaId")
    private String thumbMediaId;

    /**
     * location:地理位置纬度
     */
    @XmlElement(name = "Location_X")
    private Double locationX;

    /**
     * location:地理位置经度
     */
    @XmlElement(name = "Location_Y")
    private Double locationY;

    /**
     * location:地图缩放大小 越大越精确
     */
    @XmlElement(name = "Scale")
    private Integer scale;

    /**
     * location:地理位置信息
     */
    @XmlElement(name = "Label")
    private String label;

    /**
     * link:消息标题
     */
    @XmlElement(name = "Title")
    private String title;

    /**
     * link:消息描述
     */
    @XmlElement(name = "Description")
    private String description;

    /**
     * link:消息链接
     */
    @XmlElement(name = "Url")
    private String url;


    /**
     * 事件类型
     * - subscribe 关注
     * - unsubscribe 取消关注
     * - SCAN 已关注用户扫码
     * - LOCATION 发送地理位置
     * - CLICK 点击菜单拉取消息时的事件推送
     * - VIEW 点击菜单跳转链接时的事件推送
     * - scancode_push 扫码推事件的事件推送
     * - scancode_waitmsg 扫码推事件且弹出“消息接收中”提示框的事件推送
     * - pic_sysphoto 弹出系统拍照发图的事件推送
     * - pic_photo_or_album：弹出拍照或者相册发图的事件推送
     * - pic_weixin：弹出微信相册发图器的事件推送
     * - location_select：弹出地理位置选择器的事件推送
     */
    @XmlElement(name = "Event")
    private String event;

    /**
     * - subscribe|SCAN 事件KEY值，qrscene_为前缀，后面为二维码的参数值
     * - CLICK 事件KEY值，与自定义菜单接口中KEY值对应
     * - VIEW 事件KEY值，设置的跳转URL
     * - scancode_push|scancode_waitmsg|pic_sysphoto|pic_photo_or_album|pic_weixin|location_select  事件KEY值，由开发者在创建菜单时设定
     */
    @XmlElement(name = "EventKey")
    private String eventKey;

    /**
     * - subscribe|SCAN 二维码的ticket，可用来换取二维码图片
     */
    @XmlElement(name = "Ticket")
    private String ticket;

    /**
     * - LOCATION 地理位置纬度
     */
    @XmlElement(name = "Latitude")
    private Float latitude;

    /**
     * - LOCATION 地理位置经度
     */
    @XmlElement(name = "Longitude")
    private Float longitude;

    /**
     * - LOCATION 地理位置精度
     */
    @XmlElement(name = "Precision")
    private Float precision;

    /**
     * - scancode_push 扫描信息
     */
    @XmlElement(name = "ScanCodeInfo")
    private ScanCodeInfo scanCodeInfo;


    /**
     * - pic_sysphoto 发送的图片信息
     */
    @XmlElement(name = "SendPicsInfo")
    private SendPicsInfo sendPicsInfo;


    /**
     * - location_select 发送的位置信息
     */
    @XmlElement(name = "SendLocationInfo")
    private SendLocationInfo sendLocationInfo;


    /**
     * 是否是事件
     *
     * @return true|false
     */
    public boolean isEvent() {
        return TYPE_EVENT.equals(getMsgType());
    }

    public boolean isText() {
        return TYPE_TEXT.equals(getMsgType());
    }

    public boolean isImage() {
        return TYPE_IMAGE.equals(getMsgType());
    }

    public boolean isVoice() {
        return TYPE_VOICE.equals(getMsgType());
    }

    public boolean isVideo() {
        return TYPE_VIDEO.equals(getMsgType());
    }

    public boolean isShortVideo() {
        return TYPE_SHORTVIDEO.equals(getMsgType());
    }

    public boolean isLocation() {
        return TYPE_LOCATION.equals(getMsgType());
    }

    public boolean isLink() {
        return TYPE_LINK.equals(getMsgType());
    }

    public boolean isMenuEvent() {
        return MENU_EVENTS.contains(getEvent());
    }

    public boolean isSubscribeEvent() {
        return EVENT_SUBSCRIBE.equals(getEvent());
    }

    public boolean isUnSubscribeEvent() {
        return EVENT_UNSUBSCRIBE.equals(getEvent());
    }

    public boolean isScanEvent() {
        return EVENT_SCAN.equals(getEvent());
    }

    /**
     * 是否允许回复
     *
     * @return true|false
     */
    public boolean canReply() {
        if (isEvent()) {
            if (VOID_EVENTS.contains(getEvent())) {
                return false;
            }
        }
        return true;
    }

    public static class Builder {
    }


    /**
     * 菜单扫码结果
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlAccessorType(XmlAccessType.NONE)
    public static class ScanCodeInfo implements Serializable {

        private static final long serialVersionUID = 7202608152908846436L;

        /**
         * 扫描类型，一般是qrcode
         */
        @XmlElement(name = "ScanType")
        private String scanType;

        /**
         * 扫描结果，即二维码对应的字符串信息
         */
        @XmlElement(name = "ScanResult")
        private String scanResult;

    }

    @Data

    @lombok.Builder
    @XmlAccessorType(XmlAccessType.NONE)
    public static class SendPicsInfo implements Serializable {

        private static final long serialVersionUID = -8582820848289596387L;
        /**
         * 选择的图片列表
         */
        @XmlElement(name = "PicList")
        private PicList picList;

        @XmlElement(name = "Count")
        public Integer getCount() {
            return picList != null && picList.getItems() != null ? picList.getItems().size() : 0;
        }

        /**
         * 图片列表结构
         */
        @Data

        @lombok.Builder
        @SuppressWarnings("InnerClassTooDeeplyNested")
        @XmlAccessorType(XmlAccessType.NONE)
        public static class PicList implements Serializable {

            private static final long serialVersionUID = 8142061826482976073L;
            @SuppressWarnings("FieldMayBeFinal")
            @XmlElement(name = "item")
            private List<Item> items = new ArrayList<Item>();

            @Data
            @lombok.Builder

            @NoArgsConstructor
            @AllArgsConstructor
            @XmlAccessorType(XmlAccessType.NONE)
            public static class Item implements Serializable {
                private static final long serialVersionUID = 2989739264544408358L;

                @XmlElement(name = "PicMd5Sum")
                private String picMd5Sum;

            }
        }

    }


    /**
     * 发送位置信息结构
     */
    @Data

    @lombok.Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlAccessorType(XmlAccessType.NONE)
    public static class SendLocationInfo implements Serializable {

        private static final long serialVersionUID = 2757760078358399943L;

        /**
         * X坐标信息
         */
        @XmlElement(name = "Location_X")
        private Float locationX;

        /**
         * Y坐标信息
         */
        @XmlElement(name = "Location_Y")
        private Float locationY;

        /**
         * 精度，可理解为精度或者比例尺、越精细的话 scale越高
         */
        @XmlElement(name = "Scale")
        private Float scale;

        /**
         * 地理位置的字符串信息
         */
        @XmlElement(name = "Label")
        private String label;

        /**
         * 朋友圈POI的名字，可能为空
         */
        @XmlElement(name = "Poiname")
        private String poiName;

    }

}
