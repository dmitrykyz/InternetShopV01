package by.pvt.services.impl;

import by.pvt.dao.exception.DaoException;
import by.pvt.dao.impl.AdminDaoImpl;
import by.pvt.entity.Admin;
import by.pvt.services.BaseService;
import by.pvt.services.exception.ServiceException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitry on 11/20/2016.
 */
public class AdminServiceImpl extends BaseService<Admin> {
    private static Logger log = Logger.getLogger(AdminServiceImpl.class);

    private Transaction transaction = null;

    public AdminServiceImpl() {
    }

    @Override
    public Admin get(Serializable id) throws ServiceException {
        return null;
    }

    @Override
    public Admin load(Serializable id) throws ServiceException {
        return null;
    }

    @Override
    public List<Admin> getAll() throws ServiceException {
        return null;
    }

    public List<Admin> getAdminByLogin(String login) {

        Session session = getSession();
        transaction = session.beginTransaction();

        log.info("Getting object User in class AdminServiceImpl in metod getAdminByLogin by login: " + login);
        AdminDaoImpl adminDao = new AdminDaoImpl();
        try {
            List<Admin> users = adminDao.getAdminByLogin(login);
            transaction.commit();
            closeSession();
            return users;
        } catch (DaoException e) {
            e.printStackTrace();
            transaction.rollback();
            closeSession();
            return null;
        }

    }
}
