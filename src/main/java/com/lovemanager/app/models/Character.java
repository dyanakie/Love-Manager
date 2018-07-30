package com.lovemanager.app.models;

import javax.persistence.*;

@Entity
@Table(name = "\"character\"")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "characterId")
    private int id;

    @Column(name = "level")
    private int level;

    @Column(name = "userId")      // temporarily before mapping issue fixed
    private int userId;

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

    @Column(name = "itemsOwnedId")
    private int itemsOwnedId;


   /* @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "characterId", nullable = false)
    private Active active;*/

    public Character(){

    }

    public Character(int level, int knowledge, int intelligence, int physique, int itemsOwnedId, String vehicle, String outfit, String accessories) {
        this.level = level;
        this.knowledge = knowledge;
        this.intelligence = intelligence;
        this.physique = physique;
        this.vehicle = vehicle;
        this.outfit = outfit;
        this.accessories = accessories;
        this.itemsOwnedId = itemsOwnedId;
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

    public int getItemsOwnedId() {
        return itemsOwnedId;
    }

    public void setItemsOwnedId(int itemsOwnedId) {
        this.itemsOwnedId = itemsOwnedId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
