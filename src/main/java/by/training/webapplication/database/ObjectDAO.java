package by.training.webapplication.database;

import by.training.webapplication.database.exception.DaoException;
import by.training.webapplication.model.ObjPortfolio;
import by.training.webapplication.model.Photo;
import static by.training.webapplication.service.command.ActionFactory.logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanya on 05.09.2016.
 */
public class ObjectDAO extends AbstractDAO<String, ObjPortfolio> {
    private final static String SQL_SELECT_OBJECT_INFO =
            "SELECT idPortfolio_obj, object_name, object_info, object_genre\n" +
                    "FROM portfolio WHERE object_genre IN \n" +
                    "(SELECT genre FROM object_types WHERE `type` = \"obj\")";
    private final static String SQL_SELECT_PHOTO =
            "SELECT portfolio_obj_id, foto_url, foto_info\n" +
                    "FROM foto_obj WHERE portfolio_obj_id=?";


    public ObjectDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<ObjPortfolio> findAll() throws DaoException {
        List<ObjPortfolio> listOfObj = new ArrayList<>();


        PreparedStatement st = null;
        PreparedStatement stForPhoto;

        try {

            st = connection.prepareStatement(SQL_SELECT_OBJECT_INFO);


            ResultSet resultSet = st.executeQuery();
            ResultSet resultSetForPhoto;
            ObjPortfolio o;
            Photo ph;
            int i;
            while (resultSet.next()) {
                o = new ObjPortfolio();
                ph = new Photo();

                o.setId(resultSet.getInt("idPortfolio_obj"));
                o.setObjName(resultSet.getString("object_name"));
                o.setObjInfo(resultSet.getString("object_info"));
                o.setObjGenre(resultSet.getString("object_genre"));

                stForPhoto = null;
                try {
                    stForPhoto = connection.prepareStatement(SQL_SELECT_PHOTO);
                    stForPhoto.setInt(1, o.getId());

                    resultSetForPhoto = stForPhoto.executeQuery();
                    i = 0;
                    while (resultSetForPhoto.next()) {

                        if (i == 0) {
                            ph.setFirst(true);
                        }
                        ph.setFotoUrl(resultSetForPhoto.getString("foto_url"));
                        if (resultSetForPhoto.getString("foto_info") != null)
                            ph.setFotoInfo(resultSetForPhoto.getString("foto_info"));
                        o.addObjPhoto(ph);
                        i++;
                    }
                    if (i > 0) {
                        ph.setLast(true);
                        o.setObjPhoto(i - 1, ph);
                    }
                    listOfObj.add(o);
                }finally {
                    closeSt(stForPhoto);
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
           closeSt(st);
        }
        return listOfObj;
    }

    @Override
    public ObjPortfolio findEntityById(String id) throws DaoException {
        return null;
    }


    @Override
    public boolean delete(ObjPortfolio entity) {
        return false;
    }

    @Override
    public boolean create(ObjPortfolio entity) {
        return false;
    }

    @Override
    public boolean isEntityById(String id) throws DaoException {
        return false;
    }

    @Override
    public ObjPortfolio update(ObjPortfolio entity) {
        return null;
    }
}
