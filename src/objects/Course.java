package objects;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import interfaces.User;

public class Course {
    public static void println(String str){
        System.out.println(str);
    }
//    Parameters:
    private String courseName, courseDescription, courseId;
    private Teacher courseCreator;

    private ArrayList<Student> studentInCrsList = new ArrayList<Student>();
    private ArrayList<Teacher> teacherInCrsList = new ArrayList<>();

    
//    Constructors:
    public Course(Teacher courseCreator, String courseName, String courseDescription){
    	this.courseCreator = courseCreator;
//        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
    }
//    Getters and Setters:
    public String getCourseName(){
        if(this.courseName.trim().equals("")){
            return "Error: The course name is empty!";
        }
        else return this.courseName;
    }
    
    public String getCourseDescription() {
    	return courseDescription;
    }
    
    public String getCourseId(){
        if(this.courseId.trim().equals("")){
            return "Error: The student Id is empty!";
        }
        else return this.courseId;
    }
    public void setCourseId(String newCourseId) {
    	this.courseId = newCourseId;
    }
    
    public String getCourseAutorFullName() {
    	return (courseCreator.getTeacherFirstName() + " " + courseCreator.getTeacherLastName());
    }
    
//    Methods:
    public void showCourseInfo() {
    	println("Course name: " + courseName);
    	println("Course Id:" + courseId);
    	println("Creator: " + courseCreator.getTeacherFirstName());
    	println("Course description: " + courseDescription);
    }
    
    public void registerUser(User user){
    	String userDefinition = "Student";
    	if(user == null) {
    		if(user instanceof Teacher) {
    			userDefinition = "Teacher";
    		}
    		println("Error: " + userDefinition + " card is empty!");
    		return;
    	}//#####################################################
    	
    	if(user instanceof Student) {
    		for(int i = 0; i < studentInCrsList.size(); i++) {
        		if(studentInCrsList.get(i).getStudentId().equals(((Student)user).getStudentId())) {
        			println("Student with Id:" + ((Student)user).getStudentId() + " is already registered!");
        		}
        	}
            studentInCrsList.add((Student)user);
            println("The student: " + ((Student)user).getStudentFirstName() + " is register on " + getCourseName() + " course!");
    	}
    	if(user instanceof Teacher) {
    		for(int i = 0; i < studentInCrsList.size(); i++) {
        		if(teacherInCrsList.get(i).getTeacherId().equals(((Teacher)user).getTeacherId())) {
        			println("Teacher with Id:" + ((Teacher)user).getTeacherId() + " is already registered!");
        		}
        	}
            teacherInCrsList.add((Teacher)user);
            println("The teacher: " + ((Teacher)user).getTeacherFirstName() + " is register on " + getCourseName() + " course!");
    	}
    	
    	
    }
    
    public void unregisterStudent(Student student) {
    	if(student == null) {
    		println("Error: Student card is empty!");
    		return;
    	}
    	if(studentInCrsList.size() == 0) {
    		println("Students list is empty!");
    		return;
    	}
    	for(int i = 0; i < studentInCrsList.size(); i++) {
    		if(studentInCrsList.get(i).getStudentId().equals(student.getStudentId())) {
    			println("Student with Id:" + student.getStudentId() + " is unregistered of " + this.courseName);
    			studentInCrsList.remove(i);
    			return;
    		}
    	}
    	println("Student with Id:" + student.getStudentId() + " is not registered in course " + this.courseName);
    	
    }
    
    public void showStudentList(){
        println("There are " + studentInCrsList.size() +" students enrolled in the " + getCourseName() + " course:");
        for(int i = 0; i < studentInCrsList.size(); i++){
            println("" + studentInCrsList.get(i).getStudentLastName() + studentInCrsList.get(i).getStudentLastName());
        }
    }
}
