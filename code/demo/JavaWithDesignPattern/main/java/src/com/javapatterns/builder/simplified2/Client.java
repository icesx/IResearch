package com.javapatterns.builder.simplified2;

public class Client
{
    private static Builder builder;

    public static void main(String[] args)
    {
        builder = new Builder();
        builder.construct();

        Product product = builder.retrieveResult();

        //continue here
    }
}
