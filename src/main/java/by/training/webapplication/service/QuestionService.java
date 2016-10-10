package by.training.webapplication.service;

import by.training.webapplication.database.ObjectDAO;
import by.training.webapplication.database.QuestionDAO;
import by.training.webapplication.database.connection.DBPoolConnection;
import by.training.webapplication.database.exception.DaoException;
import by.training.webapplication.model.Question;
import by.training.webapplication.model.User;
import by.training.webapplication.service.exception.LogicException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.training.webapplication.service.command.ActionFactory.LOGGER;

/**
 * Created by Tanya on 14.09.2016.
 */
public class QuestionService {

    public void saveQuestion(Question questioninfo) throws LogicException {
        try {
            Connection cn = DBPoolConnection.initConnectionPool().getConnection();
            QuestionDAO questionDAO = new QuestionDAO(cn);
            try {
            questionDAO.create(questioninfo);
            } catch (DaoException e) {
                LOGGER.error(e);
                throw new LogicException(e);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }
    public void updateQuestion(Question questioninfo) throws LogicException {
        try {
            Connection cn = DBPoolConnection.initConnectionPool().getConnection();
            QuestionDAO questionDAO = new QuestionDAO(cn);
            try {
                questionDAO.update(questioninfo);
            } catch (DaoException e) {
                LOGGER.error(e);
                throw new LogicException(e);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }
    public List<Question> getListOfMessages() throws LogicException {
        List<Question> messages = new ArrayList<>();
        try {
            Connection cn = DBPoolConnection.initConnectionPool().getConnection();
            QuestionDAO questionDAO = new QuestionDAO(cn);
            try {
                messages = questionDAO.findAll();
            } catch (DaoException e) {
                LOGGER.error(e);
                throw new LogicException(e);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return messages;
    }
}
