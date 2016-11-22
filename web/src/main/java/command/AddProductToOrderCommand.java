package command;

import by.pvt.entity.Client;
import by.pvt.entity.Order;
import by.pvt.entity.Product;
import by.pvt.logic.LoginLogic;
import by.pvt.services.IService;
import by.pvt.services.ServiceFactory;
import by.pvt.services.ServiceName;
import by.pvt.services.exception.ServiceException;
import org.apache.log4j.Logger;
import resource.ConfigurationManager;
import resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 11/20/2016.
 */
public class AddProductToOrderCommand implements ActionCommand  {
    private static Logger log = Logger.getLogger(AddProductToOrderCommand.class);

    @Override
    public String execute(HttpServletRequest request) throws ServiceException {

        String page = ConfigurationManager.getProperty("path.page.mainByer");;

        System.out.println("----------------------------------------------------");
        String idProductString = request.getParameter("productId");
        System.out.println("**********************");
        System.out.println(idProductString);
        Integer idProduct = Integer.parseInt(idProductString);
        IService productService = ServiceFactory.getInstance().getService(ServiceName.PRODUCT);
        Product product = (Product) productService.get(idProduct);
        System.out.println(product);

        Integer clientId = LoginLogic.getID();
        IService clientService = ServiceFactory.getInstance().getService(ServiceName.CLIENT);
        Client client = (Client) clientService.get(clientId);
        if (client.getOrderListInbBasket() == null){
            client.setOrderListInbBasket(new ArrayList<Order>());
        }
        List<Order> orderList = client.getOrderListInbBasket();
        Order order = null;
        for (Order orderTemp: orderList) {
            if (orderTemp.getIsRegistryOrder() == 0 && orderTemp.getIsPaidOrder() == 0){
                order = orderTemp;
            }
        }

        if (order == null) {
            order = new Order();
        }

        order.setIsPaidOrder(0);
        order.setIsRegistryOrder(0);
        order.setTotalPrice(order.getTotalPrice() + product.getPrice());
        if (order.getProductList() == null){
            order.setProductList(new ArrayList<Product>());
        }
        order.getProductList().add(product);
        order.setClient(client);

        log.info("Add Product in Order in class AddProductToOrderCommand");

        IService orderService = ServiceFactory.getInstance().getService(ServiceName.ORDER);
        try {
            if (orderService.saveOrUpdate(order) == true) {
                request.setAttribute("user", LoginLogic.getLOGIN());
                request.setAttribute("addProductToOrderCommandMessage", MessageManager.getProperty("message.addproducttoorder"));
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            request.setAttribute("addProductToOrderCommandMessage", MessageManager.getProperty("message.addproducttoordererror"));
        }
        return page;
    }
}
