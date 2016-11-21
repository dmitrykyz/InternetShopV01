package by.pvt.services.impl;

import by.pvt.dao.BaseDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.dao.impl.AdminDaoImpl;
import by.pvt.entity.Admin;
import by.pvt.services.BaseService;
import by.pvt.util.HibernateUtil;
import by.pvt.util.ServiceUtilForHibernate;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Dmitry on 11/20/2016.
 */
public class AdminServiceImpl extends BaseService<Admin> {
    private static Logger log = Logger.getLogger(AdminServiceImpl.class);

    public AdminServiceImpl() {
    }

    public List<Admin> getAdminByLogin(String login) {

        ServiceUtilForHibernate serviceUtilForHibernate = ServiceUtilForHibernate.getInstance();
        serviceUtilForHibernate.setUtil(HibernateUtil.getHibernateUtil());
        Session session = serviceUtilForHibernate.getUtil().getSession();
        Transaction transaction = session.beginTransaction();

        log.info("Getting object User in class AdminServiceImpl in metod getAdminByLogin by login: " + login);
        AdminDaoImpl adminDao = new AdminDaoImpl();
        try {
            List<Admin> users = adminDao.getAdminByLogin(login);
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
