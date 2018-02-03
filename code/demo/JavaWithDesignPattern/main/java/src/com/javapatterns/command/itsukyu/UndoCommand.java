package com.javapatterns.command.itsukyu;

public class UndoCommand extends Command
{
    private UndoableTextArea text;

    public UndoCommand(UndoableTextArea text)
    {
        super("Undo");
        this.text = text;
    }

    public void execute()
    {
        text.undo();
    }
}
