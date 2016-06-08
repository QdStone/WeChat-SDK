/*
 *
 *  * Copyright 2014-2016 the original author or authors.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package ian.hu.wechat.sdk.service.core;

import ian.hu.wechat.sdk.service.core.result.AccessTokenResult;
import ian.hu.wechat.sdk.service.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Access Token接口
 */
@Produces(MediaType.APPLICATION_JSON)
public interface AccessTokenService extends Service {

    String DEFAULT_URL = "https://api.weixin.qq.com/cgi-bin/";
    String GRANT_TYPE_CLIENT_CREDENTIAL = "client_credential";


    /**
     * 获取access_token
     * 开发者需要自行缓存token
     * @param appId appid
     * @param appSecret appSecret
     * @param grantType 默认client_credential {@link #GRANT_TYPE_CLIENT_CREDENTIAL}
     * @return AccessToken
     */
    @GET
    @Path("token")
    @Consumes
    AccessTokenResult get(@QueryParam("appid") String appId, @QueryParam("secret") String appSecret, @DefaultValue("client_credential") @QueryParam("grant_type") String grantType);
}
