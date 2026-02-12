
import java.util.ArrayList;
import java.util.function.Consumer;;

public class VehicleLoader<carType extends Vehicle> {

    ArrayList<carType> loadingStorage = new ArrayList<>();

    protected int maxCapacity;

    public VehicleLoader(int maxCap) {
        maxCapacity = maxCap;
    }

    public void LoadNewVehicle(carType Vehicle) {
        if (loadingStorage.size() < this.maxCapacity) {
            loadingStorage.add(Vehicle);
        }

        return;
    }

    public carType unloadVehicle() {
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
