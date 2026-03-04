public class VehicleWorkshop<VehicleType extends Vehicle> {

    VehicleLoader<VehicleType> loadedCars;
    private Vector2 position;

    public VehicleWorkshop(int maxCapacity, Vector2 location) {
        position = location;
        this.loadedCars = new VehicleLoader<>(maxCapacity, position);
    }

    public void loadCar(VehicleType car) {
        this.loadedCars.LoadNewVehicle(car);
    }

    public VehicleType unloadCar() {
        VehicleType unloaded_car = loadedCars.unloadVehicle();
        return unloaded_car;
    }

    public Vector2 getPosition() {
        return position;
    }
}
