package by.training.webapplication.service;

import by.training.webapplication.database.ObjectDAO;
import by.training.webapplication.database.QuestionDAO;
import by.training.webapplication.database.connection.DBPoolConnection;
import by.training.webapplication.database.exception.DaoException;
import by.training.webapplication.model.Question;
import by.training.webapplication.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanya on 14.09.2016.
 */
public class QuestionService {

    public void saveQuestion(Question questioninfo){
        try {
            Connection cn = DBPoolConnection.initConnectionPool().getConnection();
            QuestionDAO questionDAO = new QuestionDAO(cn);

            try {
            questionDAO.create(questioninfo);
            } catch (DaoException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public List<Question> getListOfMessages(){
        List<Question> messages = new ArrayList<>();
        try {
            Connection cn = DBPoolConnection.initConnectionPool().getConnection();
            QuestionDAO questionDAO = new QuestionDAO(cn);

            try {
                messages = questionDAO.findAll();
            } catch (DaoException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }
}
