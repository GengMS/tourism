package com.xinhua.domain;


import java.util.Date;

public class Img {
    private Integer i_id;
    private String img_url;
    private String dateime;
    private Integer u_id;

    public Img(Integer i_id, String img_url, String dateime, Integer u_id) {
        this.i_id = i_id;
        this.img_url = img_url;
        this.dateime = dateime;
        this.u_id = u_id;
    }

    public Img() {
    }

    @Override
    public String toString() {
        return "Img{" +
                "i_id=" + i_id +
                ", img_url='" + img_url + '\'' +
                ", dateime='" + dateime + '\'' +
                ", u_id=" + u_id +
                '}';
    }

    public Integer getI_id() {
        return i_id;
    }

    public void setI_id(Integer i_id) {
        this.i_id = i_id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getDateime() {
        return dateime;
    }

    public void setDateime(String dateime) {
        this.dateime = dateime;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }
}
