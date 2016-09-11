package by.training.webapplication.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanya on 07.09.2016.
 */
public class ObjPortfolio {
    private int id;
    private String objName;
    private String objGenre;
    private String objInfo;
    private List<Photo> objPhoto = new ArrayList<>();
    private boolean last;
    private boolean first;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public String getObjGenre() {
        return objGenre;
    }

    public void setObjGenre(String objGenre) {
        this.objGenre = objGenre;
    }

    public String getObjInfo() {
        return objInfo;
    }

    public void setObjInfo(String objInfo) {
        this.objInfo = objInfo;
    }

    public List<Photo> getObjPhoto() {
        return objPhoto;
    }

    public void setObjPhoto(List<Photo> objPhoto) {
        this.objPhoto = objPhoto;
    }

    public void addObjPhoto(Photo photo){
        objPhoto.add(photo);
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }
}
