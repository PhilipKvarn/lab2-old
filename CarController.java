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
        for (Vehicle car : cars) {
            if (car instanceof TurboCar) {
                TurboCar turboCar = (TurboCar)car;
                turboCar.setTurboActive();
            }
        }
    }

    void turboOff() {
        for (Vehicle car : cars) {
            if (car instanceof TurboCar) {
                TurboCar turboCar = (TurboCar)car;
                turboCar.setTurboInactive();
            }
        }
    }

    void liftTruckBed() {
        for (Vehicle car : cars) {
            if (car instanceof Truck) {
                Truck truck = (Truck)car;
                truck.setLoadingAreaDown(false);
            }
        }
    }

    void lowerTruckBed() {
        for (Vehicle car : cars) {
            if (car instanceof Truck) {
                Truck truck = (Truck)car;
                truck.setLoadingAreaDown(true);
            }
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
