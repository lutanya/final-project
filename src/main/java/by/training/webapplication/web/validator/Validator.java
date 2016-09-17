package by.training.webapplication.web.validator;


import by.training.webapplication.model.User;
import by.training.webapplication.service.AuthService;
import by.training.webapplication.service.command.manager.MessageManager;
import by.training.webapplication.service.exception.LogicException;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by Tanya on 22.06.2016.
 */
public class Validator {
    private static final String PARAM_NAME_FIRSTNAME = "username";
    private static final String PARAM_NAME_LASTNAME = "userlastname";
    private static final String PARAM_NAME_SEX = "sex";
    private static final String PARAM_NAME_CONTRY = "contry";
    private static final String PARAM_NAME_CITY = "city";
    private static final String PARAM_NAME_MAIL = "mail";
    private static final String PARAM_NAME_PHONENUMBER = "phone";
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "pwd1";
    private static final String PARAM_NAME_PASSWORD_REPEAT = "pwd2";

    private MessageManager messageManager;

    private AuthService authService;

    public static boolean RegValid(HttpServletRequest request, User user) {
        boolean flag = true;
        Enumeration<String> parNames = request.getParameterNames();
        while (parNames.hasMoreElements()) {
            switch (parNames.nextElement()) {
                case PARAM_NAME_FIRSTNAME: {
                    if (request.getParameter(PARAM_NAME_FIRSTNAME).equals("")) {
                        flag = false;
                        request.getSession().setAttribute("dontInputName", new MessageManager().getProperty("message.inpName"));
                    } else {
                        request.getSession().setAttribute("dontInputName", "");
                        request.getSession().setAttribute("fname", request.getParameter(PARAM_NAME_FIRSTNAME));

                    }
                    break;
                }
                case PARAM_NAME_SEX: {
                    System.out.println("sex: " + request.getParameter(PARAM_NAME_SEX));
                    if (request.getParameter(PARAM_NAME_SEX).equals("")) {
                        request.getSession().setAttribute("dontInputSex", new MessageManager().getProperty("message.inpSex"));
                    } else {
                        request.getSession().setAttribute("dontInputSex", "");
                    }
                    break;
                }
                case PARAM_NAME_CONTRY: {
                    if (request.getParameter(PARAM_NAME_CONTRY).equals("a")) {
                        flag = false;
                        request.getSession().setAttribute("dontInputCountry", new MessageManager().getProperty("message.inpCountry"));

                    } else {
                        request.getSession().setAttribute("dontInputCountry", "");

                    }
                    break;
                }
                case PARAM_NAME_CITY: {
                    if (request.getParameter(PARAM_NAME_CITY).equals("")) {
                        flag = false;
                        request.getSession().setAttribute("dontInputCity", new MessageManager().getProperty("message.inpCity"));

                    } else {
                        request.getSession().setAttribute("dontInputCity", "");

                    }
                    break;
                }
                case PARAM_NAME_PASSWORD: {
                    if (request.getParameter(PARAM_NAME_PASSWORD).equals("")) {
                        flag = false;
                        //command.getSession().setAttribute("wrongPsw", MessageManager.getProperty("message.wrongPsw"));
                        request.setAttribute("wrongPsw", new MessageManager().getProperty("message.wrongPsw"));
                    } else {
                        //command.getSession().setAttribute("wrongPsw", "");
                        request.setAttribute("wrongPsw", "");
                        if (!request.getParameter(PARAM_NAME_PASSWORD).equals(request.getParameter(PARAM_NAME_PASSWORD_REPEAT))) {
                            flag = false;
                            //command.getSession().setAttribute("errorRepeatPass", MessageManager.getProperty("message.errorrepeat"));
                            request.setAttribute("errorRepeatPass", new MessageManager().getProperty("message.errorrepeat"));
                        }
                    }
                    break;
                }
                case PARAM_NAME_LOGIN: {
                    request.getSession().setAttribute("doublicatelog", "");
                    request.getSession().setAttribute("dontInputLogin", "");
                    if (request.getParameter(PARAM_NAME_LOGIN).equals("")) {
                        flag = false;
                        request.getSession().setAttribute("dontInputLogin", new MessageManager().getProperty("message.inpLogin"));
                    } else {
                        try {
                            if (new AuthService().checkLogin(request.getParameter(PARAM_NAME_LOGIN))) {
                                flag = false;
                                request.getSession().setAttribute("doublicatelog", new MessageManager().getProperty("message.doubllogin"));
                            }
                        } catch (LogicException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                }
                case PARAM_NAME_MAIL: {
                    if (request.getParameter(PARAM_NAME_MAIL).equals("")) {
                        flag = false;
                        request.setAttribute("dontInputMail", new MessageManager().getProperty("message.inpMail"));

                    } else {
                        request.setAttribute("dontInputMail", "");

                    }
                    break;
                }
            }
        }
        return flag;
    }

    public MessageManager getMessageManager() {
        if( messageManager == null){
            messageManager = new MessageManager();
        }
        return messageManager;
    }


}
