package com.javapatterns.doubledispatch.points;

import java.awt.*;

public class Point
{
    private int x;
    private int y;

    public Point()
    {
    }

    public void draw(Canvas canvas)
    {
        //write you code here
    }

    public void translate(int distance)
    {
        x += distance;
        y += distance;
    }

    public void translate(int dx, int dy)
    {
        x += dx;
        y += dy;
    }
}

