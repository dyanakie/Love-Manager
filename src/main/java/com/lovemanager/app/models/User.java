package com.lovemanager.app.models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStatId() {
        return statId;
    }

    public void setStatId(int statId) {
        this.statId = statId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "ID")
    int id;

    @Column( name = "UserName")
    String username;

    @Column( name = "Password")
    String password;

    @Column( name = "Level")
    int level;

    @Column( name = "StatId")
    int statId;

    @Column( name = "ItemId")
    int itemId;

    public User(){

    }


}
