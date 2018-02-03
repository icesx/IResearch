package com.javapatterns.xmlproperties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import org.xml.sax.SAXException;

public class TestXML
{
    public static void main(String[] args) throws SAXException, IOException
    {
        XMLProperties xml = new XMLProperties();

        xml.load(new File("C:/javapatterns/mybook/xmlproperties/xml2.xml"));

        Enumeration keyEnum = xml.keys();
        Enumeration valueEnum = xml.elements();

        while (keyEnum.hasMoreElements())
        {
            String key = (String)keyEnum.nextElement();
            String value = (String)valueEnum.nextElement();

            System.out.println(key + "=" + value);
        }

        OutputStream out = new FileOutputStream(new File("c:/out.xml"));

        xml.store(out, "test");

    }
}
