package by.training.webapplication.model;

/**
 * Created by Tanya on 08.09.2016.
 */
public class Order {
    private String kindOfWork;
    private float squareOfObj;
    private float stage;
    private float reductionOfTerms;
    private boolean overhaul;
    private float typeOfProject;
    private float priceFoKindOfProject;
    private String title;
    private int done;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getKindOfWork() {
        return kindOfWork;
    }

    public void setKindOfWork(String kindOfWork) {
        this.kindOfWork = kindOfWork;
    }

    public float getSquareOfObj() {
        return squareOfObj;
    }

    public void setSquareOfObj(float squareOfObj) {
        this.squareOfObj = squareOfObj;
    }

    public float getStage() {
        return stage;
    }

    public void setStage(byte stage) {
        this.stage = stage;
    }

    public float getReductionOfTerms() {
        return reductionOfTerms;
    }

    public void setReductionOfTerms(float reductionOfTerms) {
        this.reductionOfTerms = reductionOfTerms;
    }

    public boolean isOverhaul() {
        return overhaul;
    }

    public void setOverhaul(boolean overhaul) {
        this.overhaul = overhaul;
    }

    public float getTypeOfProject() {
        return typeOfProject;
    }

    public void setTypeOfProject(float typeOfProjec) {
        this.typeOfProject = typeOfProjec;
    }

    public float getPriceFoKindOfProject() {
        return priceFoKindOfProject;
    }

    public void setPriceFoKindOfProject(float priseFoKindOfProject) {
        this.priceFoKindOfProject = priseFoKindOfProject;
    }

    public void setStage(float stage) {
        this.stage = stage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }
}
