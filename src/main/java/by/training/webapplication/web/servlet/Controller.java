package by.training.webapplication.web.servlet;

import by.training.webapplication.service.command.ActionCommand;
import by.training.webapplication.service.command.ActionFactory;
import by.training.webapplication.service.exception.CommandException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import static by.training.webapplication.service.command.ActionFactory.LOGGER;

/**
 * Created by Tanya on 20.07.2016.
 */
@MultipartConfig
@WebServlet("/controller")
public class Controller extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.debug("Processing request: " + request);
        String page = null;
        //SessionRequestContent requestContent = new SessionRequestContent(request);
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        try {
            page = command.execute(request);
        } catch (CommandException e) {
            LOGGER.error(e);
        }
        if (page != null) {

            //response.sendRedirect(command.getContextPath() + page);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request,response);
        } else {
            //page = ConfigurationManager.getProperty("path.page.index");
            page = new URL(request.getHeader("referer")).getPath();
            //command.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);

        }
    }
}
