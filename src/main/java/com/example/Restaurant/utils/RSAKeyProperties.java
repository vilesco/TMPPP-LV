//Class for using RSA keys generated from 'KeyGeneratorUtility' class
package com.example.Restaurant.utils;

import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
//----------------!!!-----------------
//          Singleton
//----------------!!!-----------------
@Component
public class RSAKeyProperties {
	private RSAPublicKey publicKey;
    private RSAPrivateKey privateKey;
    //create and set public and private RSA keys
    public RSAKeyProperties(){
        KeyPair pair = KeyGeneratorUtility.generateRsaKey();
        this.publicKey = (RSAPublicKey) pair.getPublic();
        this.privateKey = (RSAPrivateKey) pair.getPrivate();
    }

    public RSAPublicKey getPublicKey(){
        return this.publicKey;
    }

    public void setPublicKey(RSAPublicKey publicKey){
        this.publicKey = publicKey;
    }

    public RSAPrivateKey getPrivateKey(){
        return this.privateKey;
    }

    public void setPrivateKey(RSAPrivateKey privateKey){
        this.privateKey = privateKey;
    }

}
