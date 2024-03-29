package com.javapatterns.builder.javamail;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender
{
    private static MimeMessage message;

    public static void main(String[] args)
    {

        String smtpHost = "umbriel.email.jeffcorp.com";
        String from = "jeff.yan@jeffcorp.com";
        String to = "hong.yan@jeffcorp.com";

        Properties props = new Properties();
        props.put("mail.smtp.host", smtpHost);

        Session session = Session.getDefaultInstance(props, null);

        try
        {
            InternetAddress[] address = {new InternetAddress(to)};

            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject("Hello from Jeff");
            message.setSentDate(new Date());
            message.setText("Hello Jeff, \nHow are things going?");

            Transport.send(message);

            System.out.println("email has been sent.");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
