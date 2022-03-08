package homework1;

/**
 * Created by Peyman RM
 */
public class Rectangle
{
    private float width, length;

    public void setWidth(float width) {
        this.width = width;
    }

    public void setLength(float length){
        this.length = length;
    }

    public float getArea() {
        return width*length;
    }

    public float getPerimeter(){
        return (width+length)*2;
    }
}
