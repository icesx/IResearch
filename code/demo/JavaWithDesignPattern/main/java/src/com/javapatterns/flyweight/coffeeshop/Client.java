package com.javapatterns.flyweight.coffeeshop;

public class Client
{
    //the flavors ordered
    private static Order[] flavors = new Flavor[100];

    private static int ordersMade = 0;
    private static FlavorFactory flavorFactory;


    private static void takeOrders(String aFlavor)
    {
        flavors[ordersMade++] = flavorFactory.getOrder(aFlavor);
    }

    public static void main(String[] args)
    {
        flavorFactory = new FlavorFactory();

        takeOrders("Black Coffee");
        takeOrders("Capucino");
        takeOrders("Espresso");
        takeOrders("Espresso");
        takeOrders("Capucino");
        takeOrders("Capucino");
        takeOrders("Black Coffee");
        takeOrders("Espresso");
        takeOrders("Capucino");
        takeOrders("Black Coffee");
        takeOrders("Espresso");

        for (int i = 0; i < ordersMade; i++)
        {
            flavors[i].serve(new Table(i));
        }

        System.out.println("\nTotal teaFlavor objects made: " +
        flavorFactory.getTotalFlavorsMade());
    }
}
