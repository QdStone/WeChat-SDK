package ian.hu.wechat.sdk.service.media.result;

import ian.hu.wechat.sdk.service.core.result.Result;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;

/**
 * 获取临时素材的结果
 *
 * @see #from(Response)
 */
public class GetResult extends Result implements CompositeResult {
    private String fileName;
    private File file;

    public String getFileName() {
        return fileName;
    }

    @Override
    public MediaType fromMediaType() {
        return MediaType.valueOf("text/plain");
    }

    @Override
    public MediaType toMediaType() {
        return MediaType.APPLICATION_JSON_TYPE;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }


    @Override
    public String toString() {
        return "GetResult{" +
                "errorCode=" + getErrorCode() +
                ", errorMessage='" + getErrorMessage() + '\'' +
                ", fileName='" + fileName + '\'' +
                ", file=" + file +
                '}';
    }

    public static GetResult from(Response response) {
        return ResultHelper.from(response, GetResult.class);
    }
}
