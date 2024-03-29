package com.javapatterns.keygen.ver4;

import java.util.HashMap;

public class KeyGenerator
{

    private static KeyGenerator keygen = new KeyGenerator();
    private static final int POOL_SIZE = 20;
    private HashMap keyList = new HashMap(10);

    private KeyGenerator()
    {
    }

    public static KeyGenerator getInstance()
    {
        return keygen;
    }

    public int getNextKey(String keyName)
    {
        KeyInfo keyinfo = null;

        if (keyList.containsKey(keyName))
        {
            keyinfo = (KeyInfo)keyList.get(keyName);
            System.out.println("key found");
        }
        else
        {
            keyinfo = new KeyInfo(POOL_SIZE, keyName);
            keyList.put(keyName, keyinfo);

            System.out.println("new key created");
        }
        return keyinfo.getNextKey();
    }
}
