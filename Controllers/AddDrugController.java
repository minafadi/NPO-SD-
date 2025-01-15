package Controllers;

import Models.Drug;

public class AddDrugController {
    private Drug drugModel;

    public Drug AddNewDrug(String drugName,int quantity,double price,String treatment){
        drugModel = new Drug(drugName,quantity,price,treatment);
        return drugModel;
    }
}
