package by.training.webapplication.service.command;

import by.training.webapplication.service.command.manager.MessageManager;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tanya on 11.09.2016.
 */
public class MessageManagerTest {

    @Test
    public void getPropertyTest()  {
        String property = new MessageManager().getProperty("message.nullpage");
        assertNotNull(property);
    }

}