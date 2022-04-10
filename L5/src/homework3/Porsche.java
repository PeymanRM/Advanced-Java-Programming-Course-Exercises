package homework3;

/**
 * Created by Peyman RM
 */
public class Porsche implements Car{
    private String color = "Grey";
    private int HP = 650;
    private Double acceleration = 3.9;

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
