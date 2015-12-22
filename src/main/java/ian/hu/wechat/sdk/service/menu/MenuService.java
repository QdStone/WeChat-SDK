package ian.hu.wechat.sdk.service.menu;

import ian.hu.wechat.sdk.entity.menu.Menu;
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

    public static final String DEFAULT_URL = "https://api.weixin.qq.com/cgi-bin/";

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("menu/create")
    CreateResult create(@QueryParam("access_token") String accessToken, Menu menu);

    @GET
    @Path("menu/delete")
    DeleteResult delete(@QueryParam("access_token") String accessToken);

    @GET
    @Path("menu/get")
    GetResult get(@QueryParam("access_token") String accessToken);

    @GET
    @Path("get_current_selfmenu_info")
    InfoResult info(@QueryParam("access_token") String accessToken);
}

