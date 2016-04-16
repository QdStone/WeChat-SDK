package ian.hu.wechat.sdk.service.media.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.service.Errors;
import ian.hu.wechat.sdk.service.core.result.Result;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageResult extends Result {
    private static final long serialVersionUID = -1422930710547205825L;
    @JsonProperty("total_count")
    private Integer totalCount;
    @JsonProperty("item")
    private List<PageItem> items = new ArrayList<PageItem>();

    @JsonProperty("item_count")
    public Integer getItemCount() {
        if (items != null) {
            return items.size();
        }
        return null;
    }

    @Override
    public Long getErrorCode() {
        return totalCount == null ? super.getErrorCode() : Errors.OK.getCode();
    }
}
