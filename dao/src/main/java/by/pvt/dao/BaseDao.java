package by.pvt.dao;

import by.pvt.dao.Dao;
import by.pvt.dao.exception.DaoException;
import by.pvt.util.HibernateUtil;
import by.pvt.util.ServiceUtilForHibernate;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDao<T> implements Dao<T> {
    private static Logger log = Logger.getLogger(BaseDao.class);


    public BaseDao() {

    }

    public void saveOrUpdate(T t) throws DaoException {
        try {
            Session session = ServiceUtilForHibernate.getInstance().getUtil().getSession();
            session.saveOrUpdate(t);
            log.info("saveOrUpdate(t):" + t);
            log.info("Save or update (commit):" + t);
        } catch (HibernateException e) {
            log.error("Error save or update PERSON in Dao" + e);
            throw new DaoException(e);
        }

    }

    public T get(Serializable id) throws DaoException {
        log.info("Get class by id:" + id);
        T t = null;
        try {
            Session session = ServiceUtilForHibernate.getInstance().getUtil().getSession();
            t = (T) session.get(getPersistentClass(), id);
            System.out.println("isDirty before commit = "+ session.isDirty());
            System.out.println("isDirty after commit = "+ session.isDirty());
            log.info("get class:" + t);
        } catch (HibernateException e) {
            log.error("Error get " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return t;
    }

    public T load(Serializable id) throws DaoException {
        log.info("Load class by id:" + id);
        T t = null;
        try {
            Session session = ServiceUtilForHibernate.getInstance().getUtil().getSession();
            t = (T) session.load(getPersistentClass(), id);
            System.out.println("isDirty before commit = "+ session.isDirty());
            log.info("load() class:" + t);
            System.out.println("isDirty after commit = "+ session.isDirty());
        } catch (HibernateException e) {
            log.error("Error load() " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return t;
    }

    public void delete(T t) throws DaoException {
        try {
            Session session = ServiceUtilForHibernate.getInstance().getUtil().getSession();
            session.delete(t);
            log.info("Delete:" + t);
        } catch (HibernateException e) {
            log.error("Error save or update PERSON in Dao" + e);
            throw new DaoException(e);
        }
    }


    private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}