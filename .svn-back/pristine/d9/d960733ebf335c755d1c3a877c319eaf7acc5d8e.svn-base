package com.javapatterns.serializable.instantiate;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class PickleMaker extends Frame
{

    public PickleMaker(String text, int size)
    {

      /*
       * Invoke the super class constructor, add an event listener
       * for the "close" event and change the layout to "Flow".
       */

        super("Pickle Maker");
        addWindowListener(new Win());
        setLayout(new FlowLayout());

      /*
       * Make the text field and serialize it.
       */

        TextField textField = makeTextField(text, size);
        serializeTextField(textField, "mytextfield.ser");
        add(textField);
    }


    /** This method constructs a text field and changes its attributes based on the parameters specified. */
    private TextField makeTextField(String text, int size)
    {
        TextField textField = new TextField(text, size);
        return textField;
    }

    /** This method writes a serialized version of the text field to the file name specified. */
    private void serializeTextField(TextField textField, String filename)
    {
        try
        {
            FileOutputStream outStream = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(outStream);
            out.writeObject(textField);
            out.flush();
            out.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }


    /** This method creates the frame which will construct and show the text field. */
    public static void main(String[] args)
    {
        Frame frame = new PickleMaker("No matter where you go, &this.", 25);
        frame.setBounds(0, 0, 300, 200);
        frame.setVisible(true);
    }

    /** This "inner" class listens for the event which indicates that the window is closing. */
    private class Win extends WindowAdapter
    {

        /**
         * This method handles the event which indicates that a window
         * is closing. If encountered, then it hides the frame, fees the resources and exits.
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
