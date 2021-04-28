package com.xinhua.geng.entity;

/**
 * @Author: geng
 * @Date: 2021/4/9 15:23
 */
public class DongContent {
    private String type;
    private String content;

    public DongContent(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public DongContent() {
    }

    @Override
    public String toString() {
        return "DongContent{" +
                "type='" + type + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
