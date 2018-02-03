package com.javapatterns.facade.security;

public class Client
{
    private static Camera camera1, camera2;
    private static Light light1, light2, light3;
    private static Sensor sensor;
    private static Alarm alarm;

    public static void main(String[] args)
    {
        camera1.turnOn();
        camera2.turnOn();

        light1.turnOn();
        light2.turnOn();
        light3.turnOn();

        sensor.activate();
        alarm.activate();
    }

}

