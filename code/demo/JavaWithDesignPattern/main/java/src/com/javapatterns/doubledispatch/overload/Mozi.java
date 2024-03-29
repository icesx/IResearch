package com.javapatterns.doubledispatch.overload;

public class Mozi
{
    private static Horse aHorse;

    public void ride(Horse horse)
    {
        System.out.println("Riding a horse");
    }

    public void ride(WhiteHorse wh)
    {
        System.out.println("Riding a white horse");
    }

    public void ride(BlackHorse bh)
    {
        System.out.println("Riding a black horse");
    }

    public static void main(String[] args)
    {
        Horse wh = new WhiteHorse();

        Horse bh = new BlackHorse();

        Mozi mozi = new Mozi();

        mozi.ride(wh);
        mozi.ride(bh);
    }

}
