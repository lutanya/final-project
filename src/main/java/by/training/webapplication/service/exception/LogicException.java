package by.training.webapplication.service.exception;

/**
 * Created by Tanya on 25.07.2016.
 */
public class LogicException extends Exception{
    public LogicException() {
        super();
    }

    public LogicException(String message) {
        super(message);
    }

    public LogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogicException(Throwable cause) {
        super(cause);
    }
}
