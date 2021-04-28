package com.xinhua.geng.entity;

/**
 * @Author: geng
 * @Date: 2021/4/19 14:24
 */
public class TeamInfor {
    private Integer tId;
    private String introduce;
    private Integer price;
    private String departure;
    private String destination;
    private String provider;

    public TeamInfor(Integer tId, String introduce, Integer price, String departure, String destination, String provider) {
        this.tId = tId;
        this.introduce = introduce;
        this.price = price;
        this.departure = departure;
        this.destination = destination;
        this.provider = provider;
    }

    public TeamInfor() {
    }

    @Override
    public String toString() {
        return "TeamInfor{" +
                "tId=" + tId +
                ", introduce='" + introduce + '\'' +
                ", price=" + price +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
