package by.pvt.services.impl;

import by.pvt.dao.exception.DaoException;
import by.pvt.dao.impl.OrderDaoImpl;
import by.pvt.entity.Order;
import by.pvt.services.BaseService;
import by.pvt.services.exception.ServiceException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 11/21/2016.
 */
public class OrderServiceImpl extends BaseService<Order> {

    private static Logger log = Logger.getLogger(OrderServiceImpl.class);
    private Transaction transaction = null;

    public OrderServiceImpl() {
    }

    @Override
    public Order get(Serializable id) throws ServiceException {
        return null;
    }

    @Override
    public Order load(Serializable id) throws ServiceException {
        return null;
    }

    @Override
    public List<Order> getAll() throws ServiceException {
        return null;
    }

    public List<Order> getOrderInBasketByUserId(Integer id){


        Session session = getSession();
        transaction = session.beginTransaction();

        log.info("Getting Order in class ClientServiceImpl in metod getOrderInBasketByUserId by id User : " + id);
        OrderDaoImpl orderDao = new OrderDaoImpl();
        try {
            List<Order> orders = orderDao.getOrderByUserId(id);
            List<Order> listOrdersInBasket = new ArrayList<>();
            for (Order orderTemp: orders) {
                if (orderTemp.getIsRegistryOrder() == 0){
                    listOrdersInBasket.add(orderTemp);
                }
            }
            transaction.commit();
            closeSession();
            return listOrdersInBasket;
        } catch (DaoException e) {
            e.printStackTrace();
            transaction.rollback();
            closeSession();
            return null;
        }
    }


}
