package ian.hu.wechat.sdk.entity.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * AccessToken
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccessToken implements Serializable {
    private static final long serialVersionUID = -5354404996063607521L;

    /**
     * access_token
     */
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * expires_in 单位：秒
     */
    @JsonProperty("expires_in")
    private Integer expiresIn;
}
