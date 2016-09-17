package by.training.webapplication.service;

import by.training.webapplication.database.connection.DBPoolConnection;
import by.training.webapplication.database.UserDAO;
import by.training.webapplication.database.exception.DaoException;
import by.training.webapplication.model.User;
import by.training.webapplication.service.exception.LogicException;
import by.training.webapplication.util.MD5;

import javax.security.auth.login.LoginException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Tanya on 11.09.2016.
 */
public class AuthService {

    public boolean checkLogin(String enterLogin, String enterPass) throws LogicException {
        MD5 md5 = new MD5();
        Connection cn = null;
        //boolean flag = false;

        if(enterLogin != "" && enterPass != "") {
            try {
                cn = DBPoolConnection.initConnectionPool().getConnection();

                UserDAO userDAO = new UserDAO(cn);
                User user = userDAO.findEntityById(enterLogin);

                if (user.getLogin() != null && user.getPassword().equals(md5.getHash(enterPass))) {
                    System.out.println("Enter to system");
                    return true;
                } else {
                    System.out.println("Wrong password");
                }
            } catch (DaoException e) {
                throw new LogicException(e);
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if(cn != null){
                    try {
                        DBPoolConnection.initConnectionPool().putConnection(cn);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }

    public boolean checkLogin(String login) throws LogicException {
        boolean flag = false;
        try {
            Connection cn = DBPoolConnection.initConnectionPool().getConnection();
            UserDAO userDAO = new UserDAO(cn);
            try {
                flag = userDAO.isEntityById(login);
            } catch (DaoException e) {
                throw new LogicException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean isUserRegistered(User entity){
        MD5 md5 = new MD5();
        boolean flag = false;

        try {
            Connection cn = DBPoolConnection.initConnectionPool().getConnection();

            UserDAO userDAO = new UserDAO(cn);
            User user = null;
            try {
                user = userDAO.findEntityById(entity.getLogin());
            } catch (DaoException e) {
                e.printStackTrace();
            }

            if (user.getLogin() == null) {
                entity.setPassword(md5.getHash(entity.getPassword()));
                if (userDAO.create(entity)) {
                    System.out.println("Save user");
                    flag = true;
                } else {
                    System.out.println("Wrong password");

                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }


}
