package by.training.webapplication.service.command;

import by.training.webapplication.service.AuthService;
import by.training.webapplication.service.command.manager.ConfigurationManager;
import by.training.webapplication.service.command.manager.MessageManager;
import by.training.webapplication.service.exception.CommandException;
import by.training.webapplication.service.exception.LogicException;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import static by.training.webapplication.service.command.ActionFactory.LOGGER;

/**
 * Created by Tanya on 20.07.2016.
 */
public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private MessageManager messageManager;

    private AuthService authService;

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        try {
            if (getAuthService().checkLogin(login, pass)) {
                request.getSession().setAttribute("username", login);
                if(login.equals("admin"))
                    request.getSession().setAttribute("admin",true);
                page = ConfigurationManager.getProperty("path.page.main");
            } else {
                page = ConfigurationManager.getProperty("path.page.login");
                String local;
                if(request.getSession().getAttribute("local")==null){
                    local ="ru_RU";
                }else{
                    local = (String ) request.getSession().getAttribute("local");
                }
                request.setAttribute("errorLoginPwdMessage", getMessageManager().getProperty("message.loginpasserror",local));
            }
        } catch (LogicException e) {
            LOGGER.error(e);
            throw new CommandException(e);
        }

                /*case 3:
                {
                    page = ConfigurationManager.getProperty("path.page.login");
                    command.getSession().setAttribute("errorPswMessage", MessageManager.getProperty("message.pswerror"));
                    break;
                }
                case 4:
                {
                    page = ConfigurationManager.getProperty("path.page.login");
                    command.getSession().setAttribute("inputLogin", MessageManager.getProperty("message.notenteredlogin"));
                    break;
                }
                case 5:
                {
                    page = ConfigurationManager.getProperty("path.page.login");
                    command.getSession().setAttribute("inputPassword", MessageManager.getProperty("message.notenteredpsw"));
                    break;
                }*/


        return page;
    }

    private AuthService getAuthService() {
        if (authService == null) {
            authService = new AuthService();
        }
        return authService;
    }

    private MessageManager getMessageManager() {
        if (messageManager == null){
            messageManager = new MessageManager();
        }
        return messageManager;
    }
}
