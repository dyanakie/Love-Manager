package com.lovemanager.app.models;

import javax.persistence.*;

@Entity
@Table(name = "LoveManager")
public class User {


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


}
