package by.training.webapplication.service;

import by.training.webapplication.database.connection.DBPoolConnection;
import by.training.webapplication.database.ObjectDAO;
import by.training.webapplication.database.exception.DaoException;
import by.training.webapplication.model.ObjPortfolio;
import by.training.webapplication.model.User;
import by.training.webapplication.service.exception.LogicException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.training.webapplication.service.command.ActionFactory.LOGGER;

/**
 * Created by Tanya on 05.09.2016.
 */
public class PortfolioService {

    public List<ObjPortfolio> outputAllObj() throws LogicException {
        List<ObjPortfolio> objList = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBPoolConnection.initConnectionPool().getConnection();
            ObjectDAO objDAO = new ObjectDAO(cn);
            User user = null;
            try {
                objList = objDAO.findAll();
                objList.get(0).setFirst(true);
                objList.get(objList.size()-1).setLast(true);
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
        return objList;
    }
}
