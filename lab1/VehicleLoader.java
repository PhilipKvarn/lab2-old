
import java.util.ArrayList;
import java.util.function.Consumer;;

public class VehicleLoader<carType extends Vehicle> {

    ArrayList<carType> loadingStorage = new ArrayList<>();

    protected int maxCapacity;
    private Vector2 position;

    public VehicleLoader(int maxCap, Vector2 position) {
        maxCapacity = maxCap;
        this.position = position;
    }

    public void LoadNewVehicle(carType Vehicle) {
        if (loadingStorage.size() < this.maxCapacity) {
            if (Math.abs(Vehicle.getPosition().x) - Math.abs(position.x) <= 1 &&
                    Math.abs(Vehicle.getPosition().y) - Math.abs(position.y) <= 1) {
                loadingStorage.add(Vehicle);
            }
        }

        return;
    }

    public carType unloadVehicle() {
        if (loadingStorage.isEmpty()) {
            return null;
        } else {
            carType unloadCar = loadingStorage.getLast();
            loadingStorage.removeLast();
            return unloadCar;
        }
    }

    public void forEachItem(Consumer<carType> func) {
        for (carType car : loadingStorage) {
            func.accept(car);
        }
    }

    public int getMax() {
        return maxCapacity;
    }

    public int getCapacity() {
        return loadingStorage.size();
    }

    public void setPosition(Vector2 pos) {
        this.position = pos;
    }
}
