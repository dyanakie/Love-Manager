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
                .buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();

        /*Active active = session.get(Active.class, 1);*/

        List<Active> all = session.createQuery("from Active").list();

      //  List<User> all = session.createQuery("from User").list();
      //  List<Character> all2 = session.createQuery("from Character").list();

        session.getTransaction().commit();

        session.close();

        /*System.out.println(all.get(0).getUsername());
        System.out.println(all.get(0).getPassword());*/

       /* for (User a:
             all) {
            System.out.println(a.getUsername());
        }*/
      //  System.out.println(all2);

        System.out.println(all);


    }

    }

