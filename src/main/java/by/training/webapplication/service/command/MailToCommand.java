package by.training.webapplication.service.command;

import by.training.webapplication.mail.MailThread;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Tanya on 31.08.2016.
 */
public class MailToCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) throws IOException {
       Properties properties = new Properties();
        /*properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","465");
        properties.put("mail.user.name","REAL~MAIL~NAME@gmail.com");
        properties.put("mail.user.password","REAL~PASSWORD");*/
        //ServletContext context = command.getServletContext();
        //String filename = context.getInitParameter("mail");
        //properties.load(context.getResourceAsStream(filename));
        request.getParameter("subject");
        request.getParameter("body");
        MailThread mailOperator ;
        mailOperator = new MailThread("lutanya@tut.by",request.getParameter("subject"),request.getParameter("body"),properties);
       //mailOperator.start();
        return null;
    }
}
