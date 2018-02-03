package com.javapatterns.facade.securityfacade;

public class SecurityFacade
{
    private Camera camera1, camera2;
    private Light light1, light2, light3;
    private Sensor sensor;
    private Alarm alarm;

    public void activate()
    {
        camera1.turnOn();
        camera2.turnOn();

        light1.turnOn();
        light2.turnOn();
        light3.turnOn();

        sensor.activate();
        alarm.activate();
    }

    public void deactivate()
    {
        camera1.turnOff();
        camera2.turnOff();

        light1.turnOff();
        light2.turnOff();
        light3.turnOff();

        sensor.deactivate();
        alarm.deactivate();
    }

}

