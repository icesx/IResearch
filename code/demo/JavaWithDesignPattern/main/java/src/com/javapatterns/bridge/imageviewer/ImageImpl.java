package com.javapatterns.bridge.imageviewer;

public abstract class ImageImpl
{
    public abstract void init();

    public abstract void paint();

    protected long width;
    protected long height;
    protected byte[] data;
}
