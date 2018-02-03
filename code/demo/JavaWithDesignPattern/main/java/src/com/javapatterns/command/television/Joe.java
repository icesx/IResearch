package com.javapatterns.command.television;

public class Joe
{
    private static Control control;

    public static void main(String[] args)
    {
        test1();
    }

    private static void test1()
    {
        Tv myTv = new Tv();

        OnCommand on = new OnCommand(myTv);
        OffCommand off = new OffCommand(myTv);
        ChannelCommand channel = new ChannelCommand(myTv, 2);

        control = new Control(on, off, channel);

        control.turnOn();
        control.changeChannel();

        control.turnOff();
    }
}



