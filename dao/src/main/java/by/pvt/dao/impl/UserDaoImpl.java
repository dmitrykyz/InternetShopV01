package by.pvt.dao.impl;

import by.pvt.dao.BaseDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.entity.User;
import by.pvt.util.HibernateUtil;
import by.pvt.util.ServiceUtilForHibernate;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Dmitry on 11/19/2016.
 */
public class UserDaoImpl extends BaseDao<User> {

    private static Logger log = Logger.getLogger(UserDaoImpl.class);
    //private HibernateUtil util = HibernateUtil.getHibernateUtil();
    //private Transaction transaction = null;

    public UserDaoImpl() {
    }

    public List<User> getUserByLogin(String login) throws DaoException {
        List<User> users = null;

        try {
            Session session = ServiceUtilForHibernate.getInstance().getUtil().getSession();
            String hql = "SELECT C FROM Client C WHERE C.login like:loginParam";
            Query query = session.createQuery(hql);
            query.setParameter("loginParam", login);
            users = query.list();
            log.info("getUserByLogin() List<User> by :" + login);
        } catch (HibernateException e) {
            log.error("Error getUserByLogin() List<User> by :" + login + " in Dao" + e);
            throw new DaoException(e);
        }

        return users;
    }
}
