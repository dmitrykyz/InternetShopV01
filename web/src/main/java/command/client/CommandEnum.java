package command.client;

import command.*;

/**
 * Created by Dmitry on 10/23/2016.
 */
public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    SIGNUP{
        {
            this.command = new SignupCommand();
        }
    },
    ADDNEWCLIENT{
        {
            this.command = new AddNewClientCommand();
        }
    },
    RETURN_TO_LOGINJSP{
        {
            this.command = new ReturnToLoginCommand();
        }
    },
    SHOWALLPRODUCT{
        {
            this.command = new ShowAllProductCommand();
        }
    },
    ADDNEWPRODUCT{
        {
            this.command = new AddNewProductCommand();
        }
    },
    ADDNEWPRODUCTSHOWPAGE{
        {
            this.command = new ShowPageForAddNewProductCommand();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
