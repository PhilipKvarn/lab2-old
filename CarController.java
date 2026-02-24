import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    ArrayList<Vehicle> cars = new ArrayList<>();
    ArrayList<TurboCar> turboCars = new ArrayList<>();
    ArrayList<Truck> trucks = new ArrayList<>();

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake_amount = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake_amount);
        }
    }

    void turboOn() {
        for (TurboCar car : turboCars) {
            car.setTurboActive();
        }
    }

    void turboOff() {
        for (TurboCar car : turboCars) {
            car.setTurboInactive();
        }
    }

    void liftTruckBed() {
        for (Truck car : trucks) {
            car.setLoadingAreaDown(false);
        }
    }

    void lowerTruckBed() {
        for (Truck car : trucks) {
            car.setLoadingAreaDown(true);
        }
    }

    void startEngine() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }
}
