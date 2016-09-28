package by.training.webapplication.service.command;

import by.training.webapplication.service.command.manager.MessageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tanya on 20.07.2016.
 */
public class ActionFactory {

    public static final Logger logger = LogManager.getLogger();

    private MessageManager messageManager;

    public ActionCommand defineCommand(HttpServletRequest request){
        logger.info("Choice the command");
        ActionCommand current = new EmptyCommand();
        String action = request.getParameter("command");
        if(action == null || action.isEmpty()){
            return current;
        }
        try{
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
                    current = currentEnum.getCurrentCommand();
        }catch (IllegalArgumentException e){
            request.setAttribute("wrongAction", action + getMessageManager().getProperty("message.wrongaction"));
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
