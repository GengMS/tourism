package com.xinhua.geng.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import sun.rmi.runtime.Log;

/**
 * @Author: geng
 * @Date: 2021/4/26 11:45
 */
public class PhoneNum {
    @ExcelProperty("电话号")
    private Long phoneNum;
    @ExcelProperty("注入日期")
    private String date;

    public PhoneNum(Long phoneNum, String date) {
        this.phoneNum = phoneNum;
        this.date = date;
    }

    public PhoneNum() {
    }

    @Override
    public String toString() {
        return "PhoneNum{" +
                "phoneNum=" + phoneNum +
                ", date='" + date + '\'' +
                '}';
    }

    public Long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
