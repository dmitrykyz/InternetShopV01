package command;

import by.pvt.entity.User;
import by.pvt.services.AbstractService;
import by.pvt.services.ServiceFactory;
import by.pvt.services.ServiceName;
import org.apache.log4j.Logger;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dmitry on 10/26/2016.
 */
public class AddNewClientCommand implements ActionCommand  {
    private static Logger log = Logger.getLogger(AddNewClientCommand.class);

    public String execute(HttpServletRequest request) {
        String page = null;
//        User user = new User();
//        user.setLogin((String)request.getParameter("login"));
//        user.setPassword((String)request.getParameter("password"));
//        user.setFirstName((String)request.getParameter("firstname"));
//        user.setLastName((String)request.getParameter("laststname"));
//        user.setUserType(0);
//        user.setInBlackList(0);
//
//        log.info("Add new client Command with login: " + user.getLogin());
//
//        AbstractService userService = ServiceFactory.getInstance().getService(ServiceName.USER);
//        if (userService.create(user) == true) {
//            page = ConfigurationManager.getProperty("path.page.confirmationOfRegistration");
//        }

        return page;
    }
}
