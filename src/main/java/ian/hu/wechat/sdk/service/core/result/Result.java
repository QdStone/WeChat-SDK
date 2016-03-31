package ian.hu.wechat.sdk.service.core.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 接口调用返回
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {
    private static final long serialVersionUID = -8572159414269679601L;
    /**
     * 获取错误码
     */
    @JsonProperty("errcode")
    private Integer errorCode;

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
    public Integer getErrorCode() {
        return errorCode == null ? 0 : errorCode;
    }

}
