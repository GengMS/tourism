package com.xinhua.geng.entity;

import java.util.List;

/**
 * @Author: geng
 * @Date: 2021/4/9 17:24
 */
public class DongFront{
    private Integer type;
    private Integer uId;
    private String title;
    private String sight;
    private List<String> imgList;

    public DongFront(Integer type, Integer uId, String title, String sight, List<String> imgList) {
        this.type = type;
        this.uId = uId;
        this.title = title;
        this.sight = sight;
        this.imgList = imgList;
    }

    public DongFront() {
    }

    @Override
    public String toString() {
        return "DongFront{" +
                "type=" + type +
                ", uId=" + uId +
                ", title='" + title + '\'' +
                ", sight='" + sight + '\'' +
                ", imgList=" + imgList +
                '}';
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSight() {
        return sight;
    }

    public void setSight(String sight) {
        this.sight = sight;
    }

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }
}
