package com.javapatterns.multilingual.number;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatTester
{
    public static void displayCurrency(Double amount, Locale currentLocale)
    {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(currentLocale);
        String amountOut = formatter.format(amount);

        System.out.println(amountOut + "   " + currentLocale.toString());
    }

    public static void main(String[] args)
    {
        displayCurrency(new Double(1234567.89), new Locale("en", "US"));
        displayCurrency(new Double(1234567.89), new Locale("de", "DE"));
        displayCurrency(new Double(1234567.89), new Locale("fr", "FR"));
    }
}

