package com.javapatterns.chainofresp.flowerpassingthread;

abstract class Player
{
    public abstract void handle();

    private Player successor;

    public Player()
    {
        successor = null;
    }

    protected void setSuccessor(Player aSuccessor)
    {
        successor = aSuccessor;
    }

    public void next()
    {
        if (successor != null)
        {
            successor.handle();
        }
        else
        {
            System.out.println("Program terminated.");
        }
    }

}

