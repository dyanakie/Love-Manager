package com.lovemanager.app;

import com.lovemanager.app.models.Active;
import com.lovemanager.app.models.Character;
import com.lovemanager.app.models.User;
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
                .buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();


        Character thisCharacter = session.get(Character.class, 18);



        session.getTransaction().commit();

        session.close();




    }

    }

