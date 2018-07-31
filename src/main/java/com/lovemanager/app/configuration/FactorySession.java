package com.lovemanager.app.configuration;

import com.lovemanager.app.models.Active;
import com.lovemanager.app.models.User;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactorySession {

    @Bean
    public SessionFactory createSessionFactory(){
        System.out.println("Session Factory created.");

        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Character.class)
                .addAnnotatedClass(Active.class)
                .buildSessionFactory();
    }
}

