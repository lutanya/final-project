package by.training.webapplication.mail;


import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 * Created by Tanya on 31.08.2016.
 */
public class SessionCreator {

    private String smtpHost;
    private String smtpPort;
    private String userName;
    private String userPassword;
    private Properties sessionProperties;

    public SessionCreator(Properties configProperties){
        smtpHost = configProperties.getProperty("mail.smtp.host");
        smtpPort = configProperties.getProperty("mail.smtp.port");
        userName = configProperties.getProperty("mail.user.name");
        userPassword = configProperties.getProperty("mail.user.password");
        sessionProperties = new Properties();
        sessionProperties.setProperty("mail.transport.protocol","smtp");
        sessionProperties.setProperty("mail.host","smtp");
        sessionProperties.put("mail.smtp.auth","true");
        sessionProperties.put("mail.smtp.port",smtpPort);
        sessionProperties.put("mail.smtp.socketFactory.port",smtpPort);
        sessionProperties.put("mail.smtp.socketFactory.fallback","false");
        sessionProperties.put("mail.smtp.quitwait","false");
    }
    public Session createSession(){
        return Session.getDefaultInstance(sessionProperties, new javax.mail.Authenticator(){
          protected PasswordAuthentication getPasswordAuthentification(){
              return new PasswordAuthentication(userName, userPassword);
          }
        });
    }
}
