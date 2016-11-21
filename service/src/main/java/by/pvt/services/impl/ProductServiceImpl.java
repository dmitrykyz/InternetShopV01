package by.pvt.services.impl;

import by.pvt.dao.BaseDao;
import by.pvt.dao.Dao;
import by.pvt.dao.DaoFactory;
import by.pvt.dao.DaoName;
import by.pvt.dao.exception.DaoException;
import by.pvt.dao.impl.ProductDaoImpl;
import by.pvt.entity.Product;
import by.pvt.services.BaseService;
import by.pvt.services.IService;
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
public class ProductServiceImpl extends BaseService<Product> {

    Transaction transaction = null;

    public ProductServiceImpl() {
    }

    @Override
    public Product get(Serializable id) throws ServiceException {
        Dao baseDao = DaoFactory.getInstance().getDao(DaoName.PRODUCT);
        ServiceUtilForHibernate serviceUtilForHibernate = ServiceUtilForHibernate.getInstance();
        serviceUtilForHibernate.setUtil(HibernateUtil.getHibernateUtil());
        Session session = serviceUtilForHibernate.getUtil().getSession();
        transaction = session.beginTransaction();
        Product product = null;
        try {
            product = (Product) baseDao.get(id);
            transaction.commit();
            serviceUtilForHibernate.setUtil(null);
        } catch (DaoException e) {
            serviceUtilForHibernate.setUtil(null);
            transaction.rollback();
        }
        return product;
    }

    @Override
    public Product load(Serializable id) throws ServiceException {
        Dao baseDao = DaoFactory.getInstance().getDao(DaoName.PRODUCT);
        ServiceUtilForHibernate serviceUtilForHibernate = ServiceUtilForHibernate.getInstance();
        serviceUtilForHibernate.setUtil(HibernateUtil.getHibernateUtil());
        Session session = serviceUtilForHibernate.getUtil().getSession();
        transaction = session.beginTransaction();
        Product product = null;
        try {
            product = (Product) baseDao.load(id);
            transaction.commit();
            serviceUtilForHibernate.setUtil(null);
        } catch (DaoException e) {
            serviceUtilForHibernate.setUtil(null);
            transaction.rollback();
        }
        return product;
    }

    @Override
    public List<Product> getAll() throws ServiceException {
        ProductDaoImpl productDao = new ProductDaoImpl();
        ServiceUtilForHibernate serviceUtilForHibernate = ServiceUtilForHibernate.getInstance();
        serviceUtilForHibernate.setUtil(HibernateUtil.getHibernateUtil());
        Session session = serviceUtilForHibernate.getUtil().getSession();
        transaction = session.beginTransaction();
        List<Product> tList = null;
        try {
            tList = productDao.getAll();
            transaction.commit();
            serviceUtilForHibernate.setUtil(null);
        } catch (DaoException e) {
            serviceUtilForHibernate.setUtil(null);
            transaction.rollback();
        }
        return tList;
    }
}
