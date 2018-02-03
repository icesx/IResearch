package com.javapatterns.decorator.grepr;

import java.io.PrintStream;

public class GrepView
{
    private PrintStream out;

    public GrepView()
    {
        out = System.out;
    }

    public void println(String line)
    {
        out.println(line);
    }
}
