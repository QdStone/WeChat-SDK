package ian.hu.wechat.sdk.entity.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户组
 */
@Data

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Group implements Serializable {
    private static final long serialVersionUID = -2160648720333766685L;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
}
