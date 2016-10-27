package command;

import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class EmptyCommand implements ActionCommand {

    public String execute(HttpServletRequest request) {
/* if the mistake did or you go directly to the controller
* there will redirect to the login page */
        String page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}
