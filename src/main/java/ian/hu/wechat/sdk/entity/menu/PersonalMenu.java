/*
 * Copyright 2014-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
@EqualsAndHashCode(callSuper = true)
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
