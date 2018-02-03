package com.javapatterns.visitor.visitoradapter;

public abstract class Node
{
    public abstract void accept(Visitor visitor);
}
