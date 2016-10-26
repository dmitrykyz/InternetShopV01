package command;

import by.pvt.services.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dmitry on 10/26/2016.
 */
public class SignupCommand implements ActionCommand  {
    private static Logger log = Logger.getLogger(SignupCommand.class);
    public String execute(HttpServletRequest request) {
        String page = null;
        log.info("Command Signup");
        page = ConfigurationManager.getProperty("path.page.signup");
        return page;
    }
}
