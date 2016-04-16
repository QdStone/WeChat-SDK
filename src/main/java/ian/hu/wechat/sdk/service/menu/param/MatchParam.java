package ian.hu.wechat.sdk.service.menu.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * user_id可以是粉丝的OpenID，也可以是粉丝的微信号。
 */
@Data
public class MatchParam implements Serializable {
    private static final long serialVersionUID = -620551251936203843L;
    @JsonProperty("user_id")
    private String userId;
}
