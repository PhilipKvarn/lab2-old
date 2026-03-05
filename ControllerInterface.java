public interface ControllerInterface {
    void gas(int amount);
    void brake(int amount);
    void turboOn();
    void turboOff();
    void liftTruckBed();
    void lowerTruckBed();
    void startEngine();
    void stopEngine();
    Vehicle createCar(String carType);
    void removeCar();
}
