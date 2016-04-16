package ian.hu.wechat.sdk.service.media;

import com.fasterxml.jackson.databind.type.TypeFactory;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;

import javax.activation.FileTypeMap;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 素材工具类
 */
public final class MediaHelper {

    private static final String MAGIC_STRING = "fw_____";

    private MediaHelper() {
    }

    /**
     * 创建用于上传素材的数据结构
     *
     * @param file 待上传的文件
     * @param key  文件在表单里的name
     * @return 构造好的数据
     */
    public static MultipartFormDataOutput fromFile(File file, String key) {
        if (key == null) {
            key = "media";
        }
        MultipartFormDataOutput output = new MultipartFormDataOutput();
        output.addFormData(key, file, MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(file)), file.getName());
        // fuck weixin 如果没有下面这行，微信会报media data is missing
        //output.addFormData(MAGIC_STRING, StringUtils.reverse(MAGIC_STRING), MediaType.TEXT_PLAIN_TYPE);
        return output;
    }


    /**
     * 为视频素材添加描述
     *
     * @param output       使用 {@link #fromFile(File, String)} 已添加视频文件的 {@link MultipartFormDataOutput}
     * @param title        视频标题
     * @param introduction 视频简介
     * @return 已添加描述的 {@link MultipartFormDataOutput}
     */
    public static MultipartFormDataOutput addVideoDescription(MultipartFormDataOutput output, String title, String introduction) {
        Map<String, String> description = new HashMap<>();
        description.put("title", title);
        description.put("introduction", introduction);
        output.addFormData("description", description, HashMap.class, TypeFactory.defaultInstance().constructMapType(HashMap.class, String.class, String.class), MediaType.APPLICATION_JSON_TYPE);
        // unfuck weixin
        //output.getParts().remove(output.getFormData().remove(MAGIC_STRING));
        // fuck weixin 如果没有下面这行，微信会报media data is missing
        //output.addFormData(MAGIC_STRING, StringUtils.reverse(MAGIC_STRING), MediaType.TEXT_PLAIN_TYPE);
        return output;
    }

}
