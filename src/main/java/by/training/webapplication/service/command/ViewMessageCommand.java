package by.training.webapplication.service.command;

import by.training.webapplication.service.QuestionService;
import by.training.webapplication.service.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Tanya on 14.09.2016.
 */
public class ViewMessageCommand implements ActionCommand {
    private QuestionService questionService;
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = "/jsp/personalareaadmin.jsp";
        request.setAttribute("msglist",getQuestionService().getListOfMessages());
        return page;
    }

    private QuestionService getQuestionService() {
        if(questionService == null){
            questionService = new QuestionService();
        }
        return questionService;
    }
}
