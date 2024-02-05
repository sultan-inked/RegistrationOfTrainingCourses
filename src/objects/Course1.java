package objects;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import interfaces.User;

public class Course1 {
    public static void println(String str){
        System.out.println(str);
    }
//    Parameters:
    private String courseName, courseDescription, courseId;
    private Teacher1 courseCreator;

    private ArrayList<Student1> studentInCrsList = new ArrayList<Student1>();
    private ArrayList<Teacher1> teacherInCrsList = new ArrayList<>();

    
//    Constructors:
    public Course1(Teacher1 courseCreator, String courseName, String courseDescription){
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
    		if(user instanceof Teacher1) {
    			userDefinition = "Teacher";
    		}
    		println("Error: " + userDefinition + " card is empty!");
    		return;
    	}
    	
    	if(user instanceof Student1) {
    		for(int i = 0; i < studentInCrsList.size(); i++) {
        		if(studentInCrsList.get(i).getStudentId().equals(((Student1)user).getStudentId())) {
        			println("Student with Id:" + ((Student1)user).getStudentId() + " is already registered!");
        		}
        	}
            studentInCrsList.add((Student1)user);
            println("The student: " + ((Student1)user).getStudentFirstName() + " is register on " + getCourseName() + " course!");
    	}
    	if(user instanceof Teacher1) {
    		for(int i = 0; i < studentInCrsList.size(); i++) {
        		if(teacherInCrsList.get(i).getTeacherId().equals(((Teacher1)user).getTeacherId())) {
        			println("Teacher with Id:" + ((Teacher1)user).getTeacherId() + " is already registered!");
        		}
        	}
            teacherInCrsList.add((Teacher1)user);
            println("The teacher: " + ((Teacher1)user).getTeacherFirstName() + " is register on " + getCourseName() + " course!");
    	}
    	
    	
    }
    
    public void unregisterUser(User user) {
    	String userDefinition = "Student";
    	if(user instanceof Teacher1) {
    		userDefinition = "Teacher";
    	}
    	if(user == null) {
    		println("Error: " + userDefinition + " card is empty!");
    		return;
    	}
    	
    	if(user instanceof Student1) {
    		if(studentInCrsList.size() == 0) {
        		println(userDefinition + " list is empty!");
        		return;
        	}
        	for(int i = 0; i < studentInCrsList.size(); i++) {
        		if(studentInCrsList.get(i).getStudentId().equals(((Student1)user).getStudentId())) {
        			println(userDefinition + " with Id:" + ((Student1)user).getStudentId() + " is unregistered of " + this.courseName);
        			studentInCrsList.remove(i);
        			return;
        		}
        	}
        	println(userDefinition + " with Id:" + ((Student1)user).getStudentId() + " is not registered in course " + this.courseName);
    	}
    	
    	if(user instanceof Teacher1) {
    		if(teacherInCrsList.size() == 0) {
        		println(userDefinition + " list is empty!");
        		return;
        	}
        	for(int i = 0; i < teacherInCrsList.size(); i++) {
        		if(teacherInCrsList.get(i).getTeacherId().equals(((Teacher1)user).getTeacherId())) {
        			println(userDefinition + " with Id:" + ((Teacher1)user).getTeacherId() + " is unregistered of " + this.courseName);
        			teacherInCrsList.remove(i);
        			return;
        		}
        	}
        	println(userDefinition + " with Id:" + ((Teacher1)user).getTeacherId() + " is not registered in course " + this.courseName);
    	}
    	
    	
    }
    
    public void showStudentList(){
        println("There are " + studentInCrsList.size() +" students enrolled in the " + getCourseName() + " course:");
        for(int i = 0; i < studentInCrsList.size(); i++){
            println("" + studentInCrsList.get(i).getStudentLastName() + studentInCrsList.get(i).getStudentLastName());
        }
    }
}
