package objects;

import java.util.ArrayList;
import interfaces.User;

public class Student implements User{
    public static void println(String str){
        System.out.println(str);
    }
//    Parameters:
    private String firstName, lastName, studentId, password;
    
    private ArrayList<Course> enrollCourseList = new ArrayList<Course>();
    
    
    
//    Constructors:
    public Student() {
    	
    }
    
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
    
    public String getStudentPassword() {
    	return password;
    }
    
//    Methods:
    @Override
    public void showUserInfo() {
    	println("Name: " + firstName);
    	println("Last name: " + lastName);
//    	println("Student Id:" + studentId);
    }
    
    @Override
    public void enrollInCourse(Course course, User user){
    	if(enrollCourseList.size() != 0) {
    		for(int i = 0; i < enrollCourseList.size(); i++) {
        		if(enrollCourseList.get(i).equals(course)) {
        			println("You are already enrolling on that course!");
        			return;
        		}
        	}
    	}
        println("Enroll in course: " + course.getCourseName());
        enrollCourseList.add(course);
        course.registerUser((Student)user);
    }
    
    @Override
    public void unenrollInCourse(Course course, User user) {
    	if(enrollCourseList.size() != 0) {
    		for(int i = 0; i < enrollCourseList.size(); i++) {
        		if(enrollCourseList.get(i).getCourseId().equals(course.getCourseId())) {
        			println(course.getCourseName() + " was deleted of course list!");
        			enrollCourseList.remove(i);
        			course.unregisterUser((Student)user);
        		}
        	}
    	}
    	println("Your enroll list is empty!");
    }
    
    @Override
    public void showEnrollCourseList() {
    	if(enrollCourseList.size() == 0) {
    		println("Course list is empty.");
    	}
    	for(int i = 0; i < enrollCourseList.size(); i++) {
    		enrollCourseList.get(i).getCourseName();
    	}
    }
}
