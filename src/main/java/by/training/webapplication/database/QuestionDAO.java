package by.training.webapplication.database;

import by.training.webapplication.database.exception.DaoException;
import by.training.webapplication.model.ObjPortfolio;
import by.training.webapplication.model.Photo;
import by.training.webapplication.model.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static by.training.webapplication.service.command.ActionFactory.logger;

/**
 * Created by Tanya on 14.09.2016.
 */
public class QuestionDAO extends  AbstractDAO<String, Question> {
    private final static String SQL_SELECT_MESSAGES = "SELECT f_name, contact_info, f_text, feedback_date, response FROM feedback";
    public QuestionDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Question> findAll() throws DaoException {
        List<Question> listOfQuestions = new ArrayList<>();


        PreparedStatement st = null;

        try {

            st = connection.prepareStatement(SQL_SELECT_MESSAGES);

            ResultSet resultSet = st.executeQuery();

            Question q;

            while (resultSet.next()) {
                q = new Question();
                q.setQuestionerName(resultSet.getString("f_name"));
                q.setBackEmail(resultSet.getString("contact_info"));
                q.setQuestionText(resultSet.getString("f_text"));
                q.setResponce(Boolean.parseBoolean(resultSet.getString("response")));
                listOfQuestions.add(q);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            closeSt(st);
        }
        return listOfQuestions;

    }

    @Override
    public Question findEntityById(String id) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Question entity) {
        return false;
    }

    @Override
    public boolean create(Question entity) throws DaoException {
        PreparedStatement ps = null;
        try {

            ps = connection.prepareStatement("INSERT INTO feedback(f_name, contact_info, f_text, feedback_date) VALUES(?,?,?,?)");
            ps.setString(1,entity.getQuestionerName());
            ps.setString(2,entity.getBackEmail());
            ps.setString(3,entity.getQuestionText());
            ps.setString(4,"2016-09-14");
            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            throw new DaoException(e);

        }finally {
            closeSt(ps);
        }

    }

    @Override
    public boolean isEntityById(String id) throws DaoException {
        return false;
    }

    @Override
    public Question update(Question entity) {
        return null;
    }
}
