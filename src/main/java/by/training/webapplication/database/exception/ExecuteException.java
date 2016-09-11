package by.training.webapplication.database.exception;

/**
 * Created by Tanya on 05.09.2016.
 */
public class ExecuteException extends Exception {
    public ExecuteException() {
        super();
    }

    public ExecuteException(String message) {
        super(message);
    }

    public ExecuteException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExecuteException(Throwable cause) {
        super(cause);
    }

    protected ExecuteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
