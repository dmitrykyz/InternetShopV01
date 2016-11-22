package by.pvt.services.impl;

import by.pvt.dao.Dao;
import by.pvt.dao.DaoFactory;
import by.pvt.dao.DaoName;
import by.pvt.dao.exception.DaoException;
import by.pvt.dao.impl.ProductDaoImpl;
import by.pvt.entity.Product;
import by.pvt.services.BaseService;
import by.pvt.services.exception.ServiceException;
import by.pvt.util.HibernateSessionFactory;
import by.pvt.vo.ProductVOforPagination;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitry on 11/20/2016.
 */
public class ProductServiceImpl extends BaseService<Product> {

    private Transaction transaction = null;

    public ProductServiceImpl() {
    }

    @Override
    public Product get(Serializable id) throws ServiceException {
        Dao baseDao = DaoFactory.getInstance().getDao(DaoName.PRODUCT);
        Session session = getSession();
        transaction = session.beginTransaction();
        Product product = null;
        try {
            product = (Product) baseDao.get(id);
            transaction.commit();
            closeSession();
        } catch (DaoException e) {
            transaction.rollback();
            closeSession();
        }
        return product;
    }

    @Override
    public Product load(Serializable id) throws ServiceException {
        Dao baseDao = DaoFactory.getInstance().getDao(DaoName.PRODUCT);
        Session session = getSession();
        transaction = session.beginTransaction();
        Product product = null;
        try {
            product = (Product) baseDao.load(id);
            transaction.commit();
            closeSession();
        } catch (DaoException e) {
            transaction.rollback();
            closeSession();
        }
        return product;
    }

    @Override
    public List<Product> getAll() throws ServiceException {
        ProductDaoImpl productDao = new ProductDaoImpl();
        Session session = getSession();
        transaction = session.beginTransaction();
        List<Product> tList = null;
        try {
            tList = productDao.getAll();
            transaction.commit();
            closeSession();
        } catch (DaoException e) {
            transaction.rollback();
            closeSession();
        }
        return tList;
    }

    public ProductVOforPagination paginationProducts(String page, Integer countPerPage) throws ServiceException {

        ProductVOforPagination productVOforPagination = new ProductVOforPagination();

        Integer newPage = page != null ? Integer.valueOf(page) : 1;
        List<Product> productList = null;
        Integer totalUsersCount =0;

        ProductDaoImpl productDao = (ProductDaoImpl) DaoFactory.getInstance().getDao(DaoName.PRODUCT);

        try {
            Session session = HibernateSessionFactory.getSession();
            transaction = session.beginTransaction();
            totalUsersCount = productDao.getTotalProductCount();
            Integer first = countPerPage*(newPage-1);
            productList = productDao.getPartProductPagination(countPerPage,first);
            transaction.commit();
            HibernateSessionFactory.closeSession();
        } catch (DaoException e) {
            transaction.rollback();
            HibernateSessionFactory.closeSession();
            e.printStackTrace();
        }

        productVOforPagination.setPage(String.valueOf(newPage));
        productVOforPagination.setTotalProductCount(totalUsersCount);
        productVOforPagination.setProductList(productList);

        return productVOforPagination;
    }

}
