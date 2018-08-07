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

    @Column(name = "status")
    private int status;

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

    @Column(name = "usedGirls")
    private String usedGirls;

    @OneToOne(mappedBy = "character")
    private User user;

    public Character(){

    }

    public Character(int level, int status, int intelligence, int physique, int itemsOwnedId, String vehicle, String outfit, String accessories, User user) {
        this.level = level;
        this.status = status;
        this.intelligence = intelligence;
        this.physique = physique;
        this.vehicle = vehicle;
        this.outfit = outfit;
        this.accessories = accessories;
        this.itemsOwnedId = itemsOwnedId;
        this.user = user;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getUsedGirls() {
        return usedGirls;
    }

    public void setUsedGirls(String usedGirls) {
        this.usedGirls = usedGirls;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle(){

        switch (getLevel()){

            case 1: return  "Grand Loser";
            case 2: return  "Loser";
            case 3: return  "Awkard Playboy";
            case 4: return  "Novice Playboy";
            case 5: return  "Decent Playboy";
            case 6: return  "Slick Player";
            case 7: return  "Grandmaster of the Game";

        }

        return "error";

    }

    public int getStatLevelByType(String type){                     //return the specific stat when compared of that of the girl

        switch (type){

            case "intelligence": return this.getIntelligence();
            case "physique": return this.getPhysique();
            case "status": return this.getStatus();

            default: return this.getLevel();

        }

    }

}
