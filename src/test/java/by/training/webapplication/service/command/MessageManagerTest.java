package by.training.webapplication.service.command;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tanya on 11.09.2016.
 */
public class MessageManagerTest {

    @Test
    public void getPropertyTest()  {
        String property = MessageManager.getProperty("message.nullpage");
        assertNotNull(property);
    }

}