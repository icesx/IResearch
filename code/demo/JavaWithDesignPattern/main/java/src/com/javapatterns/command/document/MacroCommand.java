package com.javapatterns.command.document;

public interface MacroCommand extends Command
{
    void execute();

    void remove(Command toRemove);

    void add(Command toAdd);
}
