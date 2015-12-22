package ian.hu.wechat.sdk.service.media.param;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class PageParam implements Serializable {
    @JsonProperty("type")
    private String type;
    @JsonProperty("offset")
    private int offset;
    @JsonProperty("count")
    private int count;

    public PageParam() {
    }

    public PageParam(String type, int offset, int count) {
        this.type = type;
        this.offset = offset;
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
