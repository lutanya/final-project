package by.training.webapplication.database;

import by.training.webapplication.database.exception.DaoException;

import java.sql.Connection;
import java.util.List;

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
    //public abstract boolean delete(K id);
    public abstract boolean delete(T entity);
    public abstract boolean create(T entity);
    public abstract boolean isEntityById(K id) throws DaoException;
    public abstract T update(T entity);

}
