package com.xinhua.geng.entity;

import java.util.List;

/**
 * @Author: geng
 * @Date: 2021/4/9 14:52
 */
public class Dong {
    private Integer dId;
    private Integer uId;
    private Integer type;
    private Integer dotCount;
    private Integer commentsCount;
    private String sight;
    private String userName;
    private String imgUrl;
    private Boolean goDot;
    private List<DongContent> content;

    public Dong(Integer dId, Integer uId, Integer type, Integer dotCount, Integer commentsCount, String sight, String userName, String imgUrl, Boolean goDot, List<DongContent> content) {
        this.dId = dId;
        this.uId = uId;
        this.type = type;
        this.dotCount = dotCount;
        this.commentsCount = commentsCount;
        this.sight = sight;
        this.userName = userName;
        this.imgUrl = imgUrl;
        this.goDot = goDot;
        this.content = content;
    }

    public Dong() {
    }

    @Override
    public String toString() {
        return "Dong{" +
                "dId=" + dId +
                ", uId=" + uId +
                ", type=" + type +
                ", dotCount=" + dotCount +
                ", commentsCount=" + commentsCount +
                ", sight='" + sight + '\'' +
                ", userName='" + userName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", goDot=" + goDot +
                ", content=" + content +
                '}';
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDotCount() {
        return dotCount;
    }

    public void setDotCount(Integer dotCount) {
        this.dotCount = dotCount;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getSight() {
        return sight;
    }

    public void setSight(String sight) {
        this.sight = sight;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Boolean getGoDot() {
        return goDot;
    }

    public void setGoDot(Boolean goDot) {
        this.goDot = goDot;
    }

    public List<DongContent> getContent() {
        return content;
    }

    public void setContent(List<DongContent> content) {
        this.content = content;
    }
}
