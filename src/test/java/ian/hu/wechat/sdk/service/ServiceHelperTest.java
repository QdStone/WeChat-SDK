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
public class ServiceHelperTest {

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
        AccessTokenService service = ServiceHelper.getService(AccessTokenService.class);
        AccessTokenResult result = service.get(TestConstants.APP_ID, TestConstants.APP_SECRET, AccessTokenService.GRANT_TYPE_CLIENT_CREDENTIAL);
        System.out.println(result);
        Assert.assertEquals(Errors.OK, result.getError());
    }
}
