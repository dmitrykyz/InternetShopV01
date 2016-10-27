package command;

import by.pvt.entity.Product;
import by.pvt.logic.LoginLogic;
import by.pvt.services.AbstractService;
import by.pvt.services.ServiceFactory;
import by.pvt.services.ServiceName;
import org.apache.log4j.Logger;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by Dmitry on 10/26/2016.
 */
public class ShowAllProductCommand implements ActionCommand  {
    private static Logger log = Logger.getLogger(ShowAllProductCommand.class);
    public String execute(HttpServletRequest request) {
        String page = null;
        ArrayList<Product> listProduct = null;
        AbstractService productService = ServiceFactory.getInstance().getService(ServiceName.PRODUCT);
        //Get all product from DB using serviceProduct
        listProduct = (ArrayList<Product>) productService.getAll();
        log.info("Show all product in class ShowAllProductCommand ");
        request.setAttribute("user", LoginLogic.getAdminLogin());
        request.setAttribute("listproduct", listProduct);
        for (Product product : listProduct) {
            System.out.println(product);
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
