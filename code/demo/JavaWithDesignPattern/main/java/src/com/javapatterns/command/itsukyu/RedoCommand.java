package com.javapatterns.command.itsukyu;

public class RedoCommand extends Command
{
    private UndoableTextArea text;

    public RedoCommand(UndoableTextArea text)
    {
        super("Redo");
        this.text = text;
    }

    public void execute()
    {
        text.redo();
    }
}
