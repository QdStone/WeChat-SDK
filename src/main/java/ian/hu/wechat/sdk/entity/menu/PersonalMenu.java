package ian.hu.wechat.sdk.entity.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Locale;

/**
 * 个性化菜单
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PersonalMenu extends Menu {
    private static final long serialVersionUID = -1142868039501135934L;

    @JsonProperty("matchrule")
    private MatchRule matchRule;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class MatchRule implements Serializable {

        private static final long serialVersionUID = -7253167071841347953L;
        /**
         * 分组，选填
         */
        @JsonProperty("group_id")
        private Integer groupId;
        /**
         * 性别，选填
         *
         * @see Gender#MALE
         * @see Gender#FEMALE
         * @see Gender#ordinal()
         */
        @JsonProperty("sex")
        private Integer gender;

        /**
         * 平台，可选
         *
         * @see PlatfromType
         * @see PlatfromType#ordinal()
         */
        @JsonProperty("client_paltform_type")
        private Integer clientPlatformType;

        /**
         * 国家，可选
         */
        @JsonProperty("country")
        private String country;
        /**
         * 省份，可选
         */
        @JsonProperty("province")
        private String province;
        /**
         * 城市，可选
         */
        @JsonProperty("city")
        private String city;

        /**
         * 语言，可选
         *
         * @see Locale#getDisplayLanguage()
         */
        @JsonProperty("language")
        private String language;
    }

    public enum Gender {
        NA, MALE, FEMALE
    }

    public enum PlatfromType {
        NA, IOS, ANDROID, OTHERS
    }
}
