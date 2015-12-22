package ian.hu.wechat.sdk.service.media.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import ian.hu.wechat.sdk.entity.media.NewsItem;
import ian.hu.wechat.sdk.service.core.result.Result;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.ArrayList;

/**
 * 获取永久素材的结果
 */
public class GetMaterialResult extends Result implements CompositeResult {
    private String fileName;
    private File file;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("down_url")
    private String downloadUrl;
    @JsonProperty("news_item")
    private ArrayList<NewsItem> newsItems;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public ArrayList<NewsItem> getNewsItems() {
        return newsItems;
    }

    public void setNewsItems(ArrayList<NewsItem> newsItems) {
        this.newsItems = newsItems;
    }

    @Override
    public Integer getErrorCode() {
        return newsItems != null || downloadUrl != null || file != null ? 0 : super.getErrorCode();
    }

    @Override
    public String toString() {
        return "GetMaterialResult{" +
                "errorCode=" + getErrorCode() +
                ", errorMessage='" + getErrorMessage() + '\'' +
                ", fileName='" + fileName + '\'' +
                ", file=" + file +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", newsItems=" + newsItems +
                '}';
    }

    public static GetMaterialResult from(Response response) {
        return ResultHelper.from(response, GetMaterialResult.class);
    }
}
