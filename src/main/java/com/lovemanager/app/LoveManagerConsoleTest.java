package com.lovemanager.app;

import com.lovemanager.app.models.Active;
import com.lovemanager.app.models.Character;
import com.lovemanager.app.models.Item;
import com.lovemanager.app.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

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

        System.out.println(user.getCharacter().getLevel());

        session.getTransaction().commit();

        session.close();




    }

    }

