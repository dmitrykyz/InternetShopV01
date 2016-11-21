package command;

import by.pvt.entity.Client;
import by.pvt.services.IService;
import by.pvt.services.ServiceFactory;
import by.pvt.services.ServiceName;
import by.pvt.services.exception.ServiceException;
import org.apache.log4j.Logger;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dmitry on 10/26/2016.
 */
public class AddNewClientCommand implements ActionCommand  {
    private static Logger log = Logger.getLogger(AddNewClientCommand.class);

    public String execute(HttpServletRequest request) {
        String page = null;
        Client client = new Client();
        client.setLogin((String)request.getParameter("login"));
        client.setPassword((String)request.getParameter("password"));
        client.setFirstName((String)request.getParameter("firstname"));
        client.setLastName((String)request.getParameter("laststname"));
        client.setUserType(0);
        client.setInBlackList(0);
        String summoncreditcardString = request.getParameter("summoncreditcard");
        Double summoncreditcard = Double.parseDouble(summoncreditcardString);
        client.setSummOnCreditCard(summoncreditcard);

        log.info("Add new client Command with login: " + client.getLogin());
        IService clientService = ServiceFactory.getInstance().getService(ServiceName.CLIENT);
        try {
            if (clientService.saveOrUpdate(client) == true) {
                page = ConfigurationManager.getProperty("path.page.confirmationOfRegistration");
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }


        return page;
    }
}
