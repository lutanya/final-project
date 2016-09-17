package by.training.webapplication.model;

/**
 * Created by Tanya on 05.09.2016.
 */
public class Photo {

    private String fotoUrl;
    private String fotoInfo;
    private boolean last;
    private boolean first;


    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public String getFotoInfo() {
        return fotoInfo;
    }

    public void setFotoInfo(String fotoInfo) {
        this.fotoInfo = fotoInfo;
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
