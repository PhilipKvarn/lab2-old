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

        cc.screenHeight = frame.getScreenHeight();
        cc.screenWidth = frame.getScreenWidth();
        cars = cc.cars;
        timer.start();
    }
    public class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                handleCollision(car);
                handleWorkshopEntry(car);
                car.move();
            }
            frame.drawPanel.repaint();
            cars = cc.cars;
        }
    }
    
    private void handleCollision(Vehicle v){
        if (v.getCurrentSpeed() + v.getPosition().x > 700 ||
            v.getCurrentSpeed() + v.getPosition().y > 700 ||
            v.getPosition().x + v.getCurrentSpeed() < 0 ||
            v.getPosition().y + v.getCurrentSpeed() < 0) {
                v.turnRight(180);
                v.move();
            } else {
                v.move();
            }
    }

    private void handleWorkshopEntry(Vehicle car){
        if (car instanceof Volvo240 &&
                car.getPosition().x > volvo_workshop.getPosition().x - 50 &&
                car.getPosition().x < volvo_workshop.getPosition().x + 50 &&
                car.getPosition().y > volvo_workshop.getPosition().y - 50 &&
                car.getPosition().y < volvo_workshop.getPosition().y + 50) {
            System.out.println("loaded Volvo");
            volvo_workshop.loadCar((Volvo240) car);
            car.setPosition(new Vector2(10000, 10000));
            car.stopEngine();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();

        //Volvo240 instanceof_Volvo240 = new Volvo240();
        //game.cars.add(instanceof_Volvo240);
        //game.frame.drawPanel.instantiate_image(instanceof_Volvo240, "pics/Volvo240.jpg");

        //Saab95 instanceof_Saab95 = new Saab95();
        //game.frame.drawPanel.instantiate_image(instanceof_Saab95, "pics/Saab95.jpg");
        //game.cars.add(instanceof_Saab95);

        //instanceof_Saab95.setPosition(Vector2.add(Vector2.zero(), 0, 200));

        //Truck instanceof_Truck = new Truck(100, 100, Color.BLACK, "fn");
        //game.frame.drawPanel.instantiate_image(instanceof_Truck, "pics/Scania.jpg");
        //game.cars.add(instanceof_Truck);
        //game.cc.cars = game.cars;
        
        //instanceof_Truck.setPosition(Vector2.add(Vector2.zero(), 0, 400));
    }
}
