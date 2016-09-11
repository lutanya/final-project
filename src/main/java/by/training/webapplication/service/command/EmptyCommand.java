package by.training.webapplication.service.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tanya on 20.07.2016.
 */
public class EmptyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        return page;
    }
}
