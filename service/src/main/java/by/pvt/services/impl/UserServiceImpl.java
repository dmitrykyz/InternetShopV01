package by.pvt.services.impl;

import by.pvt.dao.exception.DaoException;
import by.pvt.dao.impl.UserDaoImpl;
import by.pvt.entity.User;
import by.pvt.services.AbstractService;
import by.pvt.util.HibernateUtil;
import by.pvt.util.ServiceUtilForHibernate;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Dmitry on 11/19/2016.
 */
public class UserServiceImpl extends AbstractService<Integer, User> {

    private static Logger log = Logger.getLogger(UserServiceImpl.class);

    public UserServiceImpl() {
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
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public boolean create(User entity) {
        return false;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    public List<User> getUserByLogin(String login) {

        ServiceUtilForHibernate serviceUtilForHibernate = ServiceUtilForHibernate.getInstance();
        serviceUtilForHibernate.setUtil(HibernateUtil.getHibernateUtil());
        Session session = serviceUtilForHibernate.getUtil().getSession();
        Transaction transaction = session.beginTransaction();

        log.info("Getting object User in class UserServiceImpl in metod getUserByLogin by login: " + login);
        UserDaoImpl userDao1 = new UserDaoImpl();
        try {
            List<User> users = userDao1.getUserByLogin(login);
            transaction.commit();
            serviceUtilForHibernate.setUtil(null);
            return users;
        } catch (DaoException e) {
            e.printStackTrace();
            transaction.rollback();
            serviceUtilForHibernate.setUtil(null);
            return null;
        }

    }
}
