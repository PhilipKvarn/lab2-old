public class VehicleWorkshop<VehicleType extends Vehicle> {

    VehicleLoader<VehicleType> loadedCars;
    private Vector2 position;

    public VehicleWorkshop(int maxCapacity, Vector2 location) {
        this.loadedCars = new VehicleLoader<>(maxCapacity);
        position = location;
    }

    public void loadCar(VehicleType car) {
        this.loadedCars.LoadNewVehicle(car);
    }

    public VehicleType unloadCar(){
        VehicleType unloaded_car = loadedCars.unloadVehicle();
        return unloaded_car;
    } 

    public Vector2 getPosition(){
        return position;
    }
}
