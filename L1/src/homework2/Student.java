package homework2;

/**
 * Created by Peyman RM
 */
public class Student {
    private int[] coefficients;
    private double[] grades;
    private int lessonsCount;

    public Student(int lessonsCount, double[] grades, int[] coefficients){
        this.lessonsCount = lessonsCount;
        this.coefficients = new int[lessonsCount];
        this.grades = new double[lessonsCount];

        for(int i = 0; i < lessonsCount; i++) {
            this.grades[i] = grades[i];
            this.coefficients[i] = coefficients[i];
        }
    }

    public double getAverage() {
        double sumOfGrades = 0;
        double sumOfCoefficients = 0;
        for(int i = 0; i < lessonsCount; i++){
            sumOfGrades = sumOfGrades + grades[i]*coefficients[i];
            sumOfCoefficients += coefficients[i];
        }
        return sumOfGrades/sumOfCoefficients;
    }
}
