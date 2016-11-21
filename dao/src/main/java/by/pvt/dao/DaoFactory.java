package by.pvt.dao;

import by.pvt.dao.impl.OrderDaoImpl;
import by.pvt.dao.impl.ProductDaoImpl;
import by.pvt.dao.impl.ClientDaoImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class DaoFactory {
    private static volatile DaoFactory instance = null;

    private Map<DaoName, BaseDao> daos = null;

    private DaoFactory() {
        daos = new HashMap<DaoName, BaseDao>();
        daos.put(DaoName.CLIENT, new ClientDaoImpl());
        daos.put(DaoName.PRODUCT, new ProductDaoImpl());
        daos.put(DaoName.ORDER, new OrderDaoImpl());
    }

    public static DaoFactory getInstance() {
        if (instance == null) {
            synchronized (DaoFactory.class) {
                if (instance == null) {
                    instance = new DaoFactory();
                } else {
                    return instance;
                }
            }
        }

        return instance;
    }

    public BaseDao getDao(DaoName daoName) {
        return daos.get(daoName);
    }
}
