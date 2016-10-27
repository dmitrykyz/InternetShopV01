package command;

import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class LogoutCommand implements ActionCommand {

    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index");
//session destruction
        request.getSession().invalidate();
        return page;
    }
}
