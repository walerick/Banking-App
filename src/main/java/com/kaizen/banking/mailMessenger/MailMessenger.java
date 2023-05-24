package com.kaizen.banking.mailMessenger;

import com.kaizen.banking.configurations.MailConfig;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailMessenger {
    public static void htmlEmailMessenger(
            String from,
            String toMail,
            String subject,
            String body
    ) throws MessagingException {
        //Get Mail config
        JavaMailSender sender = MailConfig.getMailConfig();
        //Set Mime message
        MimeMessage message = sender.createMimeMessage();
        //Set Mime message helper
        MimeMessageHelper htmlMessage = new MimeMessageHelper(message, true);
        //Set Mail Attributes / properties
        htmlMessage.setTo(toMail);
        htmlMessage.setFrom(from);
        htmlMessage.setSubject(subject);
        htmlMessage.setText(body,true);
        //send message
        sender.send(message);
    }
    //End of the Html Email message method
}
