package com.universidad.utils.email;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Email {

    @Getter @Setter
    private String sender;
    @Getter @Setter
    private List<String> recipients;
    @Getter @Setter
    private String subject;
    @Getter @Setter
    private String message;
    @Getter @Setter
    private List<File> attachments;

    public Email() {
        this.recipients = new ArrayList<>();
        this.attachments = new ArrayList<>();
    }

    public Email(String sender, List<String> recipients, String message, String subject, List<File> attachments) {
        this.sender = sender;
        this.recipients = recipients;
        this.subject = subject;
        this.message = message;
        this.attachments = attachments;
    }

    public void addRecipient(String recipient) {
        this.recipients.add(recipient);
    }

    public void addAttachment(File file) {
        this.attachments.add(file);
    }

}
