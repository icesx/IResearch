package com.javapatterns.command.itsukyu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ItsukyuQuotation extends Panel implements ActionListener
{
    private final Command undo;
    private final Command redo;

    // Constructor
    public ItsukyuQuotation(UndoableTextArea text)
    {

        setLayout(new BorderLayout());

        // create a toolbar for buttons
        Panel toolbar = new Panel();

        // create undo and redo buttons
        // add listeners for buttons
        undo = new UndoCommand(text);
        redo = new RedoCommand(text);

        undo.addActionListener(this);

        redo.addActionListener(this);

        // add buttons to toolbar
        toolbar.add(undo);
        toolbar.add(redo);

        // add toolbar and text area to panel
        add(toolbar, "North");
        add(text, "Center");
    }

    //-----------------------------------------
    public void actionPerformed(ActionEvent e)
    {
        Command cmd = (Command)e.getSource();
        cmd.execute();
    }

}

