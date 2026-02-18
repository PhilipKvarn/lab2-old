import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;

    // To keep track of a single car's position
    // Deprecated:
    // Point volvoPoint = new Point();

    public class VeichleImageTuple{
        Vehicle vehicle;
        BufferedImage img;
    }
    public ArrayList<VeichleImageTuple> VeichleImageList = new ArrayList<>();

    //
    //  Instantiates an ImageBuffer for a &veichle.
    //  Detta borde kanske inte göras här utan på ett annat ställe.
    //  
    //
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

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);

    // TODO: Make this general for all cars
    // Idealy borde vi inte behöva detta eftersom:
    // Positionen uppdateras samtidigt som vektorn av bilen uppdateras
    // Vilket betyder att vi inte behöver modifiera en variabel för en bildposition.
    /* void moveit(int x, int y){
        volvoPoint.x = x;
        volvoPoint.y = y;
    } */

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        try {
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
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}
