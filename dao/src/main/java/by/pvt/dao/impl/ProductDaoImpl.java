package by.pvt.dao.impl;

import by.pvt.dao.BaseDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.entity.Product;
import by.pvt.util.ServiceUtilForHibernate;
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
            Session session = ServiceUtilForHibernate.getInstance().getUtil().getSession();
            Query query = session.createQuery("from Product P");
            List<Product> list = query.list();
            log.info("Get all rows from Product");
            return list;
        } catch (HibernateException e) {
            log.error("Error Get all rows in ProductDaoImpl" + e);
            throw new DaoException(e);
        }
    }
}
