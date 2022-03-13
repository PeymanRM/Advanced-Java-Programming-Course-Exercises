package homework2;

/**
 * Created by Peyman RM
 */
public class QuadraticEquation {
    private double a,b,c,delta;
    private double[] answers = new double[2];

    public QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] getAnswers() throws EquationException {
        delta = (b*b - 4*a*c);
        if(delta<0) throw new EquationException("Negative Delta - No answers");
        answers[0] = (-b + Math.sqrt(delta))/(2*a);
        answers[1] = (-b - Math.sqrt(delta))/(2*a);
        return answers;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }
}
