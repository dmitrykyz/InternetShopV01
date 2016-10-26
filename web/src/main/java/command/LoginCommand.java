package command;

import by.pvt.entity.User;
import by.pvt.services.AbstractService;
import by.pvt.services.IService;
import by.pvt.services.ServiceFactory;
import by.pvt.services.ServiceName;
import by.pvt.services.exception.ServiceException;
import by.pvt.services.impl.UserServiceImpl;
import command.ActionCommand;
import by.pvt.logic.LoginLogic;
import resource.ConfigurationManager;
import resource.MessageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    public String execute(HttpServletRequest request) {
        String page = null;
// извлечение из запроса логина и пароля
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
// проверка логина и пароля
        if (LoginLogic.checkLogin(login, pass)) {
            request.setAttribute("user", login);
// определение пути к mainByer.jsp или к mainAdmin.jsp
            if (LoginLogic.getUserType() == 0){
                page = ConfigurationManager.getProperty("path.page.mainByer");
            } else if (LoginLogic.getUserType() == 1){
                page = ConfigurationManager.getProperty("path.page.mainAdmin");
            }

        } else {
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
