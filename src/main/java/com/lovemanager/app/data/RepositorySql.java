package com.lovemanager.app.data;

import com.lovemanager.app.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class RepositorySql implements Repository {

    private SessionFactory factory;

    @Autowired
    public RepositorySql(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public List<User> getAll() {
        List<User> theList = new ArrayList<>();

        try(Session session = factory.openSession()){
            session.beginTransaction();

            theList = session.createQuery("from User").list();
            System.out.println("asdadas");
           // session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return theList;
    }
}
