import java.awt.Color;

public class Truck extends Veichle {

    protected boolean loadingAreaDown;

    public Truck(int nrDoors, double enginePower, Color color, String modelName){
        super(nrDoors, enginePower, color, modelName);
        loadingAreaDown = true;
    }

    public boolean getLoadingAreaDown(){
        return loadingAreaDown;
    }

    public void setLoadingAreaDown(boolean loadingState){
        if (getCurrentSpeed() == 0) {       
            loadingAreaDown = loadingState;     // Kan inte ändra loadingArea medans fordonet är i rörelse
        }
        return;
    }

    @Override
    public void startEngine(){
        if(loadingAreaDown){
            super.startEngine();
        }
    } 

}
