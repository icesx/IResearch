package com.javapatterns.visitor.visitor0;

public class Client
{
    private static ObjectStructure aObjects;
    private static Visitor visitor;

    public static void main(String[] args)
    {
        aObjects = new ObjectStructure();

        aObjects.add(new NodeA());
        aObjects.add(new NodeB());

        visitor = new VisitorA();
        aObjects.action(visitor);

    }
}
