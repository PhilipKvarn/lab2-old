import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController implements ControllerInterface{
    // member fields:

    int screenHeight;
    int screenWidth;
    ArrayList<Vehicle> cars = new ArrayList<>();

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake_amount = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake_amount);
        }
    }

    public void turboOn() {
        for (Vehicle car : cars) {
            if (car instanceof TurboCar) {
                TurboCar turboCar = (TurboCar)car;
                turboCar.setTurboActive();
            }
        }
    }

    public void turboOff() {
        for (Vehicle car : cars) {
            if (car instanceof TurboCar) {
                TurboCar turboCar = (TurboCar)car;
                turboCar.setTurboInactive();
            }
        }
    }

    public void liftTruckBed() {
        for (Vehicle car : cars) {
            if (car instanceof Truck) {
                Truck truck = (Truck)car;
                truck.setLoadingAreaDown(false);
            }
        }
    }

    public void lowerTruckBed() {
        for (Vehicle car : cars) {
            if (car instanceof Truck) {
                Truck truck = (Truck)car;
                truck.setLoadingAreaDown(true);
            }
        }
    }

    public void startEngine() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
    }

    public void stopEngine() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }

    public Vehicle createCar(String carType){
        Vehicle createdVehicle = null;
        if (cars.size() < 10) {
            switch (carType) {
                case "Volvo240":
                    createdVehicle = CarFactory.createVolvo240();
                    cars.add(createdVehicle);
                    createdVehicle.setPosition(new Vector2(0, (double) getRandomScreenY()));
                    System.out.println("Created Volvo");
                    break;
                case "Saab95":
                    createdVehicle = CarFactory.createSaab95();
                    cars.add(createdVehicle);
                    createdVehicle.setPosition(new Vector2(0, (double) getRandomScreenY()));
                    System.out.println("Created Saab");
                    break;
                case "Scania":
                    createdVehicle = CarFactory.createScania();
                    cars.add(createdVehicle);
                    createdVehicle.setPosition(new Vector2(0, (double) getRandomScreenY()));
                    System.out.println("Created Scania");
                    break;
                case "Random":
                    createdVehicle = CarFactory.createRandomVehicle();
                    cars.add(createdVehicle);
                    System.out.println(createdVehicle.getModelName());
                    createdVehicle.setPosition(new Vector2(0, (double) getRandomScreenY()));
                    break;
                default:
                    System.out.println("Default");
                    break;
            }
        }
        return createdVehicle;
    }

    public void removeCar(){
        if (cars.size() > 0) {
            cars.removeFirst();
        }
    }

    private int getRandomScreenY() {
        Random generator = new Random();
        int randint = generator.nextInt(screenHeight - 250);
        return randint;

    }
}
