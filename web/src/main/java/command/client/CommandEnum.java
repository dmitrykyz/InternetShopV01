package command.client;

import command.*;

/**
 * Created by Dmitry on 10/23/2016.
 */
public enum CommandEnum {

    LOGIN (new LoginCommand()),
    LOGOUT (new LogoutCommand()),
    SIGNUP (new SignupCommand()),
    ADDNEWCLIENT (new AddNewClientCommand()),
    RETURN_TO_LOGINJSP (new ReturnToLoginCommand()),
    SHOWALLPRODUCT(new ShowAllProductCommand()),
    ADDNEWPRODUCT (new AddNewProductCommand()),
    ADDNEWPRODUCTSHOWPAGE(new ShowPageForAddNewProductCommand()),
    ADDPRODUCTTOORDER(new AddProductToOrderCommand()),
    SHOWBASKET(new ShowBasketCommand()),
    //SHOWALLPRODUCTPAGINATIONSHOWPAGE (new ShowPageForShowAllProductPaginationCommand()),
    //SHOWALLPRODUCTPAGINATIONSHOWPAGE (new GetAllProductPagination()),
    GETALLPRODUCTPAGINATION (new GetAllProductPagination());
    //DELETEPRODUCTFROMORDER(new DeleteProductFromOrderCommand());


    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
