package com.lovemanager.app.data;

import com.lovemanager.app.data.base.CharacterRepository;
import com.lovemanager.app.data.base.UserRepository;
import com.lovemanager.app.models.Active;
import com.lovemanager.app.models.Character;
import com.lovemanager.app.models.Girl;
import com.lovemanager.app.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepositorySql implements CharacterRepository {

    private SessionFactory factory;

    @Autowired
    public CharacterRepositorySql(SessionFactory factory){
        this.factory = factory;
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
    public void createCharacter(User user){

        Character newCharacter = new Character();
        newCharacter.setUserId(user.getId());

        List<Character> allCharacters = getAllCharacters();

        if(allCharacters.stream()
                .filter(x -> x.getUserId() == user.getId())
                .findFirst()
                .orElse(null) != null){
            System.out.println("Character found");
            return;
        }

        try(Session session = factory.openSession()) {
            session.beginTransaction();
            newCharacter.setLevel(1);
            newCharacter.setUser(user);
            session.save(newCharacter);
            session.getTransaction().commit();
            System.out.println(newCharacter.getUserId() + " character id created succesfully");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void saveCharacterIdForUser(User user) {

        try(Session session = factory.openSession()) {
            session.beginTransaction();
            Character character = getAllCharacters().stream()
                    .filter( x -> x.getUserId() == user.getId())
                    .findFirst()
                    .orElse(null);

            user.setCharacterId(character.getId());

            session.update(user);

            Active active = session.get(Active.class, 1);
            active.setCharacterId(character.getId());

            session.update(active);
            session.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Character getCharacterById(int id) {

        System.out.println("ID: " + id);

        Character newCharacter = new Character();

        try(Session session = factory.openSession()) {
            session.beginTransaction();

            newCharacter = getAllCharacters().stream()
                    .filter(x -> x.getId() == id)
                    .findFirst()
                    .orElse(null);

            session.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return newCharacter;
    }

    @Override
    public void saveGirl(Girl girl) {

        try(Session session = factory.openSession()) {
            session.beginTransaction();

            Girl current = getActiveGirl();
            current.setPresentation(girl.getPresentation());
            current.setId(1);
            current.setName(girl.getName());
            current.setType(girl.getType());
            current.setPicUrl(girl.getPicUrl());
            current.setLevel(girl.getLevel());
            session.update(current);

            session.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(girl.getName() + " updated as an active girl.");

    }

    @Override
    public Girl getActiveGirl(){

        Girl current = new Girl();

        try(Session session = factory.openSession()) {
            session.beginTransaction();

            current = session.get(Girl.class, 1);

            session.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return current;

    }

    @Override
    public void levelUp(int characterId){


        try(Session session = factory.openSession()) {
            session.beginTransaction();

            Character character = session.get(Character.class,characterId);

            character.setLevel(character.getLevel()+1);
            session.update(character);

            session.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void deleteActiveCharacter(int characterId) {

        try(Session session = factory.openSession()) {
            session.beginTransaction();

            Character character = session.get(Character.class,characterId);

            session.delete(character);

            session.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void changeIntelligence(int characterId, int amount) {

        try(Session session = factory.openSession()) {
            session.beginTransaction();

            Character character = session.get(Character.class,characterId);

            character.setIntelligence(character.getIntelligence()+amount);
            session.update(character);

            session.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void changeStatus(int characterId, int amount) {

        try(Session session = factory.openSession()) {
            session.beginTransaction();

            Character character = session.get(Character.class,characterId);

            character.setStatus(character.getStatus()+amount);
            session.update(character);

            session.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void changePhysique(int characterId, int amount) {

        try(Session session = factory.openSession()) {
            session.beginTransaction();

            Character character = session.get(Character.class,characterId);

            character.setPhysique(character.getPhysique()+amount);
            session.update(character);

            session.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
