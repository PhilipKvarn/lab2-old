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

    // The delay (ms) corresponds to 20 updates a sec (hz) (delay 50 = 20fps)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();
    ArrayList<TurboCar> turboCars = new ArrayList<>();
    ArrayList<Truck> trucks = new ArrayList<>();
    VehicleWorkshop<Volvo240> volvo_workshop = new VehicleWorkshop<>(4, new Vector2(300, 300));
    // Detta är inte extensible, eller lätt att bygga ovanpå.
    // Föreställ dig att du vill skapa en change angle för alla Scanias.
    // Du hade behövt skapa en ny lista av scanias.
    // Och Scanias kommer existera i både trucks och scanias.
    // Ett annat alternativ är att på något sätt göra att vi har en godt subtyp till
    // car.
    // Och att när vi vill loopa igenom alla scanias i listan.
    // detta kan däremot också skapa problem, men det är andra problem.
    // Men det är nog en mer korrekt implomentation.

    private Vector2 volvo_workshop_location = new Vector2(300, 300);

    // methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        Volvo240 instanceof_Volvo240 = new Volvo240();
        cc.cars.add(instanceof_Volvo240);
        cc.frame.drawPanel.instantiate_image(instanceof_Volvo240, "pics/Volvo240.jpg");
        instanceof_Volvo240.turnLeft(45);
        Saab95 instanceof_Saab95 = new Saab95();
        cc.frame.drawPanel.instantiate_image(instanceof_Saab95, "pics/Saab95.jpg");
        cc.cars.add(instanceof_Saab95);
        cc.turboCars.add(instanceof_Saab95);
        instanceof_Saab95.setPosition(Vector2.add(Vector2.zero(), 0, 200));

        Truck instanceof_Truck = new Truck(100, 100, Color.BLACK, "fn");
        cc.frame.drawPanel.instantiate_image(instanceof_Truck, "pics/Scania.jpg");
        cc.cars.add(instanceof_Truck);
        cc.trucks.add(instanceof_Truck);
        instanceof_Truck.setPosition(Vector2.add(Vector2.zero(), 0, 400));

        // Start the timer
        cc.timer.start();
    }

    /*
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                //
                // Detta är troligen inte single responsibility.
                // Logik borde inte hända här i controller.
                // Det ska bara vara ett sätt att kalla på alla metoder relaterat till Veichle.
                //
                if (car.getCurrentSpeed() + car.getPosition().x > 700 ||
                        car.getCurrentSpeed() + car.getPosition().y > 700 ||
                        car.getPosition().x + car.getCurrentSpeed() < 0 ||
                        car.getPosition().y + car.getCurrentSpeed() < 0) {
                    car.turnRight(180);
                    // car.stopEngine();
                    car.move();
                } else {
                    car.move();
                }
                if (car instanceof Volvo240 &&
                        car.getPosition().x > volvo_workshop.getPosition().x - 50 &&
                        car.getPosition().x < volvo_workshop.getPosition().x + 50 &&
                        car.getPosition().y > volvo_workshop.getPosition().x - 50 &&
                        car.getPosition().x < volvo_workshop.getPosition().x + 50) {
                    System.out.println("loaded Volvo");
                    volvo_workshop.loadCar((Volvo240) car);
                    car.setPosition(new Vector2(10000, 10000));
                    car.stopEngine();
                }
                frame.drawPanel.repaint();
            }
        }
    }

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
