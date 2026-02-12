import java.awt.Color;

class TurboCar extends Vehicle {

    private boolean activeTurbo;

    public TurboCar(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
        this.activeTurbo = false;
    }

    /**
     * gets the boolean value of this object's turbo.
     * 
     * @return a boolean value of this object's turbo.
     */
    public boolean getTurboActive() {
        return activeTurbo;
    }

    /**
     * sets the boolean value of this object's turbo to true
     */
    public void setTurboActive() {
        activeTurbo = true;
    }

    /**
     * sets the boolean value of this object's turbo to false
     */
    public void setTurboInactive() {
        activeTurbo = false;
    }

    @Override
    /**
     * Overridden method that returns a speedFactor scaled by turbo
     * 
     * @return a double value of this object's speedFactor
     */
    protected double speedFactor() {
        double turbo = 1.0;
        if (activeTurbo) {
            turbo = 1.3;
        }
        return enginePower * 0.01 * turbo;
    }

}
