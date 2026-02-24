import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* Each step the TimerListener moves all the cars in the list and tells the
* view to update its images. Change this method to your needs.
*/
public class TimerListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
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

