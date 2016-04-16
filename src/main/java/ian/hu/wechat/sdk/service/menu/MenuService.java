package ian.hu.wechat.sdk.service.menu;

import ian.hu.wechat.sdk.entity.menu.Menu;
import ian.hu.wechat.sdk.entity.menu.PersonalMenu;
import ian.hu.wechat.sdk.service.Service;
import ian.hu.wechat.sdk.service.menu.result.CreateResult;
import ian.hu.wechat.sdk.service.menu.result.DeleteResult;
import ian.hu.wechat.sdk.service.menu.result.GetResult;
import ian.hu.wechat.sdk.service.menu.result.InfoResult;

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
    @Path("menu/create")
    CreateResult createPersonalMenu(@QueryParam("access_token") String accessToken, PersonalMenu menu);
}

