package command;

import by.pvt.entity.Order;
import by.pvt.logic.LoginLogic;
import by.pvt.services.IService;
import by.pvt.services.ServiceFactory;
import by.pvt.services.ServiceName;
import by.pvt.services.exception.ServiceException;
import by.pvt.services.impl.OrderServiceImpl;
import org.apache.log4j.Logger;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by Dmitry on 11/21/2016.
 */
public class ShowBasketCommand implements ActionCommand  {
    private static Logger log = Logger.getLogger(ShowBasketCommand.class);

    @Override
    public String execute(HttpServletRequest request) throws ServiceException {
        String page = null;
        ArrayList<Order> listOrder = null;
        OrderServiceImpl orderService = (OrderServiceImpl) ServiceFactory.getInstance().getService(ServiceName.ORDER);
        //Get all Order from DB by User Id using serviceService
        Integer userId = LoginLogic.getID();
        listOrder = (ArrayList<Order>) orderService.getOrderInBasketByUserId(userId);
        log.info("Show all Order in Basket in class ShowBasketCommand ");
        request.setAttribute("user", LoginLogic.getLOGIN());
        request.setAttribute("listorderinbasket", listOrder);
        for (Order order : listOrder) {
            System.out.println(order);
        }

        if (LoginLogic.getUserType() == 0)
            page = ConfigurationManager.getProperty("path.page.mainByer");
        else{
            if (LoginLogic.getUserType() == 1)
                page = ConfigurationManager.getProperty("path.page.mainAdmin");
        }
        return page;
    }

}
