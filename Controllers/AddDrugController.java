package Controllers;

import Models.DB;
import Models.DBProxy;
import Models.Drug;
import Views.*;

public class AddDrugController {
    private static Drug drugModel;
    private AddDrugView addDrugView;
    static DBProxy dbProxy;
    public AddDrugController(DBProxy dbProxy) {
        addDrugView=new AddDrugView();
        addDrugView.setVisible(true);
        this.dbProxy = dbProxy;
    }

    public static Drug AddNewDrug(String drugName, int quantity, double price, String treatment){
        drugModel = new Drug(drugName,quantity,price,treatment, dbProxy);
        return drugModel;
    }
}
