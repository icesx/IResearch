package com.javapatterns.command.book;

public interface MacroCommand extends Command
{
    void execute();

    void remove(Command toRemove);

    void add(Command toAdd);
}
