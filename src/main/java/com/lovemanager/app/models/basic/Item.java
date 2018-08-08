package com.lovemanager.app.models.basic;

import javax.persistence.*;

public class Item {


    private String name;
    private String type;
    private int level;
    private int bonus;
    private String statsType;
    private String picUrl;

    public Item(){

    }

    public Item(String name, String type, int level, int bonus, String statsType, String picUrl) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.bonus = bonus;
        this.statsType = statsType;
        this.picUrl = picUrl;
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public String toString() {
        return getName() + " of type " + getType() + " with bonus " + getBonus() + " to " + getStatsType();
    }
}
