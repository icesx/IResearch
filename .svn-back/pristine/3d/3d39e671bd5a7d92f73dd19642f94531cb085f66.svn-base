package com.javapatterns.adapter.iterenum;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Enuterator implements Iterator
{
    //correction
    private Enumeration _enum;

    public Enuterator(Enumeration _enum)
    {
        this._enum = _enum;
    }

    public boolean hasNext()
    {
        return _enum.hasMoreElements();
    }

    public Object next() throws NoSuchElementException
    {
        return _enum.nextElement();
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

}
