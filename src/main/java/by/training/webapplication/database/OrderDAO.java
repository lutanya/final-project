package by.training.webapplication.database;

import by.training.webapplication.database.exception.DaoException;
import by.training.webapplication.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static by.training.webapplication.service.command.ActionFactory.logger;

/**
 * Created by Tanya on 08.09.2016.
 */
public class OrderDAO extends AbstractDAO<String, Order> {
    public static final String SQL_SELECT_OBJECT_BY_KINDOFWORK = "Select Price From objects where object_name=?";
    public OrderDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Order> findAll() throws DaoException {
        return null;
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
            throw new DaoException(e);

        }finally {
            closeSt(st);
        }
        return order;
    }

    @Override
    public boolean delete(Order entity) {
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
    public Order update(Order entity) {
        return null;
    }
}
