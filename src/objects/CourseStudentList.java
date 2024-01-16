
package objects;
import java.util.Arrays;
import java.util.ArrayList;

public class CourseStudentList {
    ArrayList<Course> courseList = new ArrayList<Course>();
    ArrayList<Student> studentList = new ArrayList<Student>();
    
    public void addCourse(Course course){
        this.courseList.add(course);
    }
    
    public void addStudent(Student student){
        this.studentList.add(student);
    }
}
