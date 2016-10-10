package by.training.webapplication.database;

import by.training.webapplication.database.exception.DaoException;
import by.training.webapplication.model.ObjPortfolio;
import by.training.webapplication.model.Photo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static by.training.webapplication.service.command.ActionFactory.LOGGER;

/**
 * Created by Tanya on 05.09.2016.
 */
public class ObjectDAO extends AbstractDAO<String, ObjPortfolio> {
    private final static String SQL_SELECT_OBJECT_INFO =
            "SELECT idPortfolio_obj, object_name, object_info, object_genre,object_name_en, object_info_en\n" +
            "FROM portfolio WHERE object_genre IN (SELECT genre FROM object_types WHERE `type` = \"obj\")";
    private final static String SQL_SELECT_PHOTO =
            "SELECT portfolio_obj_id, foto_url, foto_info FROM foto_obj WHERE portfolio_obj_id=?";
    private final static String SQL_DELETE_OBJECT = "DELETE FROM portfolio WHERE idPortfolio_obj=?";
    private final static String SQL_CREATE_OBJECT = "INSERT INTO portfolio(object_name,object_genre,object_info,object_name_en, object_info_en) VALUES(?,?,?,?,?)";
    private final static String SQL_UPDATE_OBJECT = "UPDATE portfolio SET object_name=?,object_genre=?,object_info=?,object_name_en=?, object_info_en=? WHERE idPortfolio_obj=?";
    private final static String SQL_INSERT_PHOTO = "INSERT INTO foto_obj(portfolio_obj_id, foto_url) VALUES(?, ?)";
    private final static String SQL_SELECT_ID ="SELECT MAX(idPortfolio_obj) AS maxid FROM portfolio";

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
            Photo ph = new Photo();
            int i;
            while (resultSet.next()) {
                o = new ObjPortfolio();
                o.setId(resultSet.getInt("idPortfolio_obj"));
                o.setObjName(resultSet.getString("object_name"));
                o.setObjInfo(resultSet.getString("object_info"));
                o.setObjGenre(resultSet.getString("object_genre"));
                o.setObjNameEn(resultSet.getString("object_name_en"));
                o.setObjInfoEn(resultSet.getString("object_info_en"));
                o.setObjGenreEn(o.getObjGenre());
                stForPhoto = null;
                try {
                    stForPhoto = connection.prepareStatement(SQL_SELECT_PHOTO);
                    stForPhoto.setInt(1, o.getId());
                    resultSetForPhoto = stForPhoto.executeQuery();
                    i = 0;
                    while (resultSetForPhoto.next()) {
                        ph = new Photo();
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
                        //o.setObjPhoto(i - 1, ph);
                    }
                    listOfObj.add(o);
                }finally {
                    closeSt(stForPhoto);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
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
    public boolean delete(String entity) throws DaoException {
        PreparedStatement st = null;
        try{
            st = connection.prepareStatement(SQL_DELETE_OBJECT);
            st.setString(1, entity);
            st.executeUpdate();
            return true;
        }catch (SQLException e){
            LOGGER.error(e);
            throw new DaoException(e);
        }
    }

    @Override
    public boolean create(ObjPortfolio entity) throws DaoException {
        PreparedStatement ps = null;
        PreparedStatement st = null;
        PreparedStatement psForPhoto = null;
        try {
            ps = connection.prepareStatement(SQL_CREATE_OBJECT);
            ps.setString(1,entity.getObjName());
            ps.setString(2,entity.getObjGenre());
            ps.setString(3,entity.getObjInfo());
            ps.setString(4,entity.getObjNameEn());
            ps.setString(5,entity.getObjGenreEn());
            ps.executeUpdate();
            try {
                st = connection.prepareStatement(SQL_SELECT_ID);
                ResultSet resultSet = st.executeQuery();
                resultSet.next();
                int id = resultSet.getInt("maxid");
                for (Photo photo : entity.getObjPhoto()) {
                    try {
                        psForPhoto = connection.prepareStatement(SQL_INSERT_PHOTO);
                        psForPhoto.setInt(1, id);
                        psForPhoto.setString(2, photo.getFotoUrl());
                        psForPhoto.executeUpdate();
                    } finally {
                        closeSt(psForPhoto);
                    }
                }
            }catch (SQLException e){
                LOGGER.error(e);
            }finally {
                closeSt(st);
            }
            return true;
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DaoException(e);
        }finally {
            closeSt(ps);
        }
    }

    @Override
    public boolean isEntityById(String id) throws DaoException {
        return false;
    }

    @Override
    public boolean update(ObjPortfolio entity) throws DaoException {
        PreparedStatement ps = null;
        PreparedStatement psForPhoto = null;
        try {
            ps = connection.prepareStatement(SQL_UPDATE_OBJECT);
            ps.setString(1,entity.getObjName());
            ps.setString(2,entity.getObjGenre());
            ps.setString(3,entity.getObjInfo());
            ps.setString(4,entity.getObjNameEn());
            ps.setString(5,entity.getObjInfoEn());
            ps.setInt(6, entity.getId());
            ps.executeUpdate();
            //st = connection.prepareStatement(SQL_SELECT_ID);
            /*ResultSet resultSet = st.executeQuery();
            resultSet.next();
            int id = resultSet.getInt(entity.getId());*/
            for(Photo photo: entity.getObjPhoto()){
                try {
                    psForPhoto = connection.prepareStatement(SQL_INSERT_PHOTO);
                    psForPhoto.setInt(1,entity.getId());
                    psForPhoto.setString(2, photo.getFotoUrl());
                    psForPhoto.executeUpdate();
                }finally {
                    closeSt(psForPhoto);
                }
            }
            return true;
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new DaoException(e);
        }finally {
            closeSt(ps);
        }
    }
}
