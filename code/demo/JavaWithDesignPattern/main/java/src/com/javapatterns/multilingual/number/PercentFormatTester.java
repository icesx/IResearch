package com.javapatterns.multilingual.number;

import java.text.NumberFormat;
import java.util.Locale;

public class PercentFormatTester
{
    public static void displayPercent(Double amount, Locale currentLocale)
    {
        NumberFormat formatter = NumberFormat.getPercentInstance(currentLocale);
        String amountOut = formatter.format(amount);
        System.out.println(amountOut + "   " + currentLocale.toString());
    }

    public static void main(String[] args)
    {
        displayPercent(new Double(4567.89), new Locale("en", "US"));
        displayPercent(new Double(4567.89), new Locale("de", "DE"));
        displayPercent(new Double(4567.89), new Locale("fr", "FR"));
    }
}

