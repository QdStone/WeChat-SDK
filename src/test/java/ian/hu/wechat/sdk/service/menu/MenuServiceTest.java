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
public class MenuServiceTest {

    @BeforeClass
    public static void beforeClass() {
        Bootstrap.beforeStart();
    }

    @Test
    public void test_getMenu() {
        MenuService service = ServiceHelper.getService(MenuService.class);
        GetResult result = service.get(TestConstants.ACCESS_TOKEN);
        System.out.println(result);
        Assert.assertEquals(0, (long) result.getErrorCode());
    }
}
