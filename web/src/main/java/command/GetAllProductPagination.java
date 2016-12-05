package command;

import by.pvt.services.ServiceFactory;
import by.pvt.services.ServiceName;
import by.pvt.services.exception.ServiceException;
import by.pvt.services.impl.ProductServiceImpl;
import by.pvt.vo.ProductVOforPagination;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Dmitry on 11/22/2016.
 */
public class GetAllProductPagination implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) throws ServiceException {

        ProductVOforPagination productVOforPagination = null;
        ProductServiceImpl productService = (ProductServiceImpl) ServiceFactory.getInstance().getService(ServiceName.PRODUCT);

        String page = null;
        String countPerPage = null;

        page = request.getParameter("page");

        HttpSession session = request.getSession();

        if (countPerPage == null)
            countPerPage = "10";
        if (page == null)
            page = "1";


        productVOforPagination = productService.paginationProducts(page, Integer.valueOf(countPerPage));

        try {
            productVOforPagination = productService.paginationProducts(page, Integer.valueOf(countPerPage));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.setAttribute("totalproductcount", productVOforPagination.getTotalProductCount());
        request.setAttribute("countofpages", (int) Math.ceil(productVOforPagination.getTotalProductCount()) * 1.0 / Integer.valueOf(countPerPage));
        request.setAttribute("page", productVOforPagination.getPage());
        request.setAttribute("listproductpagination", productVOforPagination.getProductList());

        session.setAttribute("page", productVOforPagination.getPage());

        page = ConfigurationManager.getProperty("path.page.showproductpagination");
        return page;
    }
}
