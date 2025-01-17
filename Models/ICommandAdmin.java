package Models;

import Controllers.IAdminControllers;

public interface ICommandAdmin {

    public void executecommand();
    public void undocommand();
}
