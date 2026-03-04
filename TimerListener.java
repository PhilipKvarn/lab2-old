import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Observerpattern ?!!??!?!?! 
// idk verkar som en ok idée som vi kan implomentera här eller nått.
// game/main observerar detta och kallar på detta.
// Men vi vill inte implomentera vad funktionen ska göra här
// Utan det ska vara i klassen som vill göra något när timerListener händer frfrfrfrfrfr.


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

        /* for (Vehicle car : cars) {
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
        } */
    }
}

