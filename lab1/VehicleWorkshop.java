public class VehicleWorkshop<VehicleType extends Vehicle> {

    VehicleLoader<VehicleType> loadedCars;

    public VehicleWorkshop(int maxCapacity) {
        this.loadedCars = new VehicleLoader<>(maxCapacity);
    }

    public void loadCar(VehicleType car) {
        this.loadedCars.LoadNewVehicle(car);
    }

    public VehicleType unloadCar(){
        VehicleType unloaded_car = loadedCars.unloadVehicle();
        return unloaded_car;
    } 
}
