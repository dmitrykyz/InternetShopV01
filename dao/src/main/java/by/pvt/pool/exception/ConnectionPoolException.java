package by.pvt.pool.exception;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class ConnectionPoolException extends Exception {

    public ConnectionPoolException(String message, Exception e) {
        super(message, e);
    }
}
