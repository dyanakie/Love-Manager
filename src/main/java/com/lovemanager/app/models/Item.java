package com.lovemanager.app.models;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String username;

    @Column(name = "picUrl")
    private String password;

    @Column(name = "type")
    private String type;

    @Column(name = "level")
    private int level;

    @Column(name = "bonus")
    private int bonus;

    public Item(){

    }

    public Item(int id, String username, String password, String type, int level, int bonus) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
        this.level = level;
        this.bonus = bonus;
    }

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

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
