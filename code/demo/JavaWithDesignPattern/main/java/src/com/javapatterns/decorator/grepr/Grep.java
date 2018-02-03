package com.javapatterns.decorator.grepr;

import java.io.DataInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Grep
{
    private static GrepReader g;
    private static GrepView gv = new GrepView();

    public static void main(String[] args)
    {

        if (args.length <= 1)
        {
            gv.println("Usage: java Grep <substring> <filenames>");
            gv.println("       <substring> no regexp");
            gv.println("       <filenames> files to be searched in");
            System.exit(1);
        }

        String line = null;
        try
        {
            gv.println("\nGrep: ���� " + args[0] + " �ļ� " + args[1]);
            gv.println("�ļ��к�\t\t ��������ﺬ�����������ַ���\n");
            g = new GrepReader(new FileReader(args[1]), args[0]);
            for ( ; ; )
            {
                line = g.readLine();
                if (line == null)
                {
                    break;
                }
                gv.println(args[1] + g.lineNo() + ":\t" + line);
            }
            g.close();
        }
        catch (IOException e)
        {
            gv.println(e.getMessage());
        }
    }
}

