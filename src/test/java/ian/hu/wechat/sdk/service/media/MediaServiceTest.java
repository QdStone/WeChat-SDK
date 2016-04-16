package ian.hu.wechat.sdk.service.media;

import ian.hu.wechat.sdk.Bootstrap;
import ian.hu.wechat.sdk.TestConstants;
import ian.hu.wechat.sdk.entity.media.NewsItem;
import ian.hu.wechat.sdk.service.Errors;
import ian.hu.wechat.sdk.service.ServiceHelper;
import ian.hu.wechat.sdk.service.media.param.AddNewsParam;
import ian.hu.wechat.sdk.service.media.param.MediaIdHolder;
import ian.hu.wechat.sdk.service.media.param.PageParam;
import ian.hu.wechat.sdk.service.media.result.*;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests for MediaService
 */
public class MediaServiceTest {
    static final ResteasyClient client = new ResteasyClientBuilder().disableTrustManager().build();
    static final File file = new File(MediaServiceTest.class.getResource("/media/IMAG0047.jpg").getFile());
    static final File video = new File(MediaServiceTest.class.getResource("/media/1.mp4").getFile());

    static String imageMediaId;
    static String materialMediaId;

    static final MediaService service = ServiceHelper.getService(client, /*"http://weimob.tunnel.qydev.com/"*/null, MediaService.class);

    @BeforeClass
    public static void beforeClass() {
        Bootstrap.beforeStart();
    }

    @Test
    public void test_create2() {
        MultipartFormDataOutput output = MediaHelper.fromFile(file, null);
        CreateResult result = service.create(TestConstants.ACCESS_TOKEN, "image", output);
        System.out.println(result);
        Assert.assertEquals(Errors.OK, result.getError());
        imageMediaId = result.getMedia().getMediaId();
    }

    @Test
    public void test_get() {
        Response response = service.get(TestConstants.ACCESS_TOKEN, imageMediaId);
        System.out.println(GetResult.from(response));
    }

    @Test
    public void test_upload() {
        MultipartFormDataOutput output = MediaHelper.fromFile(file, "media");
        UploadResult result = service.uploadImage(TestConstants.ACCESS_TOKEN, output);
        System.out.println(result);
        Assert.assertEquals(0, result.getErrorCode().intValue());
    }

    @Test
    public void test_addMaterial_video() {
        MultipartFormDataOutput output = MediaHelper.fromFile(video, null);
        MediaHelper.addVideoDescription(output, "群之歌", "给群友群主的一首歌");
        AddMaterialResult result = service.addMaterial(TestConstants.ACCESS_TOKEN, MediaService.TYPE_VIDEO, output);
        System.out.println(result);
    }

    @Test
    public void test_addNews() {
        AddMaterialResult result = service.addMaterial(TestConstants.ACCESS_TOKEN, "image", MediaHelper.fromFile(file, null));
        Assert.assertEquals(Errors.OK, result.getError());
        AddNewsParam param = new AddNewsParam();
        List<NewsItem> news = new ArrayList<>();
        NewsItem item = new NewsItem();
        item.setTitle("TestNews");
        item.setContent("Test Content with string");
        item.setAuthor("Ian");
        item.setDigest("Test Digest");
        item.setShowCoverPic(1);
        item.setThumbMediaId(result.getMediaId());
        news.add(item);
        param.setNews(news);
        AddNewsResult result1 = service.addNews(TestConstants.ACCESS_TOKEN, param);
        System.out.println(result1);
        Assert.assertTrue(result1.getError() == Errors.OK || result1.getError() == Errors.getByCode(45009));
        materialMediaId = result1.getMediaId();
    }

    @Test
    public void test_count() {
        CountResult result = service.getCount(TestConstants.ACCESS_TOKEN);
        System.out.println(result);
        Assert.assertEquals(Errors.OK, result.getError());
    }

    @Test
    public void test_getPage() {
        PageResult result = service.getPage(TestConstants.ACCESS_TOKEN, new PageParam("news", 0, 3));
        System.out.println(result);
        Assert.assertEquals(Errors.OK, result.getError());
    }

    @Test
    public void test_getMaterial() {
        GetMaterialResult result = GetMaterialResult.from(service.getMaterial(TestConstants.ACCESS_TOKEN, new MediaIdHolder(materialMediaId)));
        System.out.println(result);
        Assert.assertEquals(Errors.OK, result.getError());
    }
}
