import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game implements TimerListeners{

    private int delay;
    private TimerListener listener = new TimerListener();
    private Timer timer = new Timer(delay, listener);

    CarView frame;
    CarController cc;
    
    ArrayList<Vehicle> cars;
    VehicleWorkshop<Volvo240> volvo_workshop = new VehicleWorkshop<>(4, new Vector2(300, 300));

    public Game(){
        cc = new CarController();
        
        frame = new CarView("CarSim 1.0", cc);

        cc.screenHeight = frame.getScreenHeight();
        cc.screenWidth = frame.getScreenWidth();
        listener.addListener(this);
        cars = cc.cars;
        timer.start();
    }

    public void update(){
        for (Vehicle car : cars) {
                handleCollision(car);
                handleWorkshopEntry(car);
                car.move();
            }
            frame.drawPanel.repaint();
            cars = cc.cars;
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
    }
}
