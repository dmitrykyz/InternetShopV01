package command;

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

/**
 * Created by Dmitry on 10/26/2016.
 */
public class AddNewProductCommand implements ActionCommand  {
    private static Logger log = Logger.getLogger(AddNewProductCommand.class);

    public String execute(HttpServletRequest request) {
        String page = null;
        Product product = new Product();
        product.setNameProduct((String)request.getParameter("productName"));
        String priceString = request.getParameter("price");
        double price = Double.parseDouble(priceString);
        product.setPrice(price);
        String statusString = request.getParameter("status");
        Integer status = Integer.parseInt(statusString);
        product.setStatus(status);

        log.info("Add new Product in class AddNewProductCommand");

        IService productService = ServiceFactory.getInstance().getService(ServiceName.PRODUCT);
        try {
            if (productService.saveOrUpdate(product) == true) {
                request.setAttribute("user", LoginLogic.getLOGIN());
                request.setAttribute("addNewProductMessage", MessageManager.getProperty("message.addnewproduct"));
                page = ConfigurationManager.getProperty("path.page.mainAdmin");
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
