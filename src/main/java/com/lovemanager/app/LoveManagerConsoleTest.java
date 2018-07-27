package com.lovemanager.app;

import com.lovemanager.app.data.RepositorySql;
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
                .buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();

        List<User> all = session.createQuery("from User").list();
        List<User> all2 = session.createQuery("from Character").list();

        session.getTransaction().commit();

        session.close();

        System.out.println(all.get(0).getUsername());
        System.out.println(all.get(0).getPassword());

        System.out.println(all2);

    }

    }

