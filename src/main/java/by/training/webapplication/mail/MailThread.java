package by.training.webapplication.mail;




import javax.mail.*;
import java.util.Properties;

/**
 * Created by Tanya on 31.08.2016.
 */
public class MailThread extends Thread {
    //private MimeMessage message;
    private String sendToEmail;
    private String mailSubject;
    private String mailText;
    private Properties properties;

    public MailThread(String sendToEmail, String mailSubject, String mailText, Properties properties){
        this.sendToEmail = sendToEmail;
        this.mailSubject = mailSubject;
        this.mailText = mailText;
        this.properties = properties;
    }
    private void init(){
        Session mailSession = (new SessionCreator(properties)).createSession();
        mailSession.setDebug(true);
        /*message = new MimeMessage(mailSession);
        try{
            message.setSubject(mailSubject);
            message.setContent(mailText,"text/html");
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(sendToEmail));

        }catch (AddressException e){
            System.err.print("Некорректный адрес: " + sendToEmail +" " + e);
        }catch (MessagingException e){
            System.err.print("Ошибка формиования сообщения" + e);
        }
    }
    public void run(){
        init();
        try{
            Transport.send(message);
        }catch (MessagingException e){
            System.err.println("Ошибка при отправлении сообщения" + e);
        }*/
    }
}
