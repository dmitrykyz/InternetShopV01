package command;

import org.apache.log4j.Logger;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dmitry on 10/26/2016.
 */
public class ReturnToLoginCommand  implements ActionCommand  {
    private static Logger log = Logger.getLogger(ReturnToLoginCommand.class);
    public String execute(HttpServletRequest request) {
        String page = null;
        log.info("Return To Login.jsp in class ReturnToLoginCommand ");
        page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}
