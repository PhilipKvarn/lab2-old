import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game {

    private int delay;
    private Timer timer = new Timer(delay, new TimerListener());

    CarView frame;
    CarController cc;
    
    ArrayList<Vehicle> cars;
    ArrayList<TurboCar> turboCars = new ArrayList<>();
    ArrayList<Truck> trucks = new ArrayList<>();
    VehicleWorkshop<Volvo240> volvo_workshop = new VehicleWorkshop<>(4, new Vector2(300, 300));

    public Game(){
        cc = new CarController();
        
        frame = new CarView("CarSim 1.0", cc);

        cars = new ArrayList<>();
        turboCars = new ArrayList<>();
        trucks = new ArrayList<>();
        timer.start();
    }
    public class TimerListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {

            /*
                // Detta är vad vi vill uppnå
                for (Car car : cars) {
                    checkCollision(car);
                    checkWorkshopEntry(car);
                    car.move();
                }
                frame.drawPanel.repaint
            */

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

    public static void main(String[] args) {
        Game game = new Game();

        Volvo240 instanceof_Volvo240 = new Volvo240();
        game.cars.add(instanceof_Volvo240);
        game.frame.drawPanel.instantiate_image(instanceof_Volvo240, "pics/Volvo240.jpg");

        Saab95 instanceof_Saab95 = new Saab95();
        game.frame.drawPanel.instantiate_image(instanceof_Saab95, "pics/Saab95.jpg");
        game.cars.add(instanceof_Saab95);

        instanceof_Saab95.setPosition(Vector2.add(Vector2.zero(), 0, 200));

        Truck instanceof_Truck = new Truck(100, 100, Color.BLACK, "fn");
        game.frame.drawPanel.instantiate_image(instanceof_Truck, "pics/Scania.jpg");
        game.cars.add(instanceof_Truck);
        game.cc.cars = game.cars;
        
        instanceof_Truck.setPosition(Vector2.add(Vector2.zero(), 0, 400));
    }
}
