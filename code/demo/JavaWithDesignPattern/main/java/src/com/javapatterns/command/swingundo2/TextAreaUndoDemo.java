package com.javapatterns.command.swingundo2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class TextAreaUndoDemo
{

    public static void main(String[] args)
    {
        // Create app panel
        TextAreaUndoDemoPanel panel = new TextAreaUndoDemoPanel();

        // Create a frame for app
        JFrame frame = new JFrame("TextAreaUndoDemo");

        // Add a window listener for window close events
        frame.addWindowListener(
            new WindowAdapter()
            {
                public void windowClosing(WindowEvent e) { System.exit(0); }
            });

        // Add app panel to content pane
        frame.getContentPane().add(panel);

        // Set initial frame size and make visible
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}



