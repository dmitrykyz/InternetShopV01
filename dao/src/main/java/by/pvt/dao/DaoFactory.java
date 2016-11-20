package by.pvt.dao;

import by.pvt.dao.impl.ProductDaoImpl;
import by.pvt.dao.impl.UserDaoImpl;

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
        daos.put(DaoName.USER, new UserDaoImpl());
        daos.put(DaoName.PRODUCT, new ProductDaoImpl());
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
