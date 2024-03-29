package com.javapatterns.observer;

public interface Subject
{
    //correction
    void attach(Observer observer);

    //correction
    void detach(Observer observer);

    //correction
    void notifyObservers();
}
