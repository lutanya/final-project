package by.training.webapplication.service.command;

import by.training.webapplication.service.command.ActionFactory;
import by.training.webapplication.service.command.manager.ConfigurationManager;
import by.training.webapplication.service.exception.CommandException;
import by.training.webapplication.service.exception.LogicException;
import by.training.webapplication.service.util.OrderUtil;

import javax.servlet.http.HttpServletRequest;
import static by.training.webapplication.service.command.ActionFactory.LOGGER;
/**
 * Created by Tanya on 09.10.2016.
 */
public class ViewOrderCommand implements ActionCommand {
    private OrderUtil orderUtil;

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = null;
        try {
            request.setAttribute("orders", getOrderUtil().readOrders());
            request.setAttribute("vieword",true);
            page = ConfigurationManager.getProperty("path.page.persaradmin");
        } catch (LogicException e) {
            LOGGER.error(e);
            throw new CommandException(e);
        }
        return page;
    }

    public OrderUtil getOrderUtil(){
        if(orderUtil==null){
            orderUtil = new OrderUtil();
        }
        return orderUtil;
    }
}
