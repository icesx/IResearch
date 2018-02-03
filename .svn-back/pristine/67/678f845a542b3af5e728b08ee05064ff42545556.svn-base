package com.javapatterns.singleton.mxmail;

import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import com.javapatterns.singleton.mxrecord.MXList;
import com.javapatterns.singleton.mxrecord.MailServer;

/**
 * This class provides an interface on the top of the Java Mail. It provides the methods for email message and attachments.
 * It takes more than one addresses for the to field, cc field, and bcc field. <p> Sending a email takes the following steps:
 * <BR>(1) Create an instance of EmailClient. <BR>(2) Call init method to instantiate the variables for email message.
 * <BR>(3) Call write method one or more times to set the email body.
 * <BR>(4) Call setAttachment one or more times if you need to attach files with the email.
 * <BR>(5) Call setToAddress one or more times if you want to set the multiple recipients with type TO.
 * <BR>(6) Call setCcAddress one or more times if you want to set the multiple recipients with type CC.
 * <BR>(7) Call setBccAddress one or more times if you want to set the multiple recipients with type BCC.
 * <BR>(8) Call send to send the email.
 */

public class EmailManager
{
    private MimeMessage mMsg;
    private Session mSession;
    private Properties mProps;
    private MimeBodyPart mMimeBody;
    private Multipart mMultiParts;

    private String mHost = "";
    private String mUser = "jeff.yan@jeffcorp.com";
    private String mSubject;
    private String mFrom;
    private Vector mTo;
    private Vector mCc;
    private Vector mBcc;
    private String mEmailContent;

    private MXList mxl = null;

    /** This constructor should be called if more than one recipients with recipient type TO, or CC, or BCC will be entered. */
    public EmailManager(String subject, String from) throws Exception
    {
        mSubject = subject;
        mFrom = from;
        mTo = null;
        mCc = null;
        mBcc = null;
    }

    /** This constructor should be called if more than one recipients with recipient type TO, or CC, or BCC will be entered. */
    public EmailManager(String subject, String from, String host, String user) throws Exception
    {
        mUser = user;
        mHost = host;
        mSubject = subject;
        mFrom = from;
        mTo = null;
        mCc = null;
        mBcc = null;
    }

    /**
     * This constructor should be called if one or less than one recipient with
     * recipient type TO, or CC, or BCC will be entered.
     */
    public EmailManager(String subject, String from, String to,
    String cc, String bcc) throws Exception
    {
        mSubject = subject;
        mFrom = from;
        addToAddress(to);
        addCcAddress(cc);
        addBccAddress(bcc);
    }

    /**
     * This constructor should be called if one or less than one recipient with
     * recipient type TO, or CC, or BCC will be entered.
     */
    public EmailManager(String subject, String from, String to,
    String cc, String bcc, String user,
    String host) throws Exception
    {
        mUser = user;
        mHost = host;
        mSubject = subject;
        mFrom = from;
        addToAddress(to);
        addCcAddress(cc);
        addBccAddress(bcc);
    }

    public void addBccAddress(String bccAddr)
    {
        if ((bccAddr == null) || (bccAddr.length() <= 0))
        {
            return;
        }

        if (mBcc == null)
        {
            mBcc = new Vector();
        }

        mBcc.addElement(bccAddr);
    }

    public void addBccAddress(Vector bccAddr)
    {
        if (bccAddr == null)
        {
            return;
        }

        if (mBcc == null)
        {
            mBcc = bccAddr;
        }
        else
        {
            Enumeration bccList = bccAddr.elements();
            while (bccList.hasMoreElements())
            {
                mBcc.addElement(bccList.nextElement());
            }
        }
    }

    public void addCcAddress(String ccAddr)
    {
        if ((ccAddr == null) || (ccAddr.length() <= 0))
        {
            return;
        }

        if (mCc == null)
        {
            mCc = new Vector();
        }

        mCc.addElement(ccAddr);
    }

    public void addCcAddress(Vector ccAddr)
    {
        if (ccAddr == null)
        {
            return;
        }

        if (mCc == null)
        {
            mCc = ccAddr;
        }
        else
        {
            Enumeration ccList = ccAddr.elements();
            while (ccList.hasMoreElements())
            {
                mCc.addElement(ccList.nextElement());
            }
        }
    }

    public void addToAddress(String toAddr)
    {
        if ((toAddr == null) || (toAddr.length() <= 0))
        {
            return;
        }

        if (mTo == null)
        {
            mTo = new Vector();
        }

        mTo.addElement(toAddr);
    }

    public void addToAddress(Vector toAddr)
    {
        if (toAddr == null)
        {
            return;
        }

        if (mTo == null)
        {
            mTo = toAddr;
        }
        else
        {
            Enumeration toList = toAddr.elements();
            while (toList.hasMoreElements())
            {
                mTo.addElement(toList.nextElement());
            }
        }
    }

