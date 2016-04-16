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

    public static final String DEFAULT_URL = "https://api.weixin.qq.com/cgi-bin/";
    public static final String GRANT_TYPE_CLIENT_CREDENTIAL = "client_credential";


    /**
     * 获取access_token
     * 开发者需要自行缓存token
     * @param appId appid
     * @param appSecret appSecret
     * @param grantType 默认client_credential
     * @return AccessToken
     */
    @GET
    @Path("token")
    @Consumes
    AccessTokenResult get(@QueryParam("appid") String appId, @QueryParam("secret") String appSecret, @DefaultValue("client_credential") @QueryParam("grant_type") String grantType);
}
