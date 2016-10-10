package by.training.webapplication.database;

import by.training.webapplication.database.exception.DaoException;
import by.training.webapplication.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static by.training.webapplication.service.command.ActionFactory.LOGGER;

/**
 * Created by Tanya on 24.07.2016.
 */
public class UserDAO extends AbstractDAO<String, User>{
    public static  final String SQL_SELECT_USER_BY_LOGIN = "Select * From user_tbl where login=?";
    public static final String SQL_CREATE_USER = "INSERT INTO user_tbl(login, password, first_name, last_name) VALUES(?,?,?,?)";

    public UserDAO(Connection connection){
        super(connection);
    }
    @Override
    public List findAll() {
        return null;
    }

    @Override
    public User findEntityById(String id) throws DaoException {
        User user = new User();
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_SELECT_USER_BY_LOGIN);
            st.setString(1, id);
            System.out.println(id);
            ResultSet resultSet = st.executeQuery();
            if(resultSet.next()) {

                user.setPassword(resultSet.getString("password"));
                user.setLogin(resultSet.getString("login"));
                user.setName(resultSet.getString("first_name"));
                user.setLastname(resultSet.getString("last_name"));
                user.setRole(resultSet.getInt("role"));
                user.setPhone(resultSet.getString("telephone"));
                user.setMail(resultSet.getString("email"));
                user.setSex(resultSet.getString("sex"));
            }
        } catch (SQLException e) {
           throw new DaoException(e);
        }finally {
            closeSt(st);
        }
        return user;
    }

    @Override
    public boolean delete(String entity) {
        return false;
    }

    @Override
    public boolean create(User entity) throws DaoException{
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_CREATE_USER);
            ps.setString(1,entity.getLogin());
            ps.setString(2,entity.getPassword());
            ps.setString(3,entity.getName());
            ps.setString(4,entity.getLastname());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DaoException(e);
        }finally {
            closeSt(ps);
        }
    }

    @Override
    public boolean isEntityById(String id) throws DaoException {

        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_SELECT_USER_BY_LOGIN);
            st.setString(1, id);
            ResultSet resultSet = st.executeQuery();
            if(resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DaoException(e);
        }finally {
           closeSt(st);
        }
        return false;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }
}
