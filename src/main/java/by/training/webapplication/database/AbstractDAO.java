package by.training.webapplication.database;

import by.training.webapplication.database.exception.DaoException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static by.training.webapplication.service.command.ActionFactory.logger;

/**
 * Created by Tanya on 24.07.2016.
 */
public abstract class AbstractDAO<K, T> {
    protected Connection connection;
    public AbstractDAO(Connection connection){
        this.connection = connection;
    }
    public abstract List<T> findAll() throws DaoException;
    public abstract T findEntityById(K id) throws DaoException;
    public abstract boolean delete(K entity) throws DaoException;
    public abstract boolean create(T entity) throws DaoException;
    public abstract boolean isEntityById(K id) throws DaoException;
    public abstract T update(T entity);
    public void closeSt(Statement st){
        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                logger.error("Statement isn't create!");
            }
        }
    }

}
