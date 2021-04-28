package com.xinhua.geng.entity;

import java.util.ArrayList;

/**
 * @Author: geng
 * @Date: 2021/4/19 18:39
 */
public class TeamInforFront {
    private Integer tId;
    private String introduce;
    private ArrayList<String> fileList;
    private Integer price;
    private String departure;
    private String destination;
    private ArrayList<String> buZhou;
    private String provider;

    public TeamInforFront(Integer tId, String introduce, ArrayList<String> fileList, Integer price, String departure, String destination, ArrayList<String> buZhou, String provider) {
        this.tId = tId;
        this.introduce = introduce;
        this.fileList = fileList;
        this.price = price;
        this.departure = departure;
        this.destination = destination;
        this.buZhou = buZhou;
        this.provider = provider;
    }

    public TeamInforFront() {
    }

    @Override
    public String toString() {
        return "TeamInforFront{" +
                "tId=" + tId +
                ", introduce='" + introduce + '\'' +
                ", fileList=" + fileList +
                ", price=" + price +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", buZhou=" + buZhou +
                ", provider='" + provider + '\'' +
                '}';
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public ArrayList<String> getFileList() {
        return fileList;
    }

    public void setFileList(ArrayList<String> fileList) {
        this.fileList = fileList;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public ArrayList<String> getBuZhou() {
        return buZhou;
    }

    public void setBuZhou(ArrayList<String> buZhou) {
        this.buZhou = buZhou;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
