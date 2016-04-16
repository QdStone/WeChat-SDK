package ian.hu.wechat.sdk.service.core.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.service.Errors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 接口调用返回
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {
    private static final long serialVersionUID = -8572159414269679601L;
    /**
     * 获取错误码
     */
    @JsonProperty("errcode")
    private Long errorCode;

    /**
     * 获取错误提示
     */
    @JsonProperty("errmsg")
    private String errorMessage;

    /**
     * 获取错误码
     *
     * @return 0表示ok
     */
    public Long getErrorCode() {
        return errorCode == null ? Errors.OK.getCode() : errorCode;
    }

    public void setErrorMessage(String msg) {
        errorMessage = msg;
    }

    public void setErrorCode(long code) {
        errorCode = code;
    }

    /**
     * 返回枚举的错误
     * @return Errors
     *
     * @see Errors
     */
    public Errors getError() {
        return Errors.getByCode(getErrorCode());
    }
}
