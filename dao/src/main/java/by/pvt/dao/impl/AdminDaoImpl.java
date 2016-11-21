package by.pvt.dao.impl;

import by.pvt.dao.BaseDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.entity.Admin;
import by.pvt.util.ServiceUtilForHibernate;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Dmitry on 11/20/2016.
 */
public class AdminDaoImpl extends BaseDao<Admin> {

    private static Logger log = Logger.getLogger(ClientDaoImpl.class);

    public AdminDaoImpl() {
    }

    public List<Admin> getAdminByLogin(String login) throws DaoException {
        List<Admin> admins = null;

        try {
            Session session = ServiceUtilForHibernate.getInstance().getUtil().getSession();
            String hql = "SELECT A FROM Admin A WHERE A.login=:loginParam";
            Query query = session.createQuery(hql);
            query.setParameter("loginParam", login);
            admins = query.list();
            log.info("getClientByLogin() List<User> by :" + login);
        } catch (HibernateException e) {
            log.error("Error getClientByLogin() List<User> by :" + login + " in Dao" + e);
            throw new DaoException(e);
        }

        return admins;
    }
}

