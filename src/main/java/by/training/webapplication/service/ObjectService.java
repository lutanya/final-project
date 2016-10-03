package by.training.webapplication.service;

import by.training.webapplication.database.ObjectDAO;
import by.training.webapplication.database.UserDAO;
import by.training.webapplication.database.connection.DBPoolConnection;
import by.training.webapplication.database.exception.DaoException;
import by.training.webapplication.model.ObjPortfolio;
import by.training.webapplication.model.User;
import by.training.webapplication.service.exception.LogicException;
import by.training.webapplication.util.MD5;

import java.sql.Connection;
import java.sql.SQLException;

import static by.training.webapplication.service.command.ActionFactory.logger;

/**
 * Created by Tanya on 28.09.2016.
 */
public class ObjectService {
    public boolean removeObj(String elem) throws LogicException {

        Connection cn = null;


        try {
            cn = DBPoolConnection.initConnectionPool().getConnection();
            try {
                return new ObjectDAO(cn).delete(elem);
            } catch (DaoException e) {
                throw new LogicException(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    DBPoolConnection.initConnectionPool().putConnection(cn);
                } catch (SQLException e) {

                    e.printStackTrace();

                }
            }
        }
        return false;
    }

    public boolean addObject(ObjPortfolio entity) throws LogicException {
        Connection cn = null;


        try {
            cn = DBPoolConnection.initConnectionPool().getConnection();

            try {
                return new ObjectDAO(cn).create(entity);

            } catch (DaoException e) {
                throw new LogicException(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    DBPoolConnection.initConnectionPool().putConnection(cn);
                } catch (SQLException e) {

                    e.printStackTrace();

                }
            }
        }
        return false;
    }
}
