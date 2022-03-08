package homework3;

/**
 * Created by Peyman RM
 */
public class EquationSolver {
    private double a,b,c,d,e,f;

    public void setEquation1 (double a, double b, double e){
        this.a = a;
        this.b = b;
        this.e = e;
    }

    public void setEquation2 (double c, double d, double f){
        this.c = c;
        this.d = d;
        this.f = f;
    }

    public void getSolution() {
        if(a*d-b*c == 0){
            System.out.println("Cannot Solve");
        } else {
            System.out.println("x=" + ((e*d-b*f)/(a*d-b*c)) + "\t\ty=" + ((a*f-e*c)/(a*d-b*c)));
        }
    }
}
