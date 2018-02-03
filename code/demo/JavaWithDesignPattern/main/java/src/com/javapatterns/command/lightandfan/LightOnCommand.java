package com.javapatterns.command.lightandfan;

public class LightOnCommand implements Command
{
    private Light myLight;

    public LightOnCommand(Light aLight)
    {
        myLight = aLight;
    }

    public void execute()
    {
        myLight.turnOn();
    }
}
