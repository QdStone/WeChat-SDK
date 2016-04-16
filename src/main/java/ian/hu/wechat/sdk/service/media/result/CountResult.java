package ian.hu.wechat.sdk.service.media.result;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import ian.hu.wechat.sdk.entity.media.MediaCount;
import ian.hu.wechat.sdk.service.core.result.Result;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CountResult extends Result {
    private static final long serialVersionUID = 3973137835057125082L;
    @JsonUnwrapped
    private MediaCount mediaCount;
}
