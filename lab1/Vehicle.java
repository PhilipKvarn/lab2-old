import java.awt.*;

public class Vehicle implements Movable {

    private int nrDoors;
    protected double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;

    private Vector2 VehiclePosition = new Vector2(0.0, 0.0);
    private Vector2 VehicleDirection = new Vector2(1.0, 0.0);

    public Vehicle(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    /**
     * returns an int representing the number of doors of this object.
     * 
     * @return returns an int representing number of doors of this object.
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * returns a String of the modelName of this object.
     * 
     * @return returns a String of the modelName of this object.
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * returns a double representing the engine power of this object.
     * 
     * @return returns a double representing the engine power of this object.
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * returns a double of the currentSpeed of this object.
     * 
     * @return returns a double of the currentSpeed of this object.
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * returns a Color type of the color of this object.
     * 
     * @return returns a Color type of this object's color.
     */

    public Color getColor() {
        return color;
    }

    /**
     * Sets the Color of this object.
     * 
     * @param clr takes a Color type to set this object's color to.
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * set the currentSpeed of this object to 0.1
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * set the currentSpeed of this object to 0
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * gets the speedFactor of this object
     * 
     * @return returns a double
     */
    protected double speedFactor() {
        return enginePower * 0.01;
    }

    /**
     * cheks so that the speedchange is alowed before increasing the speed
     * 
     * @param amount double parametre to increase the speed
     */
    public void gas(double amount) {
        boolean check = checkSpeedChange(amount);
        if (check) {
            incrementSpeed(amount);
        }

    }

    /**
     * increases the current speed scaled by a parametre.
     * 
     * @param amount double parametre to increase the speed.
     */
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        if (currentSpeed > enginePower) {
            currentSpeed = enginePower;
        }
    }

    /**
     * cheks so that the speedchange is alowed before decreaseing the speed
     * 
     * @param amount double parameter to decrease the speed
     */
    public void brake(double amount) {
        boolean check = checkSpeedChange(amount);
        if (check) {
            decrementSpeed(amount);
        }
    }

    /**
     * decreases the current speed, scaled by a parametre.
     * 
     * @param amount double parametre to decrease the speed.
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        if (currentSpeed < 0) {
            stopEngine();
        }
    }

    /**
     * checks so that the speed can only be changed in the interval 0-1
     * 
     * @param amount double parametre to change speed
     * @return boolean that is True if within interval and False otherwise
     */
    private boolean checkSpeedChange(double amount) {
        boolean check = false;
        if (amount <= 1 && amount >= 0) {
            check = true;
        }
        return check;

    }

    @Override
    /**
     * Overriden method from Movable interface
     * Updates this object's positional Vector2 by the directional Vector2.
     * Scaled by getCurrentSpeed()
     */
    public void move() {
        if (currentSpeed > 0.0) {
            VehiclePosition.add(
                    getCurrentSpeed() * VehicleDirection.x,
                    getCurrentSpeed() * VehicleDirection.y);
        }
    }

    @Override
    /**
     * modifies this object's directional Vector2 by a fixed positive rotationSpeed.
     */
    public void turnLeft(int degrees) {
        VehicleDirection.rotateByDeg(degrees);
    }

    @Override
    /**
     * modifies this object's directional Vector2 by a fixed negative rotationSpeed.
     */
    public void turnRight(int degrees) {
        VehicleDirection.rotateByDeg(-degrees);
    }

    /**
     * returns a Vector2 representing the position of this object
     * 
     * @return a Vector2 type of this object position
     */
    public void setPosition(Vector2 newPosition) {
        VehiclePosition = newPosition;
        return;
    }

    /**
     * returns a Vector2 representing the position of this object
     * 
     * @return a Vector2 type of this object position
     */
    public Vector2 getPosition() {
        return VehiclePosition;
    }

    /**
     * returns a Vector2 representing the direction of this object
     * 
     * @return a Vector2 type of this object direction.
     */
    public Vector2 getDirection() {
        return VehicleDirection;
    }
}
