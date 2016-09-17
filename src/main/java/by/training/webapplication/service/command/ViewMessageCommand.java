package by.training.webapplication.service.command;

import by.training.webapplication.service.QuestionService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Tanya on 14.09.2016.
 */
public class ViewMessageCommand implements ActionCommand {
    private QuestionService questionService;
    @Override
    public String execute(HttpServletRequest request) throws IOException {
        String page = "/jsp/personalareaadmin.jsp";
        request.setAttribute("msglist",getQuestionService().getListOfMessages());
        return page;
    }

    public QuestionService getQuestionService() {
        if(questionService == null){
            questionService = new QuestionService();
        }
        return questionService;
    }
}
