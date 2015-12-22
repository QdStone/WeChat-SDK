package ian.hu.wechat.sdk.service.core.result;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 接口调用返回
 */
public class Result implements Serializable {
    @JsonProperty("errcode")
    private Integer errorCode;
    @JsonProperty("errmsg")
    private String errorMessage;

    /**
     * 获取错误码
     *
     * @return 0表示ok
     */
    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 获取错误提示
     *
     * @return 提示消息
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "Result{" +
                "errorCode=" + getErrorCode() +
                ", errorMessage='" + getErrorMessage() + '\'' +
                '}';
    }
}
