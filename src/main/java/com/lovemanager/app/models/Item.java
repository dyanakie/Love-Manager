package com.lovemanager.app.models;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "picUrl")
    private String password;

    @Column(name = "type")
    private String type;

    @Column(name = "level")
    private int level;

    @Column(name = "bonus")
    private int bonus;

    @Column(name = "statsType")
    private String statsType;

    public Item(){

    }

    public Item(int id, String username, String password, String type, int level, int bonus, String statsType) {
        this.id = id;
        this.name = username;
        this.password = password;
        this.type = type;
        this.level = level;
        this.bonus = bonus;
        this.statsType = statsType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
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

    public String getStatsType() {
        return statsType;
    }

    public void setStatsType(String statsType) {
        this.statsType = statsType;
    }

    @Override
    public String toString() {
        return getName() + " of type " + getType() + " with bonus " + getBonus() + " to " + getStatsType();
    }
}
