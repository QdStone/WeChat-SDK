package ian.hu.wechat.sdk.entity.media;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class MediaCount implements Serializable {
    @JsonProperty("voice_count")
    private int voice;
    @JsonProperty("image_count")
    private int image;
    @JsonProperty("video_count")
    private int video;
    @JsonProperty("news_count")
    private int news;

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getVideo() {
        return video;
    }

    public void setVideo(int video) {
        this.video = video;
    }

    public int getNews() {
        return news;
    }

    public void setNews(int news) {
        this.news = news;
    }


    @Override
    public String toString() {
        return "MediaCount{" +
                "voice=" + voice +
                ", image=" + image +
                ", video=" + video +
                ", news=" + news +
                '}';
    }
}
