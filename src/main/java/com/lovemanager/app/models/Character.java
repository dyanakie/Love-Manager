package com.lovemanager.app.models;

import javax.persistence.*;

@Entity
@Table(name = "character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "level")
    private int level;

    @Column(name = "statsId")
    private int statsId;

    /*@OneToOne
    @JoinColumn(name = "id", nullable = false)
    private User user;*/

    public Character(){

    }

    public Character(int level, int statsId) {
        this.level = level;
        this.statsId = statsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStatsId() {
        return statsId;
    }

    public void setStatsId(int statsId) {
        this.statsId = statsId;
    }
}
