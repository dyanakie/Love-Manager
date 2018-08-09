package com.lovemanager.app.services;

import com.lovemanager.app.service.PasswordEncryption;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PasswordEncryptionTests1 {

    @InjectMocks
    PasswordEncryption passwordEncryption;

    @Test
    public void Test_Encrypted_Message_Same_As_Decrypted(){

        String test = passwordEncryption.encryptPassword("PAROLA RIBA MECH");

        Assert.assertEquals(passwordEncryption.decryptPassword(test), "PAROLA RIBA MECH");

    }

    @Test
    public void Test_Encryption_Equals_Certain_String(){

        String test = passwordEncryption.encryptPassword("123");

        Assert.assertEquals(test, "022113$3");

    }



}
