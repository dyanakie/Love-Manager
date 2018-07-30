package com.lovemanager.app;

import com.lovemanager.app.data.RepositorySql;
import com.lovemanager.app.models.Active;
import com.lovemanager.app.models.Character;
import com.lovemanager.app.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

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


     //   User user = session.get(User.class, 15);

        session.getTransaction().commit();

        session.close();

       // System.out.println(newChar.getUserId());


    }

    }

