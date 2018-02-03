package com.javapatterns.multilingual.number;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTester
{
    public static void displayNumber(Double amount, Locale currentLocale)
    {
        NumberFormat formatter = NumberFormat.getNumberInstance(currentLocale);
        String amountOut = formatter.format(amount);
        System.out.println(amountOut + "   " + currentLocale.toString());
    }

    public static void main(String[] args)
    {
        displayNumber(new Double(1234567.89), new Locale("en", "US"));
        displayNumber(new Double(1234567.89), new Locale("de", "DE"));
        displayNumber(new Double(1234567.89), new Locale("fr", "FR"));
    }
}

