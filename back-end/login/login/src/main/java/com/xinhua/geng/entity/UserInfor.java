package com.xinhua.geng.entity;

/**
 * @Author: geng
 * @Date: 2021/4/6 14:45
 */
public class UserInfor {
    private Integer uId;
    private String name;
    private String imgUrl;
    private String theSay;

    public UserInfor(Integer uId, String name, String imgUrl, String theSay) {
        this.uId = uId;
        this.name = name;
        this.imgUrl = imgUrl;
        this.theSay = theSay;
    }

    public UserInfor() {
    }

    @Override
    public String toString() {
        return "UserInfor{" +
                "uId=" + uId +
                ", name='" + name + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", theSay='" + theSay + '\'' +
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

    public String getTheSay() {
        return theSay;
    }

    public void setTheSay(String theSay) {
        this.theSay = theSay;
    }
}
