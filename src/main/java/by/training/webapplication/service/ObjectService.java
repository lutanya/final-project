package by.training.webapplication.service;

import by.training.webapplication.database.ObjectDAO;
import by.training.webapplication.database.connection.DBPoolConnection;
import by.training.webapplication.database.exception.DaoException;
import by.training.webapplication.model.ObjPortfolio;
import by.training.webapplication.service.exception.LogicException;

import java.sql.Connection;
import java.sql.SQLException;
import static by.training.webapplication.service.command.ActionFactory.LOGGER;
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
                LOGGER.error(e);
                throw new LogicException(e);
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    LOGGER.error(e);
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
                LOGGER.error(e);
                throw new LogicException(e);
            }
        } catch (SQLException e) {
            LOGGER.error(e);;
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        }
        return false;
    }

    public boolean updateObject(ObjPortfolio entity) throws LogicException {
        Connection cn = null;
        try {
            cn = DBPoolConnection.initConnectionPool().getConnection();
            try {
                return new ObjectDAO(cn).update(entity);
            } catch (DaoException e) {
                LOGGER.error(e);
                throw new LogicException(e);
            }
        } catch (SQLException e) {
            LOGGER.error(e);;
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        }
        return false;
    }
}
