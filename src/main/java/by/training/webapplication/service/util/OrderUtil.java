package by.training.webapplication.service.util;


import by.training.webapplication.database.connection.DBPoolConnection;
import by.training.webapplication.database.OrderDAO;
import by.training.webapplication.database.exception.DaoException;
import by.training.webapplication.model.Order;
import by.training.webapplication.service.exception.LogicException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.training.webapplication.service.command.ActionFactory.LOGGER;

/**
 * Created by Tanya on 08.09.2016.
 */
public class OrderUtil {

    public static float calculate(Order entity){
        float cost = 0;
        try {
            Connection cn = DBPoolConnection.initConnectionPool().getConnection();

            OrderDAO orderDAO = new OrderDAO(cn);

            try {
                entity.setPriceFoKindOfProject(orderDAO.findEntityById(entity.getKindOfWork()).getPriceFoKindOfProject());
            } catch (DaoException e) {
                e.printStackTrace();
            }

           cost = entity.getSquareOfObj()*entity.getPriceFoKindOfProject();


        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return cost;
    }
    public List<Order> readOrders() throws LogicException {
        List<Order> orders = new ArrayList<>();
        try {
            Connection cn = DBPoolConnection.initConnectionPool().getConnection();
            OrderDAO orderDAO = new OrderDAO(cn);
            try {
               orders = orderDAO.findAll();

            } catch (DaoException e) {
                LOGGER.error(e);
                throw new LogicException(e);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return orders;
    }
}
