
import java.util.ArrayList;
import java.util.function.Consumer;;

public class VeichleLoader<carType extends Veichle> {

    ArrayList<carType> loadingStorage = new ArrayList<>();

    protected int maxCapacity;

    public VeichleLoader(int maxCap) {
        maxCapacity = maxCap;
    }

    public void LoadNewVeichle(carType veichle) {
        if (loadingStorage.size() < this.maxCapacity) {
            loadingStorage.add(veichle);
        }

        return;
    }

    public carType unloadVeichle() {
        if(loadingStorage.isEmpty()){
            return null;
        } else {
            carType unloadCar = loadingStorage.getLast();
            loadingStorage.removeLast();
            return unloadCar;
        }
    }

    public void forEachItem(Consumer<carType> func){
        for (carType car : loadingStorage){
            func.accept(car);
        }
    }

    public int getMax() {
        return maxCapacity;
    }

    public int getCapacity() {
        return loadingStorage.size();
    }
}
