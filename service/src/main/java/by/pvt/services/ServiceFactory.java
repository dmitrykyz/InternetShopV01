package by.pvt.services;

import by.pvt.services.impl.ProductServiceImpl;
import by.pvt.services.impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class ServiceFactory {
    private static volatile ServiceFactory instance = null;

    private Map<ServiceName, AbstractService> services = null;

    private ServiceFactory() {
        services = new HashMap<ServiceName, AbstractService>();
        services.put(ServiceName.USER, new UserServiceImpl());
        services.put(ServiceName.PRODUCT, new ProductServiceImpl());
    }

    public static ServiceFactory getInstance() {
        if (instance == null) {
            synchronized (ServiceFactory.class) {
                if (instance == null) {
                    instance = new ServiceFactory();
                } else {
                    return instance;
                }
            }
        }

        return instance;
    }

    public AbstractService getService(ServiceName serviceName) {
        return services.get(serviceName);
    }
}
