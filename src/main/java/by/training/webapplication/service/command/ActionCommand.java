package by.training.webapplication.service.command;

import by.training.webapplication.service.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Tanya on 20.07.2016.
 */
public interface ActionCommand {

    String execute(HttpServletRequest request) throws CommandException;
}
