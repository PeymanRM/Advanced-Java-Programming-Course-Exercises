package homework3;

/**
 * Created by Peyman RM
 */
public class BMW implements Car{
    private String color = "Black";
    private int HP = 600;
    private Double acceleration = 3.6;

    public Double getAcceleration() {
        return acceleration;
    }

    public int getHP() {
        return HP;
    }

    public String getColor() {
        return color;
    }
}
