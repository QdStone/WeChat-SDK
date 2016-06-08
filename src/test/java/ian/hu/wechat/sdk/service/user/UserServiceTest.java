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
public class UserServiceTest {

    static final ResteasyClient client = new ResteasyClientBuilder().disableTrustManager().build();
    static final UserService service = ServiceHelper.getService(client, /*"http://weimob.tunnel.qydev.com/"*/null, UserService.class);

    @BeforeClass
    public static void beforeClass() {
        Bootstrap.beforeStart();
    }

    @Test
    public void test_addGroup() {
        AddGroupResult result = service.addGroup(TestConstants.ACCESS_TOKEN, new AddGroupParam("Test"));
        System.out.println(result);
    }

    @Test
    public void test_getGroups() {
        GetGroupsResult result = service.getGroups(TestConstants.ACCESS_TOKEN);
        System.out.println(result);
    }

    @Test
    public void test_getGroup() {
        GetUserGroupResult result = service.getGroup(TestConstants.ACCESS_TOKEN, new OpenIdHolder("ojCVvuA6W4w7fSyVywNkLowz9MXA"));
        System.out.println(result);
    }

    @Test
    public void test_updateGroup() {
        Result result = service.updateGroup(TestConstants.ACCESS_TOKEN, new UpdateGroupParam(new Group(100, "测试")));
        System.out.println(result);
    }

    @Test
    public void test_memberUpdate() {
        Result result = service.memberUpdate(TestConstants.ACCESS_TOKEN, new MemberUpdateParam("ojCVvuA6W4w7fSyVywNkLowz9MXA", 100));
        System.out.println(result);
    }
}
