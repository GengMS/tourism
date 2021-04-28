package com.xinhua.geng.entity;

/**
 * @Author: geng
 * @Date: 2021/4/5 8:48
 */
public class User {
    private Integer uId;
    private String email;
    private String passwd;
    private Integer identity;
    private Integer infor;

    public User(Integer uId, String email, String passwd, Integer identity, Integer infor) {
        this.uId = uId;
        this.email = email;
        this.passwd = passwd;
        this.identity = identity;
        this.infor = infor;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", identity=" + identity +
                ", infor=" + infor +
                '}';
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getInfor() {
        return infor;
    }

    public void setInfor(Integer infor) {
        this.infor = infor;
    }
}
