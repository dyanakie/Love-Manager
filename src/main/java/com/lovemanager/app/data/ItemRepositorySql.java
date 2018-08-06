package com.lovemanager.app.data;

import com.lovemanager.app.data.base.ItemRepository;
import com.lovemanager.app.models.Item;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositorySql implements ItemRepository {

    private SessionFactory factory;

    @Autowired
    public ItemRepositorySql(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public List<Item> getCurrentVehicle(int level) {
        return null;
    }

    @Override
    public List<Item> getCurrentAccessorie(int level) {
        return null;
    }

    @Override
    public List<Item> getCurrentOutfit(int level) {
        return null;
    }
}
