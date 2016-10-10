package by.training.webapplication.service.command;

import by.training.webapplication.mail.MailThread;
import by.training.webapplication.model.Question;
import by.training.webapplication.service.QuestionService;
import by.training.webapplication.service.command.manager.ConfigurationManager;
import by.training.webapplication.service.command.manager.MessageManager;
import by.training.webapplication.service.exception.CommandException;
import by.training.webapplication.service.exception.LogicException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import static by.training.webapplication.service.command.ActionFactory.LOGGER;

/**
 * Created by Tanya on 31.08.2016.
 */
public class MailToCommand implements ActionCommand {
    private QuestionService questionService;
    private Question question = new Question();
    private MessageManager messageManager;

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
       Properties properties = new Properties();
        ServletContext context = request.getServletContext();
        String filename = context.getInitParameter("mail");
        String page = null;
        MailThread mailOperator = new MailThread();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            LOGGER.error(e);
            throw new CommandException(e);
        }
        if(request.getParameter("email")==null) {
            page = ConfigurationManager.getProperty("path.page.contacts");
            question.setQuestionerName(request.getParameter("questionername"));
            question.setBackEmail(request.getParameter("backmail"));
            question.setQuestionText(request.getParameter("body"));
            mailOperator = new MailThread("lutanya@tut.by", "Вопрос", "Вам пришел вопрос. Проидите по ссылке, чтобы прочитать: https://localhost:8087/controller?command=viewmessage", properties);
        }else{
            mailOperator = new MailThread(request.getParameter("email"),"http://localhost:8087 Ответ на вопрос", request.getParameter("response"), properties);
            page = ConfigurationManager.getProperty("path.page.persaradmin");
        }
        mailOperator.start();
        String local;
        if(request.getSession().getAttribute("local")==null){
            local ="ru_RU";
        }else{
            local = (String ) request.getSession().getAttribute("local");
        }
        request.setAttribute("maildeliveredsucs", getMessageManager().getProperty("message.maildelivered",local));
        Question question = new Question();

        if(request.getParameter("email")==null) {
            try {
                getQuestionService().saveQuestion(question);
            } catch (LogicException e) {
                LOGGER.error(e);
                request.setAttribute("maildeliveredsucs", getMessageManager().getProperty("message.maildeliverederror", local));
                throw new CommandException(e);
            }
        }else{
            question.setQuestionId(Integer.parseInt(request.getParameter("id")));
            ArrayList<Question> questionList = new ArrayList<Question>();
            questionList = (ArrayList<Question>)request.getSession().getAttribute("msglist");
            for(Question q: questionList){
                if(q.getQuestionId() == Integer.parseInt(request.getParameter("id"))){
                    q.setReplied(1);
                    break;
                }
            }
            try {
                getQuestionService().updateQuestion(question);
            } catch (LogicException e) {
                LOGGER.error(e);
                throw new CommandException(e);
            }
        }
        return page;
    }

    private QuestionService getQuestionService() {
        if( questionService == null){
            questionService = new QuestionService();
        }
        return questionService;
    }

    private MessageManager getMessageManager() {
        if( messageManager == null){
            messageManager = new MessageManager();
        }
        return messageManager;
    }
}
