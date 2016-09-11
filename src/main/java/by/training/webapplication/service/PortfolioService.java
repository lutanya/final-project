package by.training.webapplication.service;

import by.training.webapplication.database.connection.DBPoolConnection;
import by.training.webapplication.database.ObjectDAO;
import by.training.webapplication.database.exception.DaoException;
import by.training.webapplication.model.ObjPortfolio;
import by.training.webapplication.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanya on 05.09.2016.
 */
public class PortfolioService {

    public List<ObjPortfolio> outputAllObj(){
        List<ObjPortfolio> objList = new ArrayList<>();
        try {
            Connection cn = DBPoolConnection.initConnectionPool().getConnection();
            ObjectDAO objDAO = new ObjectDAO(cn);
            User user = null;
            try {
                objList = objDAO.findAll();
                objList.get(0).setFirst(true);
                objList.get(objList.size()-1).setLast(true);
            } catch (DaoException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objList;
    }
}
