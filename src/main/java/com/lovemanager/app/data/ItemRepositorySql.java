package com.lovemanager.app.data;

import com.lovemanager.app.data.base.ItemRepository;
import com.lovemanager.app.models.Active;
import com.lovemanager.app.models.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepositorySql implements ItemRepository {

    private SessionFactory factory;

    @Autowired
    public ItemRepositorySql(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public List<Item> getAllItems() {

        List<Item> theList = new ArrayList<>();

        try(Session session = factory.openSession()){
            session.beginTransaction();

            theList = session.createQuery("from Item").list();

            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return theList;
    }

    @Override
    public int getCurrentVehicle(int characterId) {


        return 0;
    }

    @Override
    public int getCurrentOutfit(int characterId) {
        return 0;
    }

    @Override
    public int getCurrentAccessorie(int characterId) {
        return 0;
    }

    @Override
    public void setCurrentVehicle(int id) {

    }

    @Override
    public void setCurrentOutfit(int id) {

    }

    @Override
    public void setCurrentAccessorie(int id) {

    }

}
