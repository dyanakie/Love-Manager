package com.lovemanager.app.models;

public class Girl {

    private String picUrl;
    private String presentation;
    private String name;

    private int level;
    private String type;

    public Girl(String picUrl, String presentation, String name, String type, int level) {

        this.picUrl = picUrl;
        this.presentation = presentation;
        this.name = name;
        this.type = type;
        this.level = level;
    }


    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
