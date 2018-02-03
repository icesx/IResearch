package com.javapatterns.prototype.monkeyking2;

import java.io.IOException;

public class TheGreatestSage
{
    private Monkey monkey = new Monkey();

    public void change() throws IOException, ClassNotFoundException
    {
        Monkey copyMonkey;

        copyMonkey = (Monkey)monkey.deepClone();

        System.out.println("Monkey King's birth date=" + monkey.getBirthDate());
        System.out.println("Copy monkey's birth date=" + copyMonkey.getBirthDate());

        System.out.println("Monkey King == Copy Monkey? " + (monkey == copyMonkey));
        System.out.println("Monkey King's Staff == Copy Monkey's Staff? " +
        (monkey.getStaff() == copyMonkey.getStaff()));
    }

    public static void main(String[] args)
    throws IOException, ClassNotFoundException
    {
        TheGreatestSage sage = new TheGreatestSage();

        sage.change();
    }

}
