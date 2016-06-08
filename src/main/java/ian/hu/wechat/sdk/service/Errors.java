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

package ian.hu.wechat.sdk.service;

import java.util.HashMap;
import java.util.Map;

/**
 * 响应结果代码
 */
public enum Errors {
    /**
     * 调用成功
     */
    OK(0, "OK"),
    SYSTEM_BUSY(-1, "系统繁忙，此时请开发者稍候再试/功能未启用"),
    SYSTEM_ERROR(-2, "程序内部错误"),
    INVALID_TOKEN(40001, "获取access_token时AppSecret错误，或者access_token无效。请开发者认真比对AppSecret的正确性，或查看是否正在为恰当的公众号调用接口"),
    INVALID_CREDENTIAL(40002, "不合法的凭证类型"),
    INVALID_OPEN_ID(40003, "不合法的OpenID，请开发者确认OpenID（该用户）是否已关注公众号，或是否是其他公众号的OpenID"),
    INVALID_MEDIA_TYPE(40004, "不合法的媒体文件类型"),
    INVALID_FILE_TYPE(40005, "不合法的文件类型"),
    INVALID_FILE_SIZE(40006, "不合法的文件大小"),
    INVALID_MEDIA_FILE_ID(40007, "不合法的媒体文件id"),
    INVALID_MESSAGE_TYPE(40008, "不合法的消息类型"),
    INVALID_IMAGE_FILE_SIZE(40009, "不合法的图片文件大小"),
    INVALID_VOICE_FILE_SIZE(40010, "不合法的语音文件大小");

    private static final Map<Long, Errors> ERRORS_MAP = new HashMap<Long, Errors>();
    private final String msg;
    private final long code;

    Errors(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public long getCode() {
        return code;
    }

    public static Errors getByCode(long code) {
        if (ERRORS_MAP.isEmpty()) {
            for (Errors e : Errors.values()) {
                ERRORS_MAP.put(e.getCode(), e);
            }
        }
        return ERRORS_MAP.get(code);
    }

}
