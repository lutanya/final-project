package by.training.webapplication.service.command;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Tanya on 20.07.2016.
 */
public interface ActionCommand {

    String execute(HttpServletRequest request) throws IOException;
}
