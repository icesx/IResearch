package com.javapatterns.memento.wideandnarrow2;

public class Other
{
    public static void main(String[] args)
    {
        User user = new User();

        Narrow narrow = user.getConcreteClass();

        User.ConcreteClass wide = (User.ConcreteClass) narrow;
    }
}
