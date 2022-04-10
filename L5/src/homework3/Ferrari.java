package homework3;

/**
 * Created by Peyman RM
 */
public class Ferrari implements Car{
    private String color = "Red";
    private int HP = 700;
    private Double acceleration = 4.8;

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
