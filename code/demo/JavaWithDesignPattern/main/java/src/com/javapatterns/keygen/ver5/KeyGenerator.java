package com.javapatterns.keygen.ver5;

import java.util.HashMap;

public class KeyGenerator
{

    private static HashMap kengens = new HashMap(10);
    private static final int POOL_SIZE = 20;
    private KeyInfo keyinfo = null;

    private KeyGenerator()
    {
    }

    private KeyGenerator(String keyName)
    {
        keyinfo = new KeyInfo(POOL_SIZE, keyName);
    }

    public static synchronized KeyGenerator getInstance(String keyName)
    {
        KeyGenerator keygen = null;
        if (kengens.containsKey(keyName))
        {
            keygen = (KeyGenerator)
            kengens.get(keyName);
        }
        else
        {
            keygen = new KeyGenerator(keyName);
        }
        return keygen;
    }

    public int getNextKey()
    {
        return keyinfo.getNextKey();
    }
}
