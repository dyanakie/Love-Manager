package com.lovemanager.app.models;

import javax.persistence.*;

@Entity
@Table(name = "girl")
public class Girl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "pic")
    private String picUrl;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    private String presentation;

    public Girl(){

    }

    public Girl(String picUrl, String presentation, String name, String type) {

        this.picUrl = picUrl;
        this.presentation = presentation;
        this.name = name;
        this.type = type;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
