package by.pvt;

import by.pvt.dao.exception.DaoException;
import by.pvt.dao.impl.ProductDaoImpl;
import by.pvt.entity.Product;
import junit.framework.TestCase;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Test;

import java.io.Serializable;

/**
 * Created by Dmitry on 11/22/2016.
 */
public class ProductDaoTest extends TestCase {

    @Test
    public void testGetProductById(){
        ProductDaoImpl productDao = new ProductDaoImpl();
        Product product = new Product();
        product.setIdProduct(9);
        product.setNameProduct("Vodka");
        product.setPrice(5.0);
        product.setStatus(1);

        try {
            productDao.saveOrUpdate(product);
            assertNotNull(productDao.get(9));
            assertEquals(productDao.get(9), product);
            assertNull(productDao.get(10));
        } catch (DaoException e) {
            e.printStackTrace();
        }


    }
}
