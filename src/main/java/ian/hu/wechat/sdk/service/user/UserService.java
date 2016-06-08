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

package ian.hu.wechat.sdk.service.user;

import ian.hu.wechat.sdk.entity.user.OpenIdHolder;
import ian.hu.wechat.sdk.service.Service;
import ian.hu.wechat.sdk.service.core.result.Result;
import ian.hu.wechat.sdk.service.user.param.*;
import ian.hu.wechat.sdk.service.user.result.AddGroupResult;
import ian.hu.wechat.sdk.service.user.result.GetGroupsResult;
import ian.hu.wechat.sdk.service.user.result.GetUserGroupResult;
import ian.hu.wechat.sdk.service.user.result.GetUserInfoResult;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * 用户管理接口
 */
@Produces(MediaType.APPLICATION_JSON)
public interface UserService extends Service {
    String DEFAULT_URL = "https://api.weixin.qq.com/cgi-bin/";

    @POST
    @Path("groups/create")
    @Consumes(MediaType.APPLICATION_JSON)
    AddGroupResult addGroup(@QueryParam("access_token") String accessToken, AddGroupParam param);

    @GET
    @Path("groups/getService")
    GetGroupsResult getGroups(@QueryParam("access_token") String accessToken);

    @POST
    @Path("groups/getid")
    @Consumes(MediaType.APPLICATION_JSON)
    GetUserGroupResult getGroup(@QueryParam("access_token") String accessToken, OpenIdHolder openId);

    @POST
    @Path("groups/update")
    @Consumes(MediaType.APPLICATION_JSON)
    Result updateGroup(@QueryParam("access_token") String accessToken, UpdateGroupParam param);

    @POST
    @Path("groups/members/update")
    @Consumes(MediaType.APPLICATION_JSON)
    Result memberUpdate(@QueryParam("access_token") String accessToken, MemberUpdateParam param);

    @POST
    @Path("groups/members/batchupdate")
    @Consumes(MediaType.APPLICATION_JSON)
    Result membersUpdate(@QueryParam("access_token") String accessToken, MembersUpdateParam param);


    @POST
    @Path("groups/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    Result deleteGroup(@QueryParam("access_token") String accessToken, DeleteGroupParam param);

    @POST
    @Path("user/info/updateremark")
    @Consumes(MediaType.APPLICATION_JSON)
    Result updateRemark(@QueryParam("access_token") String accessToken, UpdateRemarkParam param);

    /**
     * @param accessToken accessToken
     * @param openId      openid
     * @param language    返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @return GetUserInfoResult
     */
    @GET
    @Path("user/info")
    GetUserInfoResult getInfo(@QueryParam("access_token") String accessToken, @QueryParam("openid") String openId, @QueryParam("lang") String language);
}
