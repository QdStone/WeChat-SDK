package ian.hu.wechat.sdk.service.media.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.rest.annotation.OverrideMediaType;
import ian.hu.wechat.sdk.service.core.result.Result;

import javax.ws.rs.core.MediaType;

/**
 * 上传图片获取链接的结果
 */
@OverrideMediaType(MediaType.APPLICATION_JSON)
public class UploadResult extends Result {
    @JsonProperty("url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Integer getErrorCode() {
        return url == null ? super.getErrorCode() : 0;
    }

    @Override
    public String toString() {
        return "UploadResult{" +
                "url='" + url + '\'' +
                ", errorCode=" + getErrorCode() +
                ", errorMessage='" + getErrorMessage() + '\'' +
                '}';
    }
}
