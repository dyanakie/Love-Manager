package com.lovemanager.app.models;

import javax.persistence.*;

@Entity
@Table(name = "active")
public class Active {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "activeId")
    private int activeUser;

    @Column(name = "name")
    private String name;

    @Column(name = "characterId")
    private int characterId;


    public Active(){

    }

    public Active(int activeUser, String name) {
        this.activeUser = activeUser;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(int activeUser) {
        this.activeUser = activeUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
