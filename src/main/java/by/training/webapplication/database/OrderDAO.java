package by.training.webapplication.database;

import by.training.webapplication.database.exception.DaoException;
import by.training.webapplication.model.ObjPortfolio;
import by.training.webapplication.model.Order;
import by.training.webapplication.model.Photo;
import by.training.webapplication.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.training.webapplication.service.command.ActionFactory.LOGGER;

/**
 * Created by Tanya on 08.09.2016.
 */
public class OrderDAO extends AbstractDAO<String, Order> {
    public static final String SQL_SELECT_OBJECT_BY_KINDOFWORK = "Select Price From objects where object_name=?";
    public static final String SQL_SELECT_ORDER_INFO = "SELECT order_title, done, first_name,last_name,sex,email,telephone\n" +
            "FROM `order`,user_tbl where `client`=login  ";
    public OrderDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Order> findAll() throws DaoException {
        List<Order> ordersList = new ArrayList<>();
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_SELECT_ORDER_INFO);
            ResultSet resultSet = st.executeQuery();
            Order o;
            User u;

            while (resultSet.next()) {
                o = new Order();
                o.setTitle(resultSet.getString("order_title"));
                o.setDone(resultSet.getInt("done"));
                u = new User();
                u.setName(resultSet.getString("first_name"));
                u.setLastname(resultSet.getString("last_name"));
                u.setSex(resultSet.getString("sex"));
                u.setMail(resultSet.getString("email"));
                u.setPhone(resultSet.getString("telephone"));
                u.setOrder(o);
                o.setUser(u);
                ordersList.add(o);
            }

        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DaoException(e);
        }finally {
            closeSt(st);
        }
        return ordersList;
    }

    @Override
    public Order findEntityById(String id) throws DaoException {
        Order order = new Order();
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(SQL_SELECT_OBJECT_BY_KINDOFWORK);
            st.setString(1, id);
            ResultSet resultSet = st.executeQuery();
            if(resultSet.next()) {
                order.setPriceFoKindOfProject(resultSet.getFloat("Price"));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DaoException(e);

        }finally {
            closeSt(st);
        }
        return order;
    }

    @Override
    public boolean delete(String entity) {
        return false;
    }



    @Override
    public boolean create(Order entity) {
        return false;
    }

    @Override
    public boolean isEntityById(String id) throws DaoException {
        return false;
    }

    @Override
    public boolean update(Order entity) {
        return false;
    }
}
