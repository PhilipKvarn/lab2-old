import java.awt.Color;

class TrimmedCar extends Vehicle {
    private double trimFactor;

    public TrimmedCar(int nrDoors, double enginePower, Color color, String modelName, double trimFactor) {
        super(nrDoors, enginePower, color, modelName);
        this.trimFactor = trimFactor;
    }

    @Override
    /**
     * Overriden method that returns the speedFactor scaled by this object's
     * trimFactor
     * 
     * @return returns a double value of the speedFactor.
     */
    protected double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

}