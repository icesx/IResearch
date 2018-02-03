package com.javapatterns.singleton.mxrecord;

public class Client
{
    private static MXList mxl;

    public static void main(String[] args)
    throws Exception
    {
        mxl = MXList.getInstance("dns://dns.jeffcorp.com", "jeffcorp.com");

        for (int i = 0; i < mxl.size(); i++)
        {
            System.out.println(
            (1 + i)
            + ") priority = "
            + ((MailServer)
            mxl.elementAt(i)).getPriority()
            + ", Name = "
            + ((MailServer)
            mxl.elementAt(i)).getServer());
        }
    }
}
