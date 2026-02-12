import java.awt.Color;

public class VehicleTransport extends Truck {

    VehicleLoader<Vehicle> parentLoader;

    public VehicleTransport(int nrDoors, double enginePower, Color color, String modelName, int maxCapacity) {
        super(nrDoors, enginePower, color, modelName);
        setLoadingAreaDown(false);
        parentLoader = new VehicleLoader<>(maxCapacity);
    }

    public void LoadNewVehicle(Vehicle Vehicle) {
        if (Vehicle instanceof VehicleTransport) {
            return;
        } else{
            if (Math.abs(Vehicle.getPosition().x) - Math.abs(getPosition().x) <= 1 &&
                Math.abs(Vehicle.getPosition().y) - Math.abs(getPosition().y) <= 1) {
            parentLoader.LoadNewVehicle(Vehicle);
            } else {
                // Handle Vehicle too far away to load
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
    }

    @Override
    public void startEngine() {
        if (!loadingAreaDown) {
            super.startEngine();
        }
    }
}