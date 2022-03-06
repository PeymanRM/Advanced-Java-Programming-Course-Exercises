package homework2;

/**
 * Created by Peyman RM
 */
public class Course {
    private int coefficient;
    private String courseName;
    private Course[] prerequisites, corequisites;

    Course(String courseName, int coefficient, int preCount, int coCount){
        this.courseName = courseName;
        this.coefficient = coefficient;
        if(preCount != 0) prerequisites = new Course[preCount];
        if(coCount != 0) corequisites = new Course[coCount];
    }

    public void addPrerequisite(Course prerequisite) {
        if (prerequisites != null) {
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i] == null) {
                    prerequisites[i] = prerequisite;
                    break;
                }
            }
        }
    }

    public void addCorequisite(Course corequisite) {
        if (corequisites != null) {
            for (int i = 0; i < corequisites.length; i++) {
                if (corequisites[i] == null) {
                    corequisites[i] = corequisite;
                    break;
                }
            }
        }
    }

    public void getCourseInfo(){
        System.out.println("Course Name: " + courseName + "\t\tCoefficient: " + coefficient);
        if(prerequisites != null){
            System.out.println("Prerequisites: ");
            for (Course prerequisite : prerequisites) {
                System.out.println("\t" + prerequisite.courseName);
            }
        }else System.out.println("No prerequisites");

        if(corequisites != null){
            System.out.println("Corequisites: ");
            for (Course corequisite : corequisites) {
                System.out.println("\t" + corequisite.courseName);
            }
        }else System.out.println("No corequisites");
        System.out.println();
    }
}
