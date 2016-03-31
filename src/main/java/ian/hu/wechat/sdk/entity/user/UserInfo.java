package ian.hu.wechat.sdk.entity.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户信息
 */
@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -2990741543163967485L;
    @JsonProperty("suscribe")
    private Integer subscribe;
    @JsonProperty("openid")
    private String openId;
    @JsonProperty("nickname")
    private String nickname;
    /**
     * 性别 0为未知 1为男 2为女
     */
    @JsonProperty("sex")
    private Integer sex;
    @JsonProperty("language")
    private String language;
    @JsonProperty("city")
    private String city;
    @JsonProperty("province")
    private String province;
    @JsonProperty("country")
    private String country;
    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     */
    @JsonProperty("headimgurl")
    private String headImgUrl;
    /**
     * 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
     */
    @JsonProperty("subscribe_time")
    private Long subscribeTime;
    @JsonProperty("unionid")
    private String unionId;
    @JsonProperty("remark")
    private String remark;
    @JsonProperty("groupid")
    private Integer groupId;
}
