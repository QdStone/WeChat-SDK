package ian.hu.wechat.sdk.service;

import ian.hu.wechat.sdk.Bootstrap;
import ian.hu.wechat.sdk.TestConstants;
import ian.hu.wechat.sdk.service.core.AccessTokenService;
import ian.hu.wechat.sdk.service.core.result.AccessTokenResult;
import org.apache.commons.lang.reflect.FieldUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test for ServiceHelper
 */
public class ServiceHelperTests {

    @BeforeClass
    public static void beforeClass() {
        Bootstrap.beforeStart();
    }

    @Test
    public void test_getStaticFinalField() throws IllegalAccessException {
        Assert.assertEquals(AccessTokenService.DEFAULT_URL, FieldUtils.getField(AccessTokenService.class, "DEFAULT_URL").get(AccessTokenService.class));
    }

    @Test
    public void test_getAccessTokenService() {
        AccessTokenService service = ServiceHelper.get(AccessTokenService.class);
        AccessTokenResult result = service.get(TestConstants.appId, TestConstants.appSecret, AccessTokenService.GRANT_TYPE_CLIENT_CREDENTIAL);
        System.out.println(result);
        Assert.assertNull(result.getErrorCode());
    }
}
