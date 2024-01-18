package objects;

import java.util.ArrayList;

public class Student {
    public static void println(String str){
        System.out.println(str);
    }
//    Parameters:
    private String firstName, lastName, studentId, password;
    
    private ArrayList<Course> enrollCourseList = new ArrayList<Course>();
    
//    Constructors:
    public Student(String firstName, String lastName, String password){
    	this.lastName = lastName;
    	this.firstName = firstName;
//        this.studentId = studentId;
        this.password = password;        
    }
    
//    Setters and Getters:
    public String getStudentFirstName(){
        if(this.firstName.trim().equals("")){
            return "Error: The student name is empty!";
        }
        else return this.firstName;
    }
    
    public String getStudentLastName(){
        if(this.lastName.trim().equals("")){
            return "Error: The student name is empty!";
        }
        else return this.lastName;
    }
    
    public String getStudentId(){
        if(this.studentId.trim().equals("")){
            return "Error: The student Id is empty!";
        }
        else return this.studentId;
    }
    public void setStudentId(String newStudentId) {
    	this.studentId = newStudentId;
    }
    
//    Methods:
    public void showStudentInfo() {
    	println("Name: " + firstName);
    	println("Last name: " + lastName);
    	println("Student Id:" + studentId);
    }
    
    public void enrollInCourse(Course course){
        println("Enroll in course: " + course.getCourseName());
        course.registerStudent(this);
        enrollCourseList.add(course);
    }
    
    public void unenrollInCourse(Course course) {
    	println("Unenroll in course: " + course.getCourseName());
    	course.unregisterStudent(this);
    	for(int i = 0; i < enrollCourseList.size(); i++) {
    		if(enrollCourseList.get(i).getCourseId().equals(course.getCourseId())) {
    			println(course.getCourseName() + " was deleted of course list!");
    		}
    	}
    }
    
    public void showEnrollCourse() {
    	if(enrollCourseList.size() == 0) {
    		println("Course list is empty.");
    	}
    	for(int i = 0; i < enrollCourseList.size(); i++) {
    		enrollCourseList.get(i).getCourseName();
    	}
    }
}
