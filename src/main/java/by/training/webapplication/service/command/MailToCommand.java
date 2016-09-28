package by.training.webapplication.service.command;

import by.training.webapplication.mail.MailThread;
import by.training.webapplication.model.Question;
import by.training.webapplication.service.QuestionService;
import by.training.webapplication.service.exception.CommandException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Tanya on 31.08.2016.
 */
public class MailToCommand implements ActionCommand {
    private QuestionService questionService;
    private Question question = new Question();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
       Properties properties = new Properties();
        ServletContext context = request.getServletContext();
        String filename = context.getInitParameter("mail");
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new CommandException(e);
        }

        question.setQuestionerName(request.getParameter("questionername"));
        question.setBackEmail(request.getParameter("backmail"));
        question.setQuestionText(request.getParameter("body"));
       /* MailThread mailOperator = new MailThread("lutanya@tut.by","Вопрос","Вам пришел вопрос. Прочитать",properties);
        mailOperator.start();*/
        getQuestionService().saveQuestion(question);
        return null;
    }

    private QuestionService getQuestionService() {
        if( questionService == null){
            questionService = new QuestionService();
        }
        return questionService;
    }
}
