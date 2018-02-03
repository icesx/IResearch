package com.javapatterns.command.book;

public class Client
{
    private static Invoker pasteinvoker;
    private static Invoker openinvoker;
    private static Invoker macroinvoker;

    public static void main(String args[])
    {
        //(1) PasteCommand
        PasteCommand pasteDoc = new PasteCommand();
        pasteinvoker = new Invoker(pasteDoc);
        System.out.println("Testing PasteCommand: \n");
        pasteinvoker.invoke();

        //(2) OpenCommand
        OpenCommand openDoc = new OpenCommand();
        openinvoker = new Invoker(openDoc);
        System.out.println("Testing OpenCommand: \n");
        openinvoker.invoke();

        //(3) MacroCommand
        MacroDocCommand macCom = new MacroDocCommand();
        macroinvoker = new Invoker(macCom);
        System.out.print("Adding 3 PasteCommand and 3 OpenCommand into ");
        System.out.println("MacroCommand!!! \n");
        macCom.add(pasteDoc);
        macCom.add(pasteDoc);
        macCom.add(pasteDoc);
        macCom.add(openDoc);
        macCom.add(openDoc);
        macCom.add(openDoc);
        System.out.println("Testing MacroCommand: \n");
        macroinvoker.invoke();

        System.out.print("Removing 1 of the PasteCommand and 1 of the OpenCommand ");
        System.out.println("from MacroCommand!!! \n");
        macCom.remove(pasteDoc);
        macCom.remove(openDoc);
        System.out.println("Testing MacroCommand: \n");
        macroinvoker.invoke();
    }

}
