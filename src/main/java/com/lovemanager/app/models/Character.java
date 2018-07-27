package com.lovemanager.app.models;

import javax.persistence.*;

@Entity
@Table(name = "character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "characterId")
    private int id;

    @Column(name = "level")
    private int level;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "characterId", nullable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Character(){

    }

    public Character(int level) {
        this.level = level;

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

}
