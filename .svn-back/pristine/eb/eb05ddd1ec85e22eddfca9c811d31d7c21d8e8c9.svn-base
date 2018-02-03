package com.javapatterns.decorator.greps;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

// This class demonstrates the use of the GrepInputStream class.
// It prints the lines of a file that contain a specified substring.
public class Grep
{
    public static void main(String[] args)
    {
        if ((args.length == 0) || (args.length > 2))
        {
            System.out.println("Usage: java Grep <substring> [<filename>]");
            System.exit(0);
        }

        try
        {
            DataInputStream dis = null;
            if (args.length == 2)
            {
                dis = new DataInputStream(new FileInputStream(args[1]));
            }
            else
            {
                dis = new DataInputStream(System.in);
            }
            GrepInputStream gis = new GrepInputStream(dis, args[0]);

            String line = null;
            while (true)
            {
                line = gis.readLine();
                if (line == null)
                {
                    break;
                }
                System.out.println(line);
            }
            gis.close();
        }
        catch (IOException e) { System.err.println(e); }
    }
}


