package com.universidad.utils.email;

import com.universidad.utils.email.interfaces.EmailSender;
import lombok.Getter;
import lombok.Setter;

public class EmailService {

    @Getter @Setter
    private EmailSender emailSender;

    public EmailService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendEmail(Email email) {
        emailSender.sendEmail(email);
    }

}
