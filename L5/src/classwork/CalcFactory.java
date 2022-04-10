package classwork;

/**
 * Created by Peyman RM
 */
public class CalcFactory {
    public static Calculate getCalc(char operator){
        return switch (operator) {
            case '+' -> new CalcPlus();
            case '-' -> new CalcMinus();
            default -> null;
        };
    }
}
