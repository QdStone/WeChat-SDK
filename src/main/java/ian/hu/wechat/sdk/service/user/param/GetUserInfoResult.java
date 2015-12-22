package ian.hu.wechat.sdk.service.user.param;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import ian.hu.wechat.sdk.entity.user.UserInfo;
import ian.hu.wechat.sdk.service.core.result.Result;

/**
 * 获取用户信息结果
 */
public class GetUserInfoResult extends Result {
    @JsonUnwrapped
    private UserInfo info;

    public UserInfo getInfo() {
        return info;
    }

    public void setInfo(UserInfo info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "GetUserInfoResult{" +
                "errorCode=" + getErrorCode() +
                ", errorMessage='" + getErrorMessage() + '\'' +
                ", info=" + info +
                '}';
    }

    @Override
    public Integer getErrorCode() {
        return info != null && info.getSubscribe() != null ? 0 : super.getErrorCode();
    }
}
