package ian.hu.wechat.sdk.service.media;

import ian.hu.wechat.sdk.Bootstrap;
import ian.hu.wechat.sdk.TestConstants;
import ian.hu.wechat.sdk.entity.media.NewsItem;
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

/**
 * Tests for MediaService
 */
public class MediaServiceTest {
    static ResteasyClient client = new ResteasyClientBuilder().disableTrustManager().build();
    static File file = new File(MediaServiceTest.class.getResource("/media/IMAG0047.jpg").getFile());
    static File video = new File(MediaServiceTest.class.getResource("/media/1.mp4").getFile());

    static String imageMediaId;

    static MediaService service = ServiceHelper.get(client, /*"http://weimob.tunnel.qydev.com/"*/null, MediaService.class);

    @BeforeClass
    public static void beforeClass() {
        Bootstrap.beforeStart();
    }

    @Test
    public void test_create2() {
        MultipartFormDataOutput output = MediaHelper.fromFile(file, null);
        CreateResult result = service.create(TestConstants.accessToken, "image", output);
        System.out.println(result);
        Assert.assertEquals(Integer.valueOf(0), result.getErrorCode());
        imageMediaId = result.getMedia().getMediaId();
    }

    @Test
    public void test_get() {
        Response response = service.get(TestConstants.accessToken, imageMediaId);
        System.out.println(GetResult.from(response));
    }

    @Test
    public void test_upload() {
        MultipartFormDataOutput output = MediaHelper.fromFile(file, "media");
        UploadResult result = service.uploadImage(TestConstants.accessToken, output);
        System.out.println(result);
        Assert.assertEquals(result.getErrorCode().intValue(), 0);
    }

    @Test
    public void test_addMaterial_video() {
        MultipartFormDataOutput output = MediaHelper.fromFile(video, null);
        MediaHelper.addVideoDescription(output, "群之歌", "给群友群主的一首歌");
        AddMaterialResult result = service.addMaterial(TestConstants.accessToken, MediaService.TYPE_VIDEO, output);
        System.out.println(result);
    }

    @Test
    public void test_addNews() {
        AddMaterialResult result = service.addMaterial(TestConstants.accessToken, "image", MediaHelper.fromFile(file, null));
        Assert.assertEquals(Integer.valueOf(0), result.getErrorCode());
        AddNewsParam param = new AddNewsParam();
        ArrayList<NewsItem> news = new ArrayList<NewsItem>();
        NewsItem item = new NewsItem();
        item.setTitle("TestNews");
        item.setContent("Test Content with string");
        item.setAuthor("Ian");
        item.setDigest("Test Digest");
        item.setShowCoverPic(1);
        item.setThumbMediaId(result.getMediaId());
        news.add(item);
        param.setNews(news);
        AddNewsResult result1 = service.addNews(TestConstants.accessToken, param);
        System.out.println(result1);
    }

    @Test
    public void test_count() {
        CountResult result = service.getCount(TestConstants.accessToken);
        System.out.println(result);
    }

    @Test
    public void test_getPage() {
        PageResult result = service.getPage(TestConstants.accessToken, new PageParam("news", 0, 3));
        System.out.println(result);
    }

    @Test
    public void test_getMaterial() {
        GetMaterialResult result = GetMaterialResult.from(service.getMaterial(TestConstants.accessToken, new MediaIdHolder("")));
        System.out.println(result);
    }
}
