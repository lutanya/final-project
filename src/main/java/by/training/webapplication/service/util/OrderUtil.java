package by.training.webapplication.service.util;


import by.training.webapplication.database.connection.DBPoolConnection;
import by.training.webapplication.database.OrderDAO;
import by.training.webapplication.database.exception.DaoException;
import by.training.webapplication.model.Order;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Tanya on 08.09.2016.
 */
public class OrderUtil {

    public static float calculate(Order entity){
        float cost = 0;
        try {
            Connection cn = DBPoolConnection.initConnectionPool().getConnection();

            OrderDAO orderDAO = new OrderDAO(cn);
            //Order order = new Order();
            try {
                entity.setPriceFoKindOfProject(orderDAO.findEntityById(entity.getKindOfWork()).getPriceFoKindOfProject());
            } catch (DaoException e) {
                e.printStackTrace();
            }

           cost = entity.getSquareOfObj()*entity.getPriceFoKindOfProject();
            System.out.println(cost);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cost;
    }
}
