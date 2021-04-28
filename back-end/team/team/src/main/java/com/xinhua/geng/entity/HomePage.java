package com.xinhua.geng.entity;

/**
 * @Author: geng
 * @Date: 2021/4/27 14:55
 */
public class HomePage {
    private String title;
    private String imgUrl;
    private Integer tId;
    private  Long time;

    public HomePage(String title, String imgUrl, Integer tId, Long time) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.tId = tId;
        this.time = time;
    }

    public HomePage() {
    }

    @Override
    public String toString() {
        return "HomePage{" +
                "title='" + title + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", tId=" + tId +
                ", time=" + time +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
