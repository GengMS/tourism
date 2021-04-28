package com.xinhua.geng.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author: geng
 * @Date: 2021/4/21 17:28
 */
public class SelectOptions implements Serializable {
    private String departure;
    private String destination;
    private Boolean order;
    private Integer[] priceList;

    public SelectOptions(String departure, String destination, Boolean order, Integer[] priceList) {
        this.departure = departure;
        this.destination = destination;
        this.order = order;
        this.priceList = priceList;
    }

    public SelectOptions() {
    }

    @Override
    public String toString() {
        return "SelectOptions{" +
                "departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", order=" + order +
                ", priceList=" + Arrays.toString(priceList) +
                '}';
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

    public Boolean getOrder() {
        return order;
    }

    public void setOrder(Boolean order) {
        this.order = order;
    }

    public Integer[] getPriceList() {
        return priceList;
    }

    public void setPriceList(Integer[] priceList) {
        this.priceList = priceList;
    }
}
