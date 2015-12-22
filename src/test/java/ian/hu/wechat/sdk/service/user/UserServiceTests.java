package ian.hu.wechat.sdk.service.user;

import ian.hu.wechat.sdk.Bootstrap;
import ian.hu.wechat.sdk.TestConstants;
import ian.hu.wechat.sdk.entity.user.Group;
import ian.hu.wechat.sdk.entity.user.OpenIdHolder;
import ian.hu.wechat.sdk.service.ServiceHelper;
import ian.hu.wechat.sdk.service.core.result.Result;
import ian.hu.wechat.sdk.service.user.param.AddGroupParam;
import ian.hu.wechat.sdk.service.user.param.MemberUpdateParam;
import ian.hu.wechat.sdk.service.user.param.UpdateGroupParam;
import ian.hu.wechat.sdk.service.user.result.AddGroupResult;
import ian.hu.wechat.sdk.service.user.result.GetGroupsResult;
import ian.hu.wechat.sdk.service.user.result.GetUserGroupResult;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests for UserService
 */
public class UserServiceTests {

    static ResteasyClient client = new ResteasyClientBuilder().disableTrustManager().build();
    static UserService service = ServiceHelper.get(client, /*"http://weimob.tunnel.qydev.com/"*/null, UserService.class);

    @BeforeClass
    public static void beforeClass() {
        Bootstrap.beforeStart();
    }

    @Test
    public void test_addGroup() {
        AddGroupResult result = service.addGroup(TestConstants.accessToken, new AddGroupParam("Test"));
        System.out.println(result);
    }

    @Test
    public void test_getGroups() {
        GetGroupsResult result = service.getGroups(TestConstants.accessToken);
        System.out.println(result);
    }

    @Test
    public void test_getGroup() {
        GetUserGroupResult result = service.getGroup(TestConstants.accessToken, new OpenIdHolder("ojCVvuA6W4w7fSyVywNkLowz9MXA"));
        System.out.println(result);
    }

    @Test
    public void test_updateGroup() {
        Result result = service.updateGroup(TestConstants.accessToken, new UpdateGroupParam(new Group(100, "测试")));
        System.out.println(result);
    }

    @Test
    public void test_memberUpdate() {
        Result result = service.memberUpdate(TestConstants.accessToken, new MemberUpdateParam("ojCVvuA6W4w7fSyVywNkLowz9MXA", 100));
        System.out.println(result);
    }
}
