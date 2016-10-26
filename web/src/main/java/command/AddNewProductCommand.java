package command;

import by.pvt.entity.Product;
import by.pvt.entity.User;
import by.pvt.services.AbstractService;
import by.pvt.services.ServiceFactory;
import by.pvt.services.ServiceName;
import org.apache.log4j.Logger;
import resource.ConfigurationManager;

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
        product.setPrice(6);
        product.setStatus(request.getParameter("status"));

        log.info("Add new Product in class AddNewProductCommand");

        AbstractService productService = ServiceFactory.getInstance().getService(ServiceName.PRODUCT);
        if (productService.create(product) == true) {
            page = ConfigurationManager.getProperty("path.page.mainAdmin");
        }

        return page;
    }
}
