package by.pvt.dao;

import by.pvt.dao.impl.ProductDao;
import by.pvt.dao.impl.UserDao;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class DaoFactory {
    private static volatile DaoFactory instance = null;

    private Map<DaoName, IDao> daos = null;

    private DaoFactory() {
        daos = new HashMap<DaoName, IDao>();
        daos.put(DaoName.USER, new UserDao());
        daos.put(DaoName.PRODUCT, new ProductDao());
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

    public IDao getDao(DaoName daoName) {
        return daos.get(daoName);
    }
}
