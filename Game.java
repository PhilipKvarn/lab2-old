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

    private Vector2 volvo_workshop_location = new Vector2(300, 300);

    public Game(){
        cc = new CarController();
        frame = new CarView("CarSim 1.0", cc);

        cars = new ArrayList<>();
        turboCars = new ArrayList<>();
        trucks = new ArrayList<>();
    }

    public static void main(String[] args) {
        // Instance of this class
        Game game = new Game();

        CarController cc = new CarController();

        // Start a new view and send a reference of self
        CarView frame = new CarView("CarSim 1.0", cc);

        Volvo240 instanceof_Volvo240 = new Volvo240();
        game.cars.add(instanceof_Volvo240);
        frame.drawPanel.instantiate_image(instanceof_Volvo240, "pics/Volvo240.jpg");
        instanceof_Volvo240.turnLeft(45);

        Saab95 instanceof_Saab95 = new Saab95();
        frame.drawPanel.instantiate_image(instanceof_Saab95, "pics/Saab95.jpg");
        game.turboCars.add(instanceof_Saab95);

        instanceof_Saab95.setPosition(Vector2.add(Vector2.zero(), 0, 200));

        Truck instanceof_Truck = new Truck(100, 100, Color.BLACK, "fn");
        frame.drawPanel.instantiate_image(instanceof_Truck, "pics/Scania.jpg");
        game.trucks.add(instanceof_Truck);
        
        instanceof_Truck.setPosition(Vector2.add(Vector2.zero(), 0, 400));
    }
}
