package by.training.webapplication.service.command;

import by.training.webapplication.service.command.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tanya on 21.07.2016.
 */
public class BackCommand implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.main");
        return page;
    }
}
