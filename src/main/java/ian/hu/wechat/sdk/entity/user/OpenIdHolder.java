package ian.hu.wechat.sdk.entity.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * OpenId
 */
@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OpenIdHolder implements Serializable {
    private static final long serialVersionUID = -3845277766474328892L;
    @JsonProperty("openid")
    private String openId;
}
