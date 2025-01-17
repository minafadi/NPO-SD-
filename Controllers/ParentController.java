package Controllers;

public class ParentController {
    static State x;
    public static void setnextState(State x){
        ParentController.x=x;
        x.show();
    }
    public static void nextPage(){
        x.hide();
        x.init();
    }
}
