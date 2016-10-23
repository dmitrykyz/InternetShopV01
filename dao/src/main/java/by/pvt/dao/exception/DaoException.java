package by.pvt.dao.exception;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class DaoException extends Exception{
    public DaoException(String message, Exception exception) {
        super(message, exception);
    }

    public DaoException(Exception exeption) {
        super(exeption);
    }
}
