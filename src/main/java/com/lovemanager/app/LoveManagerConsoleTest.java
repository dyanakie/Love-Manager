package com.lovemanager.app;

import com.lovemanager.app.models.Active;
import com.lovemanager.app.models.Character;
import com.lovemanager.app.models.basic.Item;
import com.lovemanager.app.models.User;
import com.lovemanager.app.service.PasswordEncryption;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoveManagerConsoleTest {

    public static void main(String[] args){


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Character.class)
                .addAnnotatedClass(Active.class)
                .addAnnotatedClass(Item.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();


       // Character thisCharacter = session.get(Character.class, 18);

      //  List<Item> allItems = session.createQuery("from Item").list();

        User user = session.get(User.class, 5);

      //  System.out.println(user.getCharacter().getLevel());


        session.getTransaction().commit();

        session.close();


        PasswordEncryption encryption = new PasswordEncryption();

        System.out.println(encryption.encryptPassword("Oy manqna 123 PRAZ LUK"));

        System.out.println();

        System.out.println(encryption.decryptPassword("021U20L19 18Z17A16R15P14 13312211110 9a8n7q6n5a4m3 2y1OK$22"));


    }

    }

