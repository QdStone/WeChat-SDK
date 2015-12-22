package ian.hu.wechat.sdk.service.media.result;


import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.Serializable;

public interface CompositeResult extends Serializable {
    MediaType fromMediaType();

    MediaType toMediaType();

    void setErrorCode(Integer errorCode);

    void setErrorMessage(String errorMessage);

    void setFileName(String fileName);

    void setFile(File file);
}
