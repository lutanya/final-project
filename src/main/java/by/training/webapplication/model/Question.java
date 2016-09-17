package by.training.webapplication.model;

/**
 * Created by Tanya on 14.09.2016.
 */
public class Question {
    private String questionerName;
    private String backEmail;
    private String questionText;
    private boolean response;

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

    public boolean isResponce() {
        return response;
    }

    public void setResponce(boolean responce) {
        this.response = responce;
    }
}
