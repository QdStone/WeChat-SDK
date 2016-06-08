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

package ian.hu.wechat.sdk.service.media;

import ian.hu.wechat.sdk.rest.annotation.OverrideMediaType;
import ian.hu.wechat.sdk.service.Service;
import ian.hu.wechat.sdk.service.core.result.Result;
import ian.hu.wechat.sdk.service.media.param.AddNewsParam;
import ian.hu.wechat.sdk.service.media.param.MediaIdHolder;
import ian.hu.wechat.sdk.service.media.param.PageParam;
import ian.hu.wechat.sdk.service.media.param.UpdateNewsParam;
import ian.hu.wechat.sdk.service.media.result.*;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;

/**
 * 素材服务
 */
@Produces(MediaType.APPLICATION_JSON)
public interface MediaService extends Service {

    /**
     * 图片素材
     */
    String TYPE_IMAGE = "image";
    /**
     * 语音素材
     */
    String TYPE_VOICE = "voice";
    /**
     * 视频素材
     */
    String TYPE_VIDEO = "video";
    /**
     * 缩略图素材
     */
    String TYPE_THUMB = "thumb";

    /**
     * 微信api地址
     */
    String DEFAULT_URL = "https://api.weixin.qq.com/cgi-bin/";


    /**
     * 创建临时素材
     *
     * @param accessToken access token
     * @param type        素材类型
     * @param output      素材数据，使用 {@link MediaHelper#fromFile(File, String)} 来获得
     * @return CreateResult
     */
    @POST
    @Path("media/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    CreateResult create(@QueryParam("access_token") String accessToken, @QueryParam("type") String type, MultipartFormDataOutput output);


    /**
     * 获取临时素材
     *
     * @param accessToken accessToken
     * @param mediaId     素材id
     * @return 返回结果，使用 {@link GetResult#from(Response)} 来读取
     */
    @GET
    @Path("media/getService")
    @Produces(MediaType.WILDCARD)
    Response get(@QueryParam("access_token") String accessToken, @QueryParam("media_id") String mediaId);

    /**
     * 上传图文中的图片
     *
     * @param accessToken access_token
     * @param output      素材数据，使用 {@link MediaHelper#fromFile(File, String)} 来获得
     * @return 上传结果
     */
    @POST
    @Path("media/uploadimg")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    UploadResult uploadImage(@QueryParam("access_token") String accessToken, MultipartFormDataOutput output);

    /**
     * 添加图文素材
     *
     * @param accessToken access_token
     * @param param param
     * @return result
     */
    @POST
    @Path("material/add_news")
    @Consumes(MediaType.APPLICATION_JSON)
    AddNewsResult addNews(@QueryParam("access_token") String accessToken, AddNewsParam param);

    /**
     * 添加其他素材
     * <p>
     * <ol><li>新增的永久素材也可以在公众平台官网素材管理模块中看到</li>
     * <li>永久素材的数量是有上限的，请谨慎新增。图文消息素材和图片素材的上限为5000，其他类型为1000</li>
     * <li>素材的格式大小等要求与公众平台官网一致。具体是，图片大小不超过2M，支持bmp/png/jpeg/jpg/gif格式，语音大小不超过5M，长度不超过60秒，支持mp3/wma/wav/amr格式</li>
     * <li>调用该接口需https协议</li></ol>
     *
     * @param accessToken access_token
     * @param type        {@link #TYPE_IMAGE},{@link #TYPE_VOICE},{@link #TYPE_VIDEO},{@link #TYPE_THUMB}
     * @param output      使用{@link MediaHelper#fromFile(File, String)},{@link MediaHelper#addVideoDescription(MultipartFormDataOutput, String, String)}来构造
     * @return 添加结果
     */
    @POST
    @Path("material/add_material")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    AddMaterialResult addMaterial(@QueryParam("access_token") String accessToken, @QueryParam("type") String type, MultipartFormDataOutput output);

    /**
     * 获取永久素材
     *
     * @param accessToken access_token
     * @param param param
     * @return 返回结果，使用 {@link GetMaterialResult#from(Response)} 来读取
     */
    @POST
    @Path("material/get_material")
    @Consumes(MediaType.APPLICATION_JSON)
    Response getMaterial(@QueryParam("access_token") String accessToken, MediaIdHolder param);

    @POST
    @Path("material/del_material")
    @Consumes(MediaType.APPLICATION_JSON)
    @OverrideMediaType(MediaType.APPLICATION_JSON)
    Result deleteMaterial(@QueryParam("access_token") String accessToken, MediaIdHolder param);

    @POST
    @Path("material/update_news")
    @Consumes(MediaType.APPLICATION_JSON)
    @OverrideMediaType(MediaType.APPLICATION_JSON)
    Result updateNews(@QueryParam("access_token") String accessToken, UpdateNewsParam param);

    @GET
    @Path("material/get_materialcount")
    @OverrideMediaType(MediaType.APPLICATION_JSON)
    CountResult getCount(@QueryParam("access_token") String accessToken);

    @POST
    @Path("material/batchget_material")
    @Consumes(MediaType.APPLICATION_JSON)
    @OverrideMediaType(MediaType.APPLICATION_JSON)
    PageResult getPage(@QueryParam("access_token") String accessToken, PageParam param);
}
