package ian.hu.wechat.sdk.service.core.result;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 响应结果代码
 */
public enum Errors implements Serializable {
    /**
     * 调用成功
     */
    OK(0, "OK"),
    SystemBusy(-1, "系统繁忙，此时请开发者稍候再试/功能未启用"),
    SystemError(-2, "程序内部错误"),
    InvalidToken(40001, "获取access_token时AppSecret错误，或者access_token无效。请开发者认真比对AppSecret的正确性，或查看是否正在为恰当的公众号调用接口"),
    InvalidCredential(40002, "不合法的凭证类型"),
    InvalidOpenId(40003, "不合法的OpenID，请开发者确认OpenID（该用户）是否已关注公众号，或是否是其他公众号的OpenID"),
    InvalidMediaType(40004, "不合法的媒体文件类型"),
    InvalidFileType(40005, "不合法的文件类型"),
    InvalidFileSize(40006, "不合法的文件大小"),
    InvalidMediaFileId(40007, "不合法的媒体文件id"),
    InvalidMessageType(40008, "不合法的消息类型"),
    InvalidImageFileSize(40009, "不合法的图片文件大小"),
    InvalidVoiceFileSize(40010, "不合法的语音文件大小");

    private String msg;
    private long code;
    static private HashMap<Long, Errors> errors = new HashMap<Long, Errors>();

    Errors(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCode() {
        return code;
    }


    public static Errors get(long code) {
        if (errors.isEmpty()) {
            for (Errors e : Errors.values()) {
                errors.put(e.getCode(), e);
            }
        }
        return errors.get(code);
    }

}
