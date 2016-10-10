package by.training.webapplication.service.command;

import by.training.webapplication.model.User;
import by.training.webapplication.service.AuthService;
import by.training.webapplication.service.command.manager.ConfigurationManager;
import by.training.webapplication.service.exception.CommandException;
import by.training.webapplication.service.exception.LogicException;
import by.training.webapplication.web.validator.Validator;

import static by.training.webapplication.service.command.ActionFactory.LOGGER;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tanya on 03.08.2016.
 */
public class RegCommand implements ActionCommand {
    private static final String PARAM_NAME_USERNAME = "username";
    private static final String PARAM_NAME_LASTNAME = "userlastname";
    private static final String PARAM_NAME_CONTRY = "contry";
    private static final String PARAM_NAME_CITY = "city";
    private static final String PARAM_NAME_MAIL = "mail";
    private static final String PARAM_NAME_PHONENUMBER = "phone";
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "pwd1";
    private static final String PARAM_NAME_PASSWORD_REPEAT = "pwd2";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user = new User();
        String page = ConfigurationManager.getProperty("path.page.registr");
        user.setName(request.getParameter(PARAM_NAME_USERNAME));
        user.setLastname(request.getParameter(PARAM_NAME_LASTNAME));
        user.setContry(request.getParameter(PARAM_NAME_CONTRY));
        user.setCity(request.getParameter(PARAM_NAME_CITY));
        user.setMail(request.getParameter(PARAM_NAME_MAIL));
        user.setPhone(request.getParameter(PARAM_NAME_PHONENUMBER));
        user.setLogin(request.getParameter(PARAM_NAME_LOGIN));
        user.setPassword(request.getParameter(PARAM_NAME_PASSWORD));
        request.getSession().setAttribute("user",user);
        if(Validator.RegValid(request, user)) {
            try {
                if (new AuthService().isUserRegistered(user)) {
                    LOGGER.info("Good registration");
                    request.getSession().setAttribute("username", user.getName());
                    request.getSession().setAttribute("userlastname", user.getLastname());
                    page = ConfigurationManager.getProperty("path.page.sucsreg");
                } else {
                    page = ConfigurationManager.getProperty("path.page.registr");
                }
            } catch (LogicException e) {
                LOGGER.error(e);
                throw new CommandException(e);
            }
        }
       /* if(command.getParameter(PARAM_NAME_PASSWORD).equals(command.getParameter(PARAM_NAME_PASSWORD_REPEAT))) {

            if (AuthUtil.isUserRegistered(user)) {
                System.out.println("Good registr");
                command.setAttribute("user", user.getLogin());
                page = ConfigurationManager.getProperty("path.page.main");
            }else{
                page = ConfigurationManager.getProperty("path.page.registr");
                command.getSession().setAttribute("doublicatelog", MessageManager.getProperty("message.doubllogin"));
            }
        }else{
            page = ConfigurationManager.getProperty("path.page.registr");
            command.getSession().setAttribute("errorRepeatPass", MessageManager.getProperty("message.errorrepeat"));
        }*/
        return page;
    }
}
