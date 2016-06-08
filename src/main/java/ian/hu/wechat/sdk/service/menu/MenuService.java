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

package ian.hu.wechat.sdk.service.menu;

import ian.hu.wechat.sdk.entity.menu.Menu;
import ian.hu.wechat.sdk.entity.menu.PersonalMenu;
import ian.hu.wechat.sdk.service.Service;
import ian.hu.wechat.sdk.service.menu.param.MatchParam;
import ian.hu.wechat.sdk.service.menu.param.MenuIdHolder;
import ian.hu.wechat.sdk.service.menu.result.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * 微信菜单服务
 */
@Produces(MediaType.APPLICATION_JSON)
public interface MenuService extends Service {

    String DEFAULT_URL = "https://api.weixin.qq.com/cgi-bin/";

    /**
     * 创建自定义菜单
     * @param accessToken access_token
     * @param menu 菜单数据
     * @return 结果
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("menu/create")
    CreateResult create(@QueryParam("access_token") String accessToken, Menu menu);

    /**
     * 删除自定义菜单
     * @param accessToken acess_token
     * @return 结果
     */
    @GET
    @Path("menu/delete")
    DeleteResult delete(@QueryParam("access_token") String accessToken);

    /**
     * 自定义菜单查询接口
     * @param accessToken accessToken
     * @return 结果
     */
    @GET
    @Path("menu/getByCode")
    GetResult get(@QueryParam("access_token") String accessToken);

    /**
     * 获取自定义菜单配置接口
     *
     * @param accessToken access_token
     * @return 结果
     */
    @GET
    @Path("get_current_selfmenu_info")
    InfoResult info(@QueryParam("access_token") String accessToken);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("menu/addconditional")
    CreateResult createPersonalMenu(@QueryParam("access_token") String accessToken, PersonalMenu menu);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("menu/delconditional")
    DeleteResult deletePersonalMenu(@QueryParam("access_token") String accessToken, MenuIdHolder menuId);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("menu/trymatch")
    MatchResult tryMatch(@QueryParam("access_token") String accessToken, MatchParam userId);
}

