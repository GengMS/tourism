package com.xinhua.geng.entity;

/**
 * @Author: geng
 * @Date: 2021/4/12 18:28
 */
public class Comment {
    private Integer uId;
    private String name;
    private String imgUrl;
    private String content;

    public Comment(Integer uId, String name, String imgUrl, String content) {
        this.uId = uId;
        this.name = name;
        this.imgUrl = imgUrl;
        this.content = content;
    }

    public Comment() {
    }

    @Override
    public String toString() {
        return "Comment{" +
                "uId=" + uId +
                ", name='" + name + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
