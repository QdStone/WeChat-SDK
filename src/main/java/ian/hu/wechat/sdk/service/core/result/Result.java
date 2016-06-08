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

package ian.hu.wechat.sdk.service.core.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.service.Errors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 接口调用返回
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {
    private static final long serialVersionUID = -8572159414269679601L;
    /**
     * 获取错误码
     */
    @JsonProperty("errcode")
    private Long errorCode;

    /**
     * 获取错误提示
     */
    @JsonProperty("errmsg")
    private String errorMessage;

    /**
     * 获取错误码
     *
     * @return 0表示ok
     */
    public Long getErrorCode() {
        return errorCode == null ? Errors.OK.getCode() : errorCode;
    }

    public void setErrorMessage(String msg) {
        errorMessage = msg;
    }

    public void setErrorCode(long code) {
        errorCode = code;
    }

    /**
     * 返回枚举的错误
     * @return Errors
     *
     * @see Errors
     */
    public Errors getError() {
        return Errors.getByCode(getErrorCode());
    }

    /**
     * 是否成功
     * @return booelan
     */
    public boolean isOK() {
        return getErrorCode() == Errors.OK.getCode();
    }
}
