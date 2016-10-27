package controller;

import command.ActionCommand;
import command.factory.ActionFactory;
import resource.ConfigurationManager;
import resource.MessageManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by Dmitry on 10/23/2016.
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {

    public DataSource dataSource = null;

    @Override
    public void init() throws ServletException {

        //using JNDI
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/InternetShop");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        // definition of the command, which came from JSP
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
/*
* call implemented method execute() and passing parameter
* to Class-specific command handler
*/
        page = command.execute(request);
// method returns the response page
        if (page != null) {
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(page);
//challenge response to the request page
            dispatcher.forward(request, response);
        } else {
//page setup whith Error Message
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage",
                    MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
