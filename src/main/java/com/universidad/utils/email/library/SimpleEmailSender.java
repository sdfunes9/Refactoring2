package com.universidad.utils.email.library;

import com.universidad.utils.email.Email;
import com.universidad.utils.email.interfaces.EmailSender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class SimpleEmailSender implements EmailSender {

    private final Properties properties;
    private Session session;
    private static final String defaultEmail = "grupo1.proyecto.universidad@gmail.com";
    private static final String defaultPassword = "mlsindsvsrxsqefp";

    public SimpleEmailSender(Session session) {
        this.properties = session.getProperties();
        this.session = session;
    }

    public SimpleEmailSender(Properties props, String username, String password) {
        this.properties = props;
        startSession(username, password);
    }

    private static Properties defaultProperties() {
        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        return props;
    }

    public static SimpleEmailSender getDefaultInstance() {
        return new SimpleEmailSender(defaultProperties(), defaultEmail, defaultPassword);
    }

    private void startSession(String username, String password) {
        final String user = username;
        final String pass = password;
        this.session = Session.getInstance(this.properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });
    }

    @Override
    public void sendEmail(Email email) {
        Message message = new MimeMessage(this.session);

        try {
            if(email.getSender() == null) {
                message.setFrom(new InternetAddress(defaultEmail));
            } else {
                message.setFrom(new InternetAddress(email.getSender()));
            }

            if(email.getRecipients().size() == 1) {
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getRecipients().get(0)));
            } else if(email.getRecipients().size() > 1) {
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(
                                String.join(",", email.getRecipients())));
            }

            message.setSubject(email.getSubject());

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(email.getMessage(), "text/plain");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            if(email.getAttachments().size() > 0) {
                for(File file : email.getAttachments()) {
                    MimeBodyPart attachment = new MimeBodyPart();
                    attachment.attachFile(file);

                    multipart.addBodyPart(attachment);
                }
            }

            message.setContent(multipart);

            Transport.send(message);
        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}