package by.training.webapplication.service.command.manager;

import java.util.ResourceBundle;

/**
 * Created by Tanya on 20.07.2016.
 */
public class ConfigurationManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
    private ConfigurationManager(){ }
    public static String getProperty(String key){
        return resourceBundle.getString(key);
    }
}
