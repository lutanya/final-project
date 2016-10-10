package by.training.webapplication.service.command.manager;

import java.util.ResourceBundle;

/**
 * Created by Tanya on 20.07.2016.
 */
public class MessageManager {

    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
    private final static ResourceBundle resourceBundleUS = ResourceBundle.getBundle("message_en_US");

    public MessageManager(){}

    public String getProperty(String key, String local){
        if(local.equals("ru_RU")) {
            return resourceBundle.getString(key);
        }else{
            return resourceBundleUS.getString(key);
        }
    }
}
