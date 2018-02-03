package com.javapatterns.builder;

public class Client
{
    private Director director;

    private Builder builder = new ConcreteBuilder();

    public void requestBuild()
    {
        director = new Director(builder);
    }
}
