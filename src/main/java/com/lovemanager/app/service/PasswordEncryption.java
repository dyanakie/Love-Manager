package com.lovemanager.app.service;

import javax.persistence.criteria.CriteriaBuilder;

public class PasswordEncryption {


    public String encryptPassword(String password){

        StringBuilder newPassword = new StringBuilder();
        int lenght = password.length();

        for(int i = password.length()-1; i >= 0; i-- ){

            newPassword.append(password.charAt(i));
            newPassword.append(i);

        }


        char a = newPassword.charAt(0);
        char b = newPassword.charAt(newPassword.length()-1);

        String newPass = newPassword.substring(1, newPassword.length()-1);

        newPass = b + newPass + a + '$' + lenght;



        // 322110

        return newPass;
    }

    public String decryptPassword(String password){



        for(int i = password.length()-1; i>=0; i--){
            if(password.charAt(i) == '$'){
                password = password.substring(0, i);
                break;
            }
        }


        char a = password.charAt(0);
        char b = password.charAt(password.length()-1);

        String newPassword = password.substring(1, password.length()-1);
        newPassword = b + newPassword + a;

        StringBuilder pass = new StringBuilder();
        int count = 2;
        int localCount = 0;


        for(int i = newPassword.length()-2; i >= 0; i=i-count){

            if(localCount >= 10){
                i = i -1;
            }

            pass.append(newPassword.charAt(i));
            localCount++;
        }


        return pass.toString();
    }


}
