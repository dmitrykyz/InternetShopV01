package command;

import by.pvt.services.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dmitry on 10/23/2016.
 */
public interface ActionCommand {
    String execute(HttpServletRequest request) throws ServiceException;
}
