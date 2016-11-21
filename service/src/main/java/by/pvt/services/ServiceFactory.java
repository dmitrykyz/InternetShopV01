package by.pvt.services;

import by.pvt.services.impl.AdminServiceImpl;
import by.pvt.services.impl.ClientServiceImpl;
import by.pvt.services.impl.OrderServiceImpl;
import by.pvt.services.impl.ProductServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class ServiceFactory {
    private static volatile ServiceFactory instance = null;

    private Map<ServiceName, IService> services = null;

    private ServiceFactory() {
        services = new HashMap<ServiceName, IService>();
        services.put(ServiceName.CLIENT, new ClientServiceImpl());
        services.put(ServiceName.ADMIN, new AdminServiceImpl());
        services.put(ServiceName.PRODUCT, new ProductServiceImpl());
        services.put(ServiceName.ORDER, new OrderServiceImpl());
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

    public IService getService(ServiceName serviceName) {
        return services.get(serviceName);
    }
}
