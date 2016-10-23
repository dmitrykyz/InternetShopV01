package by.pvt.command.client;

import by.pvt.command.ActionCommand;
import by.pvt.command.LoginCommand;
import by.pvt.command.LogoutCommand;

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
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
