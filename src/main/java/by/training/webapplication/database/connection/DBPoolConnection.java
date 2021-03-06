package by.training.webapplication.database.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

import static by.training.webapplication.service.command.ActionFactory.LOGGER;

/**
 * Created by Tanya on 24.07.2016.
 */
public class DBPoolConnection {
    private static final int MAX_CONNECTIONS = 5;
    private static DBPoolConnection pool;
    private static AtomicBoolean instanceCreated = new AtomicBoolean();
    private static ReentrantLock lock = new ReentrantLock();
    private BlockingQueue<Connection> connections = new ArrayBlockingQueue<Connection>(MAX_CONNECTIONS);

    private DBPoolConnection() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = getClass().getClassLoader().getResourceAsStream("application.properties");
            prop.load(input);
        } catch (IOException e) {
            LOGGER.error(e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    LOGGER.error(e);
                }
            }
        }
        Connection cn = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            LOGGER.error("DB connection error: " + e);
        }
        String url = prop.getProperty("database.url");
        String password = prop.getProperty("database.password");
        String user = prop.getProperty("database.user");
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            try {
                cn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            connections.add(new ProxyConnection(cn));
        }
    }

    public static DBPoolConnection initConnectionPool() {
        if (!instanceCreated.get()) {
            lock.lock();
            try {
                if (!instanceCreated.get()) {
                    pool = new DBPoolConnection();
                    instanceCreated.getAndSet(true);

                }
            } catch (Exception e) {
                LOGGER.error(e);
            } finally {
                lock.unlock();
            }
        }
        return pool;
    }

    public Connection getConnection() throws SQLException {
        try {
            return connections.take();
        } catch (InterruptedException e) {
            LOGGER.error(e);
            return null;
        }
    }

    public void putConnection(Connection connection) throws SQLException {
        connections.add(connection);
    }

    public void closeDBPoolConnection() {
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            try {
                ProxyConnection cn = (ProxyConnection) connections.take();
                cn.closeProxyConnection();
            } catch (SQLException e) {
                LOGGER.error(e);
            } catch (InterruptedException e) {
                LOGGER.error(e);
            }
        }
    }
}
