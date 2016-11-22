package by.pvt.services;

import by.pvt.dao.BaseDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.services.exception.ServiceException;
import by.pvt.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitry on 11/20/2016.
 */
public abstract class BaseService<T> implements IService<T> {

    private Transaction transaction = null;

    public BaseService() {
    }

    protected Session getSession(){
        return HibernateSessionFactory.getSession();
    }

    protected void closeSession(){
        HibernateSessionFactory.closeSession();
    }

    @Override
    public boolean saveOrUpdate(T t) throws ServiceException {
        BaseDao<T> baseDao = new BaseDao<T>();
        Session session = getSession();
        transaction = session.beginTransaction();
        try {
            baseDao.saveOrUpdate(t);
            transaction.commit();
            closeSession();
            return true;
        } catch (DaoException e) {
            transaction.rollback();
            closeSession();
            return false;
        }
    }

    @Override
    public abstract T get(Serializable id) throws ServiceException;

    @Override
    public abstract T load(Serializable id) throws ServiceException;

    @Override
    public boolean delete(T t) throws ServiceException {
        BaseDao<T> baseDao = new BaseDao<T>();
        Session session = getSession();
        transaction = session.beginTransaction();
        try {
            baseDao.delete(t);
            transaction.commit();
            closeSession();
            return true;
        } catch (DaoException e) {
            transaction.rollback();
            closeSession();
            return false;
        }
    }

    @Override
    public abstract List<T> getAll() throws ServiceException;
}