    public void init() throws Exception
    {
        mxl = MXList.getInstance("dns://dns90.jeffcorp.com", "jeffcorp.com");

        /** Create some properties and get the default Session. */

        mProps = System.getProperties();
        mProps.put("mail.smtp.host", mHost);

        /** If the user is not specified, local user will be used. */
        if ((mUser != null) && (mUser.length() > 0))
        {
            mProps.put("mail.smtp.user", mUser);
        }

        mSession = Session.getDefaultInstance(mProps, null);
        mSession.setDebug(false);
        mMsg = new MimeMessage(mSession);

        mMultiParts = new MimeMultipart();

        mEmailContent = "";

        setSubject();
        setBody();
    }

    public void send() throws Exception
    {

        try
        {
            setFromAddress();
            setToAddress();
            setCcAddress();
            setBccAddress();

            mMimeBody.setText(mEmailContent);
            mMultiParts.addBodyPart(mMimeBody);

            // add the Multipart to the message
            mMsg.setContent(mMultiParts);

            // set the Date: header
            mMsg.setSentDate(new Date());

            boolean shouldContinue = true;

            // try to send emails
            for (int i = 0; i < mxl.size() && shouldContinue; i++)
            {
                try
                {
                    mHost = ((MailServer)mxl.elementAt(i)).getServer();

                    System.out.println("TRYING SMTP SERVER " + mHost + " FOR ROUND " + i);

                    if (mHost == null)
                    {
                        mHost = "";
                    }

                    if (mHost.equals(""))
                    {
                        shouldContinue = true;
                    }
                    else
                    {
                        mProps.put("mail.smtp.host", mHost);
                        // send the message
                        Transport.send(mMsg);
                        shouldContinue = false;
                    }
                }
                catch (SendFailedException sfe)
                {
                    shouldContinue = true;
                }
            }

            init();
        }
        catch (Exception e)
        {
            System.out.println("Error in send()" + e);
            e.printStackTrace();
        }
    }

    public void setAttachment(String filename) throws Exception
    {
        MimeBodyPart mimeAttach = new MimeBodyPart();

        // attach the file to the message
        FileDataSource fds = new FileDataSource(filename);
        mimeAttach.setDataHandler(new DataHandler(fds));
        mimeAttach.setFileName(filename);
        mMultiParts.addBodyPart(mimeAttach);
    }

    protected void setBccAddress() throws Exception
    {
        if (mBcc == null)
        {
            return;
        }

        int addressCount = mBcc.size();
        if (addressCount <= 0)
        {
            return;
        }

        InternetAddress[] addresses = new InternetAddress[addressCount];
        int addressIndex = 0;

        while (addressIndex < addressCount)
        {
            String address = (String)mBcc.elementAt(addressIndex);
            addresses[addressIndex] = new InternetAddress(address);
            addressIndex++;
        }

        mMsg.addRecipients(Message.RecipientType.BCC, addresses);
    }

    protected void setBody()
    {
        // create and fill the message part for main body.
        mMimeBody = new MimeBodyPart();
        mEmailContent = "";

    }

    protected void setCcAddress() throws Exception
    {
        if (mCc == null)
        {
            return;
        }

        int addressCount = mCc.size();
        if (addressCount <= 0)
        {
            return;
        }

        InternetAddress[] addresses = new InternetAddress[addressCount];
        int addressIndex = 0;

        while (addressIndex < addressCount)
        {
            String address = (String)mCc.elementAt(addressIndex);
            addresses[addressIndex] = new InternetAddress(address);
            addressIndex++;
        }

        mMsg.addRecipients(Message.RecipientType.CC, addresses);
    }

    protected void setFromAddress() throws Exception
    {
        if (mFrom.length() <= 0)
        {
            return;
        }

        mMsg.setFrom(new InternetAddress(mFrom));
    }

    protected void setSubject() throws Exception
    {
        if ((mSubject == null) || (mSubject.length() <= 0))
        {
            return;
        }

        mMsg.setSubject(mSubject);
    }

    protected void setToAddress() throws Exception
    {
        if (mTo == null)
        {
            throw new Exception("Recipient TO is not set.");
        }

        int addressCount = mTo.size();
        if (addressCount <= 0)
        {
            throw new Exception("Recipient TO is not set.");
        }

        InternetAddress[] addresses = new InternetAddress[addressCount];
        int addressIndex = 0;

        while (addressIndex < addressCount)
        {
            String address = (String)mTo.elementAt(addressIndex);
            addresses[addressIndex] = new InternetAddress(address);
            addressIndex++;
        }

        mMsg.addRecipients(Message.RecipientType.TO, addresses);
    }

    public void writeMessage(String msg)
    {
        mEmailContent += msg;
    }

    public static void main(String[] args)
    {
        try
        {
            String from = "jeff.yan@jeffcorp.com";
            String to = "jeff.yan@jeffcorp.com";
            String subject = "test SendEmail from NYC";
            String body = "Hello, this is a test";

            EmailManager emailSvc = new EmailManager(subject, from);
            emailSvc.init();
            emailSvc.writeMessage(body);

            //Add to address.
            emailSvc.addToAddress(to);

            emailSvc.send();
        }
        catch (Exception e)
        {
            System.out.println("error:" + e);
            e.printStackTrace();
        }
    }
}

