package com.javapatterns.liskov.version2;

public class Square extends Rectangle
{
    private long side;

    public void setWidth(long width)
    {
        setSide(width);
    }

    public long getWidth()
    {
        return getSide();
    }

    public void setHeight(long height)
    {
        setSide(height);
    }

    public long getHeight()
    {
        return getSide();
    }

    public long getSide()
    {
        return side;
    }

    public void setSide(long side)
    {
        this.side = side;
    }
}
