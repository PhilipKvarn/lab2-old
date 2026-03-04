import java.awt.Color;

public class VehicleTransport extends Truck {

    VehicleLoader<Vehicle> parentLoader;

    public VehicleTransport(int nrDoors, double enginePower, Color color, String modelName, int maxCapacity) {
        super(nrDoors, enginePower, color, modelName);
        setLoadingAreaDown(false);
        parentLoader = new VehicleLoader<>(maxCapacity, getPosition());
    }

    public void LoadNewVehicle(Vehicle Vehicle) {
        if (Vehicle instanceof VehicleTransport) {
            return;
        } else {
            {
                parentLoader.LoadNewVehicle(Vehicle);
            }
        }
        return;
    }

    public Vehicle unloadVehicle() {
        Vehicle unloaded_car = parentLoader.unloadVehicle();
        if (unloaded_car != null) {
            unloaded_car.setPosition(Vector2.add(getPosition(), -1, -1));
        }
        return unloaded_car;
    }

    @Override
    /**
     * Overriden method from Movable interface
     * Updates this object's positional Vector2 by the directional Vector2.
     * And updates every entry in the list's position to the same position.
     * Scaled by getCurrentSpeed()
     */
    public void move() {
        super.move();
        parentLoader.forEachItem(loadedCar -> loadedCar.setPosition(this.getPosition()));
        parentLoader.setPosition(getPosition());
    }

    @Override
    public void startEngine() {
        if (!loadingAreaDown) {
            super.startEngine();
        }
    }
}