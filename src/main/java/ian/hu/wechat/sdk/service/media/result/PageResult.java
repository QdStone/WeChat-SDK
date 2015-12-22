package ian.hu.wechat.sdk.service.media.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.service.core.result.Result;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PageResult extends Result {
    @JsonProperty("total_count")
    private Integer totalCount;
    @JsonProperty("item")
    private ArrayList<PageItem> items = new ArrayList<PageItem>();

    @JsonProperty("item_count")
    public Integer getItemCount() {
        if (items != null) {
            return items.size();
        }
        return null;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public ArrayList<PageItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<PageItem> items) {
        this.items = items;
    }

    @Override
    public Integer getErrorCode() {
        return totalCount == null ? super.getErrorCode() : 0;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "errorCode=" + getErrorCode() +
                ", errorMessage='" + getErrorMessage() + '\'' +
                ", totalCount=" + totalCount +
                ", items=" + items +
                '}';
    }
}
