package a0;

/**
 * Created by Peyman RM
 */
public class Rectangle
{
    private float width = 1, length = 1;

    public void setWidth(float width) {
        if(width < 20.0 && width > 0.0 )
            this.width = width;
        else
            System.out.println("Invalid input!");
    }

    public void setLength(float length){
        if(length < 20.0 && length > 0.0 )
            this.length = length;
        else
            System.out.println("Invalid input!");
    }

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
    }

    public float getArea() {
        return width*length;
    }

    public float getPerimeter(){
        return (width+length)*2;
    }
}
