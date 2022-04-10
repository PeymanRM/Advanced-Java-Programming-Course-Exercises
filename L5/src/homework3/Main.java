package homework3;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        Car bCar = CarFactory.getCar(Car.BMW);
        Car pCar = CarFactory.getCar(Car.Porsche);
        Car fCar = CarFactory.getCar(Car.Ferrari);
        System.out.println("BMW color: " + bCar.getColor());
        System.out.println("Porsche color: " + pCar.getColor());
        System.out.println();
        System.out.println("Ferrari HP: " + fCar.getHP());
        System.out.println("BMW HP: " + bCar.getHP());
    }
}
