package ian.hu.wechat.sdk.service.menu.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * menuid
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuIdHolder implements Serializable {
    private static final long serialVersionUID = -7451879530947664648L;
    @JsonProperty("menuid")
    private Long menuId;
}
