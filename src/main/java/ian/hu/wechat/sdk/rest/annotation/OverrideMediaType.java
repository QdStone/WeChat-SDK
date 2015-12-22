package ian.hu.wechat.sdk.rest.annotation;

import java.lang.annotation.*;

/**
 * 强制重写Response的MediaType，由{@link ian.hu.wechat.sdk.service.ServiceHelper.MediaTypeInterceptor}完成重写
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OverrideMediaType {
    /**
     * 重写后的MediaType
     */
    String value();

    /**
     * 只重写哪些MediaType
     */
    String from() default "*/*";
}
