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
            gv.println("\nGrep: 搜索 " + args[0] + " 文件 " + args[1]);
            gv.println("文件行号\t\t 下面的行里含有所搜索的字符串\n");
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

