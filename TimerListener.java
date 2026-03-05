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
    
    private ArrayList<TimerListeners> listeners = new ArrayList<TimerListeners>();
    
    public void actionPerformed(ActionEvent e) {
        for (TimerListeners l : listeners) {
            l.update();
        }
    }

    public void addListener(TimerListeners newListener){
        listeners.add(newListener);
    }

    public void removeListener(TimerListener removedListener){
        listeners.remove(removedListener);
    }


}

