package by.training.webapplication.service.command;

import by.training.webapplication.service.QuestionService;
import by.training.webapplication.service.command.manager.ConfigurationManager;
import by.training.webapplication.service.exception.CommandException;
import by.training.webapplication.service.exception.LogicException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static by.training.webapplication.service.command.ActionFactory.LOGGER;

/**
 * Created by Tanya on 14.09.2016.
 */
public class ViewMessageCommand implements ActionCommand {
    private QuestionService questionService;
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = ConfigurationManager.getProperty("path.page.persaradmin");
        try {
            request.getSession().setAttribute("msglist",getQuestionService().getListOfMessages());
        } catch (LogicException e) {
            LOGGER.error(e);
            throw new CommandException(e);
        }
        return page;
    }

    private QuestionService getQuestionService() {
        if(questionService == null){
            questionService = new QuestionService();
        }
        return questionService;
    }
}
