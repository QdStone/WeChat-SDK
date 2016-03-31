package ian.hu.wechat.sdk.service.media.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageParam implements Serializable {
    private static final long serialVersionUID = -6245699211722796474L;
    @JsonProperty("type")
    private String type;
    @JsonProperty("offset")
    private int offset;
    @JsonProperty("count")
    private int count;
}
