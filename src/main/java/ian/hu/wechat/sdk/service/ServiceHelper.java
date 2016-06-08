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

import ian.hu.wechat.sdk.debug.LoggingFilter;
import ian.hu.wechat.sdk.rest.FixedMultipartFormDataWriter;
import ian.hu.wechat.sdk.rest.annotation.OverrideMediaType;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang.reflect.FieldUtils;
import org.apache.commons.logging.LogFactory;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.util.FindAnnotation;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import java.io.IOException;

/**
 * 微信服务工具类
 */
@CommonsLog
public final class ServiceHelper {

    public static <T extends Service> T getService(Client client, String baseUrl, Class<T> clazz) {

        if (client == null) {
            client = ClientBuilder.newClient();
        }
        client.register(MediaTypeInterceptor.class);
        if (LogFactory.getLog(clazz).isDebugEnabled()) {
            client.register(LoggingFilter.class);
        }

        client.register(FixedMultipartFormDataWriter.class);
        if (baseUrl == null) {
            try {
                baseUrl = FieldUtils.getDeclaredField(clazz, "DEFAULT_URL").get(clazz).toString();
            } catch (IllegalAccessException e) {
                log.warn("faild to getService DEFAULT_URL and the baseUrl param is null", e);
            }
        }
        ResteasyWebTarget target = (ResteasyWebTarget) client.target(baseUrl);
        return target.proxy(clazz);
    }

    public static <T extends Service> T getService(Client client, Class<T> clazz) {
        return getService(client, null, clazz);
    }

    public static <T extends Service> T getService(Class<T> clazz) {
        return getService(null, null, clazz);
    }

    /**
     * 由于微信返回内容的Content-Type并不一定是所期望的，{@link #aroundReadFrom(ReaderInterceptorContext)}将希望重写的Content-Type进行重写
     * 使用{@link OverrideMediaType}注解来标记需要重写的请求结果实体或者请求方法
     * <pre>
     * <code>// on pojo or form
     *     {@literal @}OverrideMediaType(value = MediaType.APPLICATION_JSON, from = "text/*")
     *     public class ForceJsonObj implements Serializable {
     *          ...
     *     }
     *     // or on method
     *     {@literal @}GET
     *     {@literal @}OverrideMediaType(MediaType.APPLICATION_JSON)
     *     MyJsonObj getService(...);
     * }
     * </code>
     * </pre>
     *
     * @see OverrideMediaType
     */
    @Provider
    @Priority(Priorities.USER)
    public static class MediaTypeInterceptor implements ReaderInterceptor {

        /**
         * @param context context
         * @return object
         * @throws IOException io error
         * @throws WebApplicationException app error
         */
        @Override
        public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException {
            OverrideMediaType overrideMediaTypeAnnotation = null;
            if (context.getType() != null && context.getAnnotations() != null) {
                overrideMediaTypeAnnotation = FindAnnotation.findAnnotation(context.getType(), context.getAnnotations(),
                        OverrideMediaType.class);
            }
            if (overrideMediaTypeAnnotation == null) {
                return context.proceed();
            }
            MediaType from = MediaType.valueOf(overrideMediaTypeAnnotation.from());
            MediaType to = MediaType.valueOf(overrideMediaTypeAnnotation.value());
            MediaType ref = context.getMediaType();
            if (from.isWildcardType() || from.getType().equalsIgnoreCase(ref.getType()) && (from.isWildcardSubtype() || from.getSubtype().equalsIgnoreCase(ref.getSubtype()))) {
                log.debug(String.format("Context media type '%s' is included in '%s' will be replaced.", context.getMediaType().toString(), from.toString()));
                context.setMediaType(to);
            }
            return context.proceed();
        }

    }
}
