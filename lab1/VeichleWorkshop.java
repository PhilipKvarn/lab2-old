public class VeichleWorkshop<VeichleType extends Veichle> {

    VeichleLoader<VeichleType> loadedCars;

    public VeichleWorkshop(int maxCapacity) {
        this.loadedCars = new VeichleLoader<>(maxCapacity);
    }

    public void loadCar(VeichleType car) {
        this.loadedCars.LoadNewVeichle(car);
    }

    public VeichleType unloadCar(){
        VeichleType unloaded_car = loadedCars.unloadVeichle();
        return unloaded_car;
    } 
}
