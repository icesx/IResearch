package com.javapatterns.composite.containers;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Professional extends Applet
{
    private TextField txtMessage = new TextField("Bad people", 35);

    public void init()
    {
        Panel center = new Panel();
        MyPanel myPanel = new MyPanel(center);

        myPanel.addButton("Politician", "Take money from the rich, votes from the poor.");
        myPanel.addButton("Programmer", "Sell bugs, charge for fixes.");

        center.add(new Label("Important Message:"));
        center.add(txtMessage);

        setLayout(new BorderLayout());
        add(myPanel);
    }

    public class MyEventHandler implements ActionListener
    {
        private String message = null;

        public MyEventHandler(String message)
        {
            this.message = message;
        }

        public void actionPerformed(ActionEvent event)
        {
            txtMessage.setText(message);
        }
    };


    public class MyPanel extends Panel
    {
        private Panel buttonPanel = new Panel();

        public MyPanel(Panel centerPanel)
        {
            setLayout(new BorderLayout());
            add(centerPanel, "Center");
            add(buttonPanel, "South");
        }

        public void addButton(String label, String message)
        {
            Button btnNewButton = new Button(label);
            buttonPanel.add(btnNewButton);
            btnNewButton.addActionListener(new MyEventHandler(message));
        }
    };
}
