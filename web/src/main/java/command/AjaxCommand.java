package command;

import by.pvt.services.exception.ServiceException;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dmitry on 12/4/2016.
 */
public class AjaxCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) throws ServiceException {
        String page = null;
        String someText = request.getParameter("someText");
        String someTextRezult = someText + " Add text";
        request.setAttribute("someTextRezult", someTextRezult);
        page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}
