package com.lovemanager.app.data;

import com.lovemanager.app.data.base.GirlsRepository;
import com.lovemanager.app.models.Girl;
import com.lovemanager.app.models.Character;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GirlsRepositorySql implements GirlsRepository {

    private SessionFactory factory;

    @Autowired
    public GirlsRepositorySql(SessionFactory factory){
        this.factory = factory;
    }


    @Override
    public String getUsedGirls(int characterId) {

        String usedGirls = "";

        try(Session session = factory.openSession()) {
            session.beginTransaction();

            Character character = session.get(Character.class, characterId);

            if(character.getUsedGirls() != null){
                usedGirls = character.getUsedGirls();
            }

            session.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return usedGirls;
    }

    @Override
    public void addUsedGirl(int characterId, String name) {

        String usedGirls = "";

        try(Session session = factory.openSession()) {
            session.beginTransaction();

            Character character = session.get(Character.class, characterId);

            usedGirls = character.getUsedGirls();

            character.setUsedGirls(usedGirls + " " + name);

            session.update(character);

            session.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
