package homework2;

/**
 * Created by Peyman RM
 */
public class Main {
    public static void main(String[] args) {
        Course[] prerequisites, corequisites;
        Course c1 = new Course("ریاضی 1",3,0,0);
        Course c2 = new Course("ریاضی 2",3,1,0);
        c2.addPrerequisite(c1);
        Course c3 = new Course("مبانی کامپیوتر",3,0,0);
        Course c4 = new Course("ریاضیات گسسته",3,0,2);
        c4.addCorequisite(c1);
        c4.addCorequisite(c3);

        c1.getCourseInfo();
        c2.getCourseInfo();
        c3.getCourseInfo();
        c4.getCourseInfo();

    }
}
