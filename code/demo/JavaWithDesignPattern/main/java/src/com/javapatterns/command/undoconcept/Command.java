package com.javapatterns.command.undoconcept;

public interface Command
{
    void execute();

    void unexecute();

    void reexecute();
}
