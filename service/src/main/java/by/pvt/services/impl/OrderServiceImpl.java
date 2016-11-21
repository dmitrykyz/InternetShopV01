package by.pvt.services.impl;

import by.pvt.dao.exception.DaoException;
import by.pvt.dao.impl.ClientDaoImpl;
import by.pvt.dao.impl.OrderDaoImpl;
import by.pvt.entity.Order;
import by.pvt.services.BaseService;
import by.pvt.util.HibernateUtil;
import by.pvt.util.ServiceUtilForHibernate;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 11/21/2016.
 */
public class OrderServiceImpl extends BaseService<Order> {

    private static Logger log = Logger.getLogger(OrderServiceImpl.class);
    Transaction transaction = null;

    public OrderServiceImpl() {
    }

    public List<Order> getOrderInBasketByUserId(Integer id){

        ServiceUtilForHibernate serviceUtilForHibernate = ServiceUtilForHibernate.getInstance();
        serviceUtilForHibernate.setUtil(HibernateUtil.getHibernateUtil());
        Session session = serviceUtilForHibernate.getUtil().getSession();
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
            serviceUtilForHibernate.setUtil(null);
            return listOrdersInBasket;
        } catch (DaoException e) {
            e.printStackTrace();
            transaction.rollback();
            serviceUtilForHibernate.setUtil(null);
            return null;
        }
    }


}
