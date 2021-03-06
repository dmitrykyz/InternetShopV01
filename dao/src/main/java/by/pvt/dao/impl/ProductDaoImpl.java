package by.pvt.dao.impl;

import by.pvt.dao.BaseDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.entity.Product;
import by.pvt.util.HibernateSessionFactory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Dmitry on 11/19/2016.
 */
public class ProductDaoImpl extends BaseDao<Product> {
    private static Logger log = Logger.getLogger(ClientDaoImpl.class);

    public ProductDaoImpl() {
    }

    public List<Product> getAll()throws DaoException {
        try {
            Session session = getSession();
            Query query = session.createQuery("from Product P");
            List<Product> list = query.list();
            log.info("Get all rows from Product");
            return list;
        } catch (HibernateException e) {
            log.error("Error Get all rows in ProductDaoImpl" + e);
            throw new DaoException(e);
        }
    }

    public Integer getTotalProductCount()throws DaoException {
        Integer totalProductCount = 0;
        log.info("Get totalProductCount");

        try {
            Session session = HibernateSessionFactory.getSession();

            Query query = session.createQuery("select count(P) from Product P");
            query.setCacheable(true);
            Long totalProduct = (Long) query.uniqueResult();
            totalProductCount = totalProduct != null ? totalProduct.intValue() : null;
            log.info("got totalProductCount!");
        } catch (HibernateException e) {
            log.error("Error get " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return totalProductCount;
    }

    public List<Product> getPartProductPagination(Integer count, Integer startPosition) throws DaoException{
        List<Product>  productList = null;
        try {
            Session session = HibernateSessionFactory.getSession();
            String hql = "from Product ";
            Query query = session.createQuery(hql);
            query.setFirstResult(startPosition);
            query.setMaxResults(count);
            query.setCacheable(true);
            productList = query.list();
        } catch (HibernateException e) {
            log.error("Error get " + " in Dao" + e);
            throw new DaoException(e);
        }
        return productList;
    }
}
