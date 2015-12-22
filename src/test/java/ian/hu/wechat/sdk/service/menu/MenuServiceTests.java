package ian.hu.wechat.sdk.service.menu;

import ian.hu.wechat.sdk.Bootstrap;
import ian.hu.wechat.sdk.TestConstants;
import ian.hu.wechat.sdk.service.ServiceHelper;
import ian.hu.wechat.sdk.service.menu.result.GetResult;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests for MenuServices
 */
public class MenuServiceTests {

    @BeforeClass
    public static void beforeClass() {
        Bootstrap.beforeStart();
    }

    @Test
    public void test_getMenu() {
        MenuService service = ServiceHelper.get(MenuService.class);
        GetResult result = service.get(TestConstants.accessToken);
        System.out.println(result);
        Assert.assertTrue(result.getErrorCode().equals(0));
    }
}
