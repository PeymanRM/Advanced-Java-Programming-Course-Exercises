package homework3;

/**
 * Created by Peyman RM
 */
public class CarFactory {
    public static Car getCar(int i) {
        return switch (i) {
            case 1 -> new BMW();
            case 2 -> new Porsche();
            case 3 -> new Ferrari();
            default -> null;
        };
    }
}
