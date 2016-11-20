package by.pvt.logic;

import by.pvt.entity.User;
import by.pvt.services.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class LoginLogic {
    private static Logger log = Logger.getLogger(LoginLogic.class);
    private static String ADMIN_LOGIN = "";
    private static String ADMIN_PASS = "";
    private static int USER_TYPE = 0;
    private static int IN_BLACK_LIST = 0;


    public static boolean checkLogin(String enterLogin, String enterPass) {
        log.info("Checking Login in class LoginLogic");

         UserServiceImpl userService = new UserServiceImpl();
         List<User> users = (List<User>)userService.getUserByLogin(enterLogin);
        for (User u: users) {
            System.out.println(u);
        }
//
//        ADMIN_LOGIN = user.getLogin();
//        ADMIN_PASS = user.getPassword();
//        USER_TYPE = user.getUserType();
//        //IN_BLACK_LIST = user.getInBlackList();
//
//        if (ADMIN_LOGIN == null || ADMIN_PASS == null) return false;
//        return ADMIN_LOGIN.equals(enterLogin) &&
//                ADMIN_PASS.equals(enterPass);
        return true;
    }

    public static int getUserType() {
        return USER_TYPE;
    }

    public static int getInBlackList() {
        return IN_BLACK_LIST;
    }

    public static String getAdminLogin() {
        return ADMIN_LOGIN;
    }
}
