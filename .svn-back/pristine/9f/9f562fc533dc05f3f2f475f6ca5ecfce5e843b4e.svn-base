package com.javapatterns.serializable.instantiate;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.Beans;

class ShowPickle extends Frame
{

    public ShowPickle(String serComponent)
    {

        super("Show Pickle");
        addWindowListener(new Win());
        setLayout(new FlowLayout());

        TextField text;

        try
        {
            text = (TextField)Beans.instantiate(null, serComponent);
        }
        catch (Exception e)
        {
            System.out.println(e);
            text = new TextField();
        }
        add(text);
    }

    /**
     * This method creates a frame to display the list of
     * serialized text fields. The button components are packed into the frame.
     */
    public static void main(String[] args)
    {

        Frame frame = new ShowPickle("mytextfield");
        frame.pack();
        frame.setVisible(true);
    }

    /** This "inner" class listens for the event which indicates that the window is closing. */
    private class Win extends WindowAdapter
    {
        /**
         * This method handles the event which indicates that a window
         * is closing. If encountered, then it hides the frame, frees the resources and exits.
         */
        public void windowClosing(WindowEvent evt)
        {
            Frame frame = (Frame)evt.getSource();
            frame.setVisible(false);
            frame.dispose();
            System.exit(0);
        }
    }
}
