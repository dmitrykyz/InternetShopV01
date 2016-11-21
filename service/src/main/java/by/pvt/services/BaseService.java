package by.pvt.services;

import by.pvt.dao.BaseDao;
import by.pvt.dao.Dao;
import by.pvt.dao.DaoFactory;
import by.pvt.dao.DaoName;
import by.pvt.dao.exception.DaoException;
import by.pvt.services.exception.ServiceException;
import by.pvt.util.HibernateUtil;
import by.pvt.util.ServiceUtilForHibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitry on 11/20/2016.
 */
public class BaseService<T> implements IService<T> {

    Transaction transaction = null;

    public BaseService() {
    }

    @Override
    public boolean saveOrUpdate(T t) throws ServiceException {
        BaseDao<T> baseDao = new BaseDao<T>();
        ServiceUtilForHibernate serviceUtilForHibernate = ServiceUtilForHibernate.getInstance();
        serviceUtilForHibernate.setUtil(HibernateUtil.getHibernateUtil());
        Session session = serviceUtilForHibernate.getUtil().getSession();
        transaction = session.beginTransaction();
        try {
            baseDao.saveOrUpdate(t);
            transaction.commit();
            serviceUtilForHibernate.setUtil(null);
            return true;
        } catch (DaoException e) {
            serviceUtilForHibernate.setUtil(null);
            transaction.rollback();
            return false;
        }
    }

    @Override
    public T get(Serializable id) throws ServiceException {
        return null;
    }

    @Override
    public T load(Serializable id) throws ServiceException {
        return null;
    }

    @Override
    public boolean delete(T t) throws ServiceException {
        BaseDao<T> baseDao = new BaseDao<T>();
        ServiceUtilForHibernate serviceUtilForHibernate = ServiceUtilForHibernate.getInstance();
        serviceUtilForHibernate.setUtil(HibernateUtil.getHibernateUtil());
        Session session = serviceUtilForHibernate.getUtil().getSession();
        transaction = session.beginTransaction();
        try {
            baseDao.delete(t);
            transaction.commit();
            serviceUtilForHibernate.setUtil(null);
            return true;
        } catch (DaoException e) {
            serviceUtilForHibernate.setUtil(null);
            transaction.rollback();
            return false;
        }
    }

    @Override
    public List<T> getAll() throws ServiceException {
        return null;
    }
}
