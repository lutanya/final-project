package by.training.webapplication.database;

import by.training.webapplication.database.exception.DaoException;
import by.training.webapplication.model.Photo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Tanya on 06.09.2016.
 */
public class PhotoDAO extends AbstractDAO<Integer, Photo> {
    private final static String SQL_SELECT_PHOTO =
            "SELECT portfolio_obj_id, foto_url, foto_info\n" +
                    "FROM foto_obj WHERE portfolio_obj_id=?";
    public PhotoDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List findAll() throws DaoException {

        return null;
    }

    @Override
    public Photo findEntityById(Integer id) throws DaoException {
        Photo ph = new Photo();

        PreparedStatement st = null;
        try {

            st = connection.prepareStatement(SQL_SELECT_PHOTO);

            st.setInt(1, id);
            System.out.println(id);
            ResultSet resultSet = st.executeQuery();

            while(resultSet.next()) {
                //System.out.println(resultSet.getString("password") + resultSet.getString("login"));

            }
        } catch (SQLException e) {
            throw new DaoException(e);

        }finally {
            closeSt(st);
        }
        return null;

    }

    @Override
    public boolean delete(Integer entity) {
        return false;
    }



    @Override
    public boolean create(Photo entity) {
        return false;
    }

    @Override
    public boolean isEntityById(Integer id) throws DaoException {
        return false;
    }

    @Override
    public boolean update(Photo entity) {
        return false;
    }

}
