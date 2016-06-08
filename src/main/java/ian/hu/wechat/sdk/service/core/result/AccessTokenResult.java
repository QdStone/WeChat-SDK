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

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import ian.hu.wechat.sdk.entity.core.AccessToken;
import ian.hu.wechat.sdk.service.Errors;

/**
 * 获取AccessToken的结果
 */
public class AccessTokenResult extends Result {
    private static final long serialVersionUID = -1840549668432357528L;
    @JsonUnwrapped
    private AccessToken accessToken;

    /**
     * 返回获取到的accessToken
     *
     * @return 获取失败时为null
     */
    public AccessToken getAccessToken() {
        return accessToken == null || accessToken.getAccessToken() == null ? null : accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public Long getErrorCode() {
        return getAccessToken() == null ? super.getErrorCode() : Errors.OK.getCode();
    }

    @Override
    public String toString() {
        return "AccessTokenResult{" +
                "accessToken=" + getAccessToken() +
                ", errorCode=" + getErrorCode() +
                ", errorMessage='" + getErrorMessage() + '\'' +
                '}';
    }
}
