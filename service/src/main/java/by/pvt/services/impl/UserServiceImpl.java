package by.pvt.services.impl;

import by.pvt.dao.AbstractDAO;
import by.pvt.dao.DaoFactory;
import by.pvt.dao.DaoName;
import by.pvt.dao.impl.UserDaoImpl;
import by.pvt.entity.User;
import by.pvt.services.AbstractService;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Dmitry on 10/25/2016.
 */
public class UserServiceImpl extends AbstractService<Integer, User> {

    private static Logger log = Logger.getLogger(UserServiceImpl.class);

    public UserServiceImpl() {
    }

    public User getUserByLogin(String login){
        log.info("Getting object User in class UserServiceImpl in metod getUserByLogin by login: " + login);
        UserDaoImpl userDao1 = new UserDaoImpl();
        return userDao1.getUserByLogin(login);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public boolean create(User entity) {
        log.info("Create new User in class UserServiceImpl");
        AbstractDAO<Integer, User> userDao = DaoFactory.getInstance().getDao(DaoName.USER);
        if (userDao.create(entity) == true) return true;
        else return false;
    }

    @Override
    public User update(User entity) {
        return null;
    }
}
