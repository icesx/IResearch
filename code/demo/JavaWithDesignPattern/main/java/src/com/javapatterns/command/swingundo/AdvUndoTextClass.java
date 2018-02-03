package com.javapatterns.command.swingundo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class AdvUndoTextClass extends JFrame
implements ActionListener,
UndoableEditListener
{

    private JPanel mainSwingpanel = new JPanel(),
    textPanel = new JPanel();
    private JButton btn = new JButton("Start"),
    btn1 = new JButton("Undo"),
    exit = new JButton("Exit");
    private Dimension myDimension = null;
    private JTextArea txta = new JTextArea();
    private JScrollPane sp = new JScrollPane();
    private BorderLayout borderLayout1 = new BorderLayout();
    private UndoManager undomanager;

    public AdvUndoTextClass()
    {

        super("    Components testing   ");
        addWindowListener(
            new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    System.exit(0);
                }
            });

        try
        {
            jbInit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception
    {

        this.setBackground(Color.pink);
        this.setSize(new Dimension(500, 450));

        myDimension = new Dimension(490, 440);
        mainSwingpanel.setMaximumSize(myDimension);
        mainSwingpanel.setPreferredSize(myDimension);
        mainSwingpanel.setMinimumSize(myDimension);
        mainSwingpanel.setBackground(Color.gray);

        this.getContentPane().add(mainSwingpanel, BorderLayout.CENTER);

        myDimension = new Dimension(450, 300);
        textPanel.setMaximumSize(myDimension);
        textPanel.setPreferredSize(myDimension);
        textPanel.setMinimumSize(myDimension);
        textPanel.setBackground(Color.gray);
        textPanel.setLayout(borderLayout1);

        //attach an undo manager with the textarea
        txta.getDocument().addUndoableEditListener(this);

        textPanel.add(sp, BorderLayout.CENTER);
        sp.getViewport().add(txta, null);
        sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        mainSwingpanel.add(textPanel);

        btn.addActionListener(this);
        btn1.addActionListener(this);
        exit.addActionListener(this);
        mainSwingpanel.add(btn);
        mainSwingpanel.add(btn1);
        mainSwingpanel.add(exit);
    }

    public static void main(String[] args)
    {

        JFrame frame = new AdvUndoTextClass();
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 450);
        frame.setBackground(Color.red);
        frame.setTitle("Text Undo Testing");

    }

    //implementation of interface
    public void actionPerformed(ActionEvent evt)
    {

        String arg = evt.getActionCommand();
        if (arg.equals("Exit"))
        {
            System.exit(0);
        }
        else if (arg.equals("Start"))
        {
            //initialize the UndoManager
            System.out.println("Start Undo manager");
            undomanager = new UndoManager();
            undomanager.setLimit(1000);
            txta.requestFocus();
        }
        else if (arg.equals("Undo"))
        {
            System.out.println("Undo all changes");
            if (undomanager != null)
            {
                undomanager.end();
                undomanager.undo();
                undomanager = null;
            }
            else
            {
                Toolkit.getDefaultToolkit().beep();
            }
            txta.requestFocus();
        }

    }

    public void undoableEditHappened(UndoableEditEvent e)
    {
        if (undomanager != null)
        {
            undomanager.addEdit(e.getEdit());
            System.out.println(e.getEdit());
        }
    }
}
