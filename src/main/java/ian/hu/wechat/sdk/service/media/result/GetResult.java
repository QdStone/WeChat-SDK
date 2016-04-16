package ian.hu.wechat.sdk.service.media.result;

import ian.hu.wechat.sdk.service.core.result.Result;
import lombok.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;

/**
 * 获取临时素材的结果
 *
 * @see #from(Response)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GetResult extends Result implements CompositeResult {
    private static final long serialVersionUID = -6703857917551318596L;
    private String fileName;
    private File file;

    @Override
    public void setFile(File f) {
        file = f;
    }

    @Override
    public void setFileName(String name) {
        fileName = name;
    }

    @Override
    public MediaType fromMediaType() {
        return MediaType.valueOf("text/plain");
    }

    @Override
    public MediaType toMediaType() {
        return MediaType.APPLICATION_JSON_TYPE;
    }

    @Override
    public void setErrorCode(Integer errorCode) {
        super.setErrorCode(errorCode);
    }

    public static GetResult from(Response response) {
        return ResultHelper.from(response, GetResult.class);
    }
}
