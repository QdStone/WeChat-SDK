package ian.hu.wechat.sdk.service;

import ian.hu.wechat.sdk.debug.LoggingFilter;
import ian.hu.wechat.sdk.rest.annotation.OverrideMediaType;
import org.apache.commons.lang.reflect.FieldUtils;
import org.apache.commons.logging.Log;
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
public class ServiceHelper {

    private static final Log logger = LogFactory.getLog(ServiceHelper.class);

    public static <T extends Service> T get(Client client, String baseUrl, Class<T> clazz) {

        if (client == null) {
            client = ClientBuilder.newClient();
        }
        client.register(MediaTypeInterceptor.class);
        if (LogFactory.getLog(clazz).isDebugEnabled()) {
            client.register(LoggingFilter.class);
        }

        client.register(ian.hu.wechat.sdk.rest.MultipartFormDataWriter.class);
        if (baseUrl == null) {
            try {
                baseUrl = FieldUtils.getDeclaredField(clazz, "DEFAULT_URL").get(clazz).toString();
            } catch (IllegalAccessException e) {
                logger.warn("faild to get DEFAULT_URL and the baseUrl param is null", e);
            }
        }
        ResteasyWebTarget target = (ResteasyWebTarget) client.target(baseUrl);
        return target.proxy(clazz);
    }

    public static <T extends Service> T get(Client client, Class<T> clazz) {
        return get(client, null, clazz);
    }

    public static <T extends Service> T get(Class<T> clazz) {
        return get(null, null, clazz);
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
     *     MyJsonObj get(...);
     * }
     * </code>
     * </pre>
     *
     * @see OverrideMediaType
     */
    @Provider
    @Priority(Priorities.USER)
    public static class MediaTypeInterceptor implements ReaderInterceptor {

        @Override
        public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
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
                logger.debug(String.format("Context media type '%s' is included in '%s' will be replaced.", context.getMediaType().toString(), from.toString()));
                context.setMediaType(to);
            }
            return context.proceed();
        }

    }
}
