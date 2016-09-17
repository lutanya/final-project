package by.training.webapplication.service.command;

import by.training.webapplication.service.command.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tanya on 20.07.2016.
 */
public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index");
        String local = (String)request.getSession().getAttribute("local");
        request.getSession().invalidate();
        request.getSession().setAttribute("local",local);
        return page;
    }
}
