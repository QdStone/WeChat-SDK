/*
 * Copyright 2014-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ian.hu.wechat.sdk.entity.response;

import java.io.Serializable;

/**
 * 加密的消息的接口
 */
public interface EncryptResponse extends Serializable {
    /**
     * 转化为RawResponse
     *
     * @param args 解密相关参数
     * @return 转化失败反悔null
     */
    RawResponse toRaw(String... args);

    /**
     * 从RawResponse填充此对象
     *
     * @param response response
     * @param args     加密相关参数
     * @return 加密失败反回null
     */
    EncryptResponse fromRaw(RawResponse response, String... args);
}
