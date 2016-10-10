package by.training.webapplication.service.command;

import by.training.webapplication.service.command.manager.MessageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tanya on 20.07.2016.
 */
public class ActionFactory {

    public static final Logger LOGGER = LogManager.getLogger();

    private MessageManager messageManager;

    public ActionCommand defineCommand(HttpServletRequest request){
        LOGGER.info("Choice the command");
        ActionCommand current = new EmptyCommand();
        String action = request.getParameter("command");
        if(action == null || action.isEmpty()){
            return current;
        }
        if (request.getSession().getAttribute("local") == null) {
            request.getSession().setAttribute("localRu", true);
            request.getSession().setAttribute("localEn", false);
        } else if (request.getSession().getAttribute("local").equals("ru_RU")) {
            request.getSession().setAttribute("localRu", true);
            request.getSession().setAttribute("localEn", false);
        } else {
            request.getSession().setAttribute("localEn", true);
            request.getSession().setAttribute("localRu", false);
        }
        try{
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
                    current = currentEnum.getCurrentCommand();
        }catch (IllegalArgumentException e){
            String local;
            if(request.getSession().getAttribute("local")==null){
                 local ="ru_RU";
            }else{
                local = (String ) request.getSession().getAttribute("local");
            }
            request.setAttribute("wrongAction", action + getMessageManager().getProperty("message.wrongaction",local));
        }
        return current;
    }

    private MessageManager getMessageManager() {
        if (messageManager == null){
            messageManager = new MessageManager();
        }
        return messageManager;
    }
}
