package com.javapatterns.visitor.visitorsimplified;

public abstract class Node
{
    public abstract void accept(Visitor visitor);
}
