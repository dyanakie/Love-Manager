package com.lovemanager.app.data;

import com.lovemanager.app.models.Active;
import com.lovemanager.app.models.Character;
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

            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return theList;
    }

    @Override
    public List<Character> getAllCharacters() {
        List<Character> theList = new ArrayList<>();

        try(Session session = factory.openSession()){
            session.beginTransaction();

            theList = session.createQuery("from Character").list();

            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return theList;
    }

    @Override
    public void setActiveUser(int id, String name) {

        try(Session session = factory.openSession()){
            session.beginTransaction();
            Active current = getActive();

            current.setActiveUser(id);
            current.setName(name);
            session.update(current);
            session.save(current);
            session.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Active getActive() {

        Active current = new Active();

        try(Session session = factory.openSession()){
            session.beginTransaction();
            current = session.get(Active.class, 1);

            session.getTransaction().commit();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return current;
    }

    @Override
    public User checkOrCreateUser(User user) {


        return getAll().stream()
                .filter(x -> x.getUsername().equals(user.getUsername()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void createUser(User user) {

        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            System.out.println(user.getUsername() + " created Successfully");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
