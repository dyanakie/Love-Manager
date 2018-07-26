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


}
