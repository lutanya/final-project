package by.training.webapplication.mail;




import static by.training.webapplication.service.command.ActionFactory.LOGGER;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Tanya on 31.08.2016.
 */
public class MailThread extends Thread {
    private MimeMessage message;
    private String sendToEmail;
    private String mailSubject;
    private String mailText;
    private Properties properties;

    public MailThread(){}

    public MailThread(String sendToEmail, String mailSubject, String mailText, Properties properties){
        this.sendToEmail = sendToEmail;
        this.mailSubject = mailSubject;
        this.mailText = mailText;
        this.properties = properties;
    }
    private void init(){
        Session mailSession = (new SessionCreator(properties)).createSession();
        mailSession.setDebug(true);
        message = new MimeMessage(mailSession);
        try{
            message.setSubject(mailSubject);
            message.setContent(mailText,"text/plain; charset=utf-8");
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(sendToEmail));

        }catch (AddressException e){
            LOGGER.error("Некорректный адрес: " + sendToEmail +" " + e);
        }catch (MessagingException e){
            LOGGER.error("Ошибка формиования сообщения" + e);
        }
    }
    public void run(){
        init();
        try{
            Transport.send(message);
        }catch (MessagingException e){
            LOGGER.error("Ошибка при отправлении сообщения" + e);
        }
    }
}
