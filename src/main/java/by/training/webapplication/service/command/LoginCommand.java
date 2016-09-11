package by.training.webapplication.service.command;

import by.training.webapplication.service.AuthService;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tanya on 20.07.2016.
 */
public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    private AuthService authService;

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);

        try {
            if (getAuthService().checkLogin(login, pass)) {
                request.setAttribute("user", login);
                page = ConfigurationManager.getProperty("path.page.main");
            } else {
                page = ConfigurationManager.getProperty("path.page.login");
                request.getSession().setAttribute("errorLoginPwdMessage", MessageManager.getProperty("message.loginpasserror"));
            }
        } catch (LoginException e1) {
            e1.printStackTrace();
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

    public AuthService getAuthService() {
        if (authService == null) {
            authService = new AuthService();
        }
        return authService;
    }
}
