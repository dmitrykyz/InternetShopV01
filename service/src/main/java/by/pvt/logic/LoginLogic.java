package by.pvt.logic;

import by.pvt.dao.DaoFactory;
import by.pvt.dao.DaoName;
import by.pvt.dao.IDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.dao.impl.UserDao;
import by.pvt.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class LoginLogic {
    private final static String ADMIN_LOGIN = "admin";
    private final static String ADMIN_PASS = "Qwe123";


    public static void SomeMetod(){
        IDao<User, String> userDao = DaoFactory.getInstance().getDao(DaoName.USER);
        try {
            User adminlogin = userDao.get("admin");
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }


    public static boolean checkLogin(String enterLogin, String enterPass) {
        return ADMIN_LOGIN.equals(enterLogin) &&
                ADMIN_PASS.equals(enterPass);
    }
}
