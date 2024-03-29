package com.javapatterns.xmlproperties;

import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import org.xml.sax.SAXException;

/**
 * The <code>Properties</code> class represents a persistent set of
 * properties. The <code>Properties</code> can be saved to a stream or
 * loaded from a stream. Each key and its corresponding value in the property list is a string. <p>
 * A property list can contain another property list as its "defaults"; this
 * second property list is searched if the property key is not found in the
 * original property list. Because Properties inherits from Hashtable, the
 * put and putAll methods can be applied to a Properties object. Their use
 * is strongly discouraged as they allow the caller to insert entries whose
 * keys or values are not Strings. The setProperty method should be used
 * instead. If the store or save method is called on a "compromised"
 * Properties object that contains a non-String key or value, the call will fail. <p>
 * This is a special implementation for XML : <pre>
 *   &lt;properties>
 *      &lt;key name="My_key1">My_Value1&lt;/key>
 *      &lt;key name="My_key2">My_Value2&lt;/key>
 *   &lt;/properties>
 * </pre>
 */
public class XMLProperties extends Properties
{
    private XMLParser p = null;

    /**
     * Reads a property list from an input stream.
     * @param      in   the input stream.
     * @exception  IOException  if an error occurred when reading from the input stream.
     */
    public synchronized void load(InputStream in) throws IOException
    {
        try
        {
            p = new XMLParser(in, this);
        }
        catch (SAXException e)
        {
            throw new IOException(e.getMessage());
        }
    }

    /** Reads a property list from an input stream. */
    public synchronized void load(File file) throws SAXException, IOException
    {
        //        System.out.println("File: " + file);
        //        System.out.println("File exists " + file.exists());

        InputStream in = new BufferedInputStream(new FileInputStream(file));
        //correction
        p = null;
        try
        {
            p = new XMLParser(in, this);
        }
        catch (SAXException e)
        {
            System.out.println(e);
            throw e;
        }
    }

    /** Calls the <code>store(OutputStream out, String header)</code> method and suppresses IOExceptions that were thrown. */
    public synchronized void save(OutputStream out, String header)
    {
        try
        {
            store(out, header);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * Writes this property list (key and element pairs) in this
     * <code>Properties</code> table to the output stream in a format suitable
     * for loading into a <code>Properties</code> table using the <code>load</code> method.
     */
    public synchronized void store(OutputStream out, String header)
    throws IOException
    {
        PrintWriter wout = new PrintWriter(out);
        wout.println("<?xml version='1.0'?>");
        if (header != null)
        {
            wout.println("<!--" + header + "-->");
        }

        wout.print("<properties>");
        for (Enumeration e = keys(); e.hasMoreElements(); )
        {
            String key = (String)e.nextElement();
            String val = (String)get(key);
            wout.print("\n <key name=\"" + key + "\">");
            wout.print(encode(val));
            wout.print("</key>");
        }
        wout.print("\n</properties>");
        wout.flush();
    }

    protected StringBuffer encode(String string)
    {
        int len = string.length();
        StringBuffer buffer = new StringBuffer(len);
        char c = ' ';

        for (int i = 0; i < len; i++)
        {
            switch (c = string.charAt(i))
            {
                case '&':
                    buffer.append("&amp;");
                    break;
                case '<':
                    buffer.append("&lt;");
                    break;
                case '>':
                    buffer.append("&gt;");
                    break;
                default:
                    buffer.append(c);
            }
        }

        return buffer;
    }

    /** Creates an empty property list with no default values. */
    public XMLProperties()
    {
        super();
    }

    /** Creates an empty property list with the specified defaults. */
    public XMLProperties(Properties defaults)
    {
        super(defaults);
    }
}
