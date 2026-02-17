import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;

    // To keep track of a single car's position
    Point volvoPoint = new Point();

    public class VeichleImageTuple{
        Vehicle vehicle;
        BufferedImage img;
    }
    public ArrayList<VeichleImageTuple> VeichleImageList = new ArrayList<>();

    public void instantiate_image(Vehicle v, String imgPath){
        try{
            VeichleImageTuple tuple = new VeichleImageTuple();
            tuple.vehicle = v;
            tuple.img = ImageIO.read(DrawPanel.class.getResourceAsStream(imgPath));
            VeichleImageList.add(tuple);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    //  Vi kan ändra detta genom att har en referens till
    //  Positionen av bilen i typ en tabell samt bilden vi vill rendera ut.
    //  Eftersom vi har en pekare så kommer pos uppdateras när vi uppdaterar den genom andra metoder.
    //  Så vi har:
    //  Vector2 vehicle_pos:     BufferedImage img_buffer:
    //[0]    &vehicle_pos0           img_buffer0
    //[1]    &vehicle_pos1           img_buffer1
    //[2]    &vehicle_pos2           img_buffer2
    

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);

    // TODO: Make this general for all cars
    // Idealy borde vi inte behöva detta eftersom:
    // Positionen uppdateras samtidigt som vektorn av bilen uppdateras
    // Vilket betyder att vi inte behöver modifiera en variabel för en bildposition.
    void moveit(int x, int y){
        volvoPoint.x = x;
        volvoPoint.y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (VeichleImageTuple tuple : VeichleImageList){
            Vector2 imgpos = tuple.vehicle.getPosition();
            g.drawImage(tuple.img, (int) imgpos.x, (int) imgpos.y, null);
        }
        //g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}
