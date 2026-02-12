import java.awt.Color;

public class VeichleTransport extends Truck {

    VeichleLoader<Veichle> parentLoader;

    public VeichleTransport(int nrDoors, double enginePower, Color color, String modelName, int maxCapacity) {
        super(nrDoors, enginePower, color, modelName);
        setLoadingAreaDown(false);
        parentLoader = new VeichleLoader<>(maxCapacity);
    }

    public void LoadNewVeichle(Veichle veichle) {
        if (veichle instanceof VeichleTransport) {
            return;
        } else{
            if (Math.abs(veichle.getPosition().x) - Math.abs(getPosition().x) <= 1 &&
                Math.abs(veichle.getPosition().y) - Math.abs(getPosition().y) <= 1) {
            parentLoader.LoadNewVeichle(veichle);
            } else {
                // Handle veichle too far away to load
            }
        }
        return;
    }

    public Veichle unloadVeichle() {
        Veichle unloaded_car = parentLoader.unloadVeichle();
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