import java.util.Random;

public class CarFactory {
    public static Volvo240 createVolvo240(){
        return new Volvo240();
    }
    
    public static Saab95 createSaab95(){
        return new Saab95();
    }
    
    public  static Scania createScania(){
        return new Scania();
    }

    public static Vehicle createRandomVehicle(){
        Random generator = new Random();
        int randint = generator.nextInt(3);
        System.out.println(randint);
        switch (randint) {
            case 0:
                return createVolvo240();
            case 1:
                return createSaab95();
            case 2:
                return createScania();
            default:
                return createVolvo240();
        }
    }
}
