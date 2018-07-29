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

    @Column(name = "knowledge")
    private int knowledge;

    @Column(name = "intelligence")
    private  int intelligence;

    @Column(name = "physique")
    private  int physique;

    @Column(name = "vehicle")
    private  String vehicle;

    @Column(name = "outfit")
    private  String outfit;

    @Column(name = "accessories")
    private  String accessories;

    public Character(){

    }

    public Character(int level, int knowledge, int intelligence, int physique, String vehicle, String outfit, String accessories) {
        this.level = level;
        this.knowledge = knowledge;
        this.intelligence = intelligence;
        this.physique = physique;
        this.vehicle = vehicle;
        this.outfit = outfit;
        this.accessories = accessories;
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

    public int getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(int knowledge) {
        this.knowledge = knowledge;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getPhysique() {
        return physique;
    }

    public void setPhysique(int physique) {
        this.physique = physique;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getOutfit() {
        return outfit;
    }

    public void setOutfit(String outfit) {
        this.outfit = outfit;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }
}
