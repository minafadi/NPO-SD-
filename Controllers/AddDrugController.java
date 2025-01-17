package Controllers;

import Models.DB;
import Models.DBProxy;
import Models.Drug;
import Models.ICommandAdmin;
import Views.*;

public class AddDrugController implements ICommandAdmin {
    private static Drug drugModel;
    private AddDrugView addDrugView;
    static DBProxy dbProxy;

    @Override
    public void executecommand() {
        addDrugView=new AddDrugView();
        addDrugView.setVisible(true);
    }

    @Override
    public void undocommand() {
        this.addDrugView.setVisible(false);
    }

    public AddDrugController(DBProxy dbProxy) {
        this.dbProxy = dbProxy;
    }

    public static Drug AddNewDrug(String drugName, int quantity, double price, String treatment){
        drugModel = new Drug(drugName,quantity,price,treatment, dbProxy);
        return drugModel;
    }
}
