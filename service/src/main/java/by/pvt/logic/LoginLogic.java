package by.pvt.logic;

import by.pvt.entity.User;
import by.pvt.services.impl.UserServiceImpl;
import org.apache.log4j.Logger;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class LoginLogic {
    private static Logger log = Logger.getLogger(LoginLogic.class);
    private static String ADMIN_LOGIN = "";
    private static String ADMIN_PASS = "";


    public static boolean checkLogin(String enterLogin, String enterPass) {
        log.info("Checking Login in class LoginLogic");

        UserServiceImpl userService = new UserServiceImpl();
        User user = (User) userService.getUserByLogin(enterLogin);

        ADMIN_LOGIN = user.getLogin();
        ADMIN_PASS = user.getPassword();
        return ADMIN_LOGIN.equals(enterLogin) &&
                ADMIN_PASS.equals(enterPass);
    }
}
