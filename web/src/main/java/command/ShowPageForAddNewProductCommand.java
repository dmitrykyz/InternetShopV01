package command;

import org.apache.log4j.Logger;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dmitry on 10/26/2016.
 */
public class ShowPageForAddNewProductCommand implements ActionCommand  {
    private static Logger log = Logger.getLogger(ShowPageForAddNewProductCommand.class);
    public String execute(HttpServletRequest request) {
        String page = null;
        log.info("Command ShowPageForAddNewProduct");
        page = ConfigurationManager.getProperty("path.page.addnewproduct");
        return page;
    }
}
