package com.xinhua.geng.entity;

/**
 * @Author: geng
 * @Date: 2021/5/31 10:04
 */
public class Notice {
    private String addres;
    private Boolean allSelect;
    private String theme;
    private String content;

    public Notice() {
    }

    public Notice(String addres, Boolean allSelect, String theme, String content) {
        this.addres = addres;
        this.allSelect = allSelect;
        this.theme = theme;
        this.content = content;
    }

    @Override
    public String toString() {
        return "EmailContent{" +
                "addres='" + addres + '\'' +
                ", allSelect=" + allSelect +
                ", theme='" + theme + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public Boolean getAllSelect() {
        return allSelect;
    }

    public void setAllSelect(Boolean allSelect) {
        this.allSelect = allSelect;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
