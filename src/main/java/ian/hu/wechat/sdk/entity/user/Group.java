package ian.hu.wechat.sdk.entity.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 用户组
 */
public class Group implements Serializable {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;

    public Group() {
    }

    public Group(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
