package by.training.webapplication.model;

/**
 * Created by Tanya on 14.09.2016.
 */
public class Question {
    private  int questionId;
    private String questionerName;
    private String backEmail;
    private String questionText;
    private int replied;

    public String getQuestionerName() {
        return questionerName;
    }

    public void setQuestionerName(String questionerName) {
        this.questionerName = questionerName;
    }

    public String getBackEmail() {
        return backEmail;
    }

    public void setBackEmail(String backEmail) {
        this.backEmail = backEmail;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getReplied() {
        return replied;

    }

    public void setReplied(int replied) {
        this.replied = replied;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
