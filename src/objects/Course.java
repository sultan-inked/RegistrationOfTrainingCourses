package objects;

import java.util.Arrays;
import java.util.ArrayList;

public class Course {
    public static void println(String str){
        System.out.println(str);
    }
//    Parameters:
    private String courseId;
    private String courseName;
//    private Student[] student;
    private ArrayList<Student> student = new ArrayList<Student>();
//    private ArrayList<Student> student;
    
//    Constructors:
    public Course(String courseId, String courseName){
        this.courseId = courseId;
        this.courseName = courseName;
    }
//    Getters and Setters:
    public String getCourseName(){
        if(this.courseName.trim().equals("")){
            return "Error: The course name is empty!";
        }
        else return this.courseName;
    }
//    Methods:
    public void registerStudent(Student student){
//        if(student == null) student = new ArrayList<Student>();
        this.student.add(student);
        println("The student: " + student.getStudentName() + " is register on " + getCourseName() + " course!");
    }
    
    public void showStudentList(){
        println("There are " + this.student.size() +" students enrolled in the " + getCourseName() + " course:");
        for(int i = 0; i < this.student.size(); i++){
            println("" + this.student.get(i).getStudentName());
        }
    }
}
