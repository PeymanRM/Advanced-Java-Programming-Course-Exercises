package homework3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peyman RM
 */
public class Student <userdata> {
    private userdata studentCode, name, fatherName;
    private List<Double> grades = new ArrayList<>();

    public void setName(userdata name) {
        this.name = name;
    }

    public void setStudentCode(userdata studentCode) {
        this.studentCode = studentCode;
    }

    public void setFatherName(userdata fatherName) {
        this.fatherName = fatherName;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    public userdata getName() {
        return name;
    }

    public userdata getStudentCode() {
        return studentCode;
    }

    public userdata getFatherName() {
        return fatherName;
    }

    public List<Double> getGrades() {
        return grades;
    }
}
