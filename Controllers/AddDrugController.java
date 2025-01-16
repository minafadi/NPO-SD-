package Controllers;

import Models.Drug;
import Views.*;

public class AddDrugController {
    private static Drug drugModel;
    private AddDrugView addDrugView;
    public AddDrugController() {
        addDrugView=new AddDrugView();
        addDrugView.setVisible(true);
    }

    public static Drug AddNewDrug(String drugName, int quantity, double price, String treatment){
        drugModel = new Drug(drugName,quantity,price,treatment);
        return drugModel;
    }
}
