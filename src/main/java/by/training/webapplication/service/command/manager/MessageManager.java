package by.training.webapplication.service.command.manager;

import java.util.ResourceBundle;

/**
 * Created by Tanya on 20.07.2016.
 */
public class MessageManager {

    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    public MessageManager(){}

    public String getProperty(String key){
        return resourceBundle.getString(key);
    }
}
