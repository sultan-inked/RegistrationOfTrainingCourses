package objects;

import java.util.ArrayList;

public class Teacher extends Student {
//	public void println(String str) {
//		System.out.println(str);
//	}
	
//	Parameters:
	private String teacherId, firstName, lastName, password;
	
	private ArrayList<Course> createdCoursesList = new ArrayList<Course>();
	
//	Constructors:
	public Teacher() {
		
	}
	public Teacher(String firstName, String lastName, String password){
    	this.lastName = lastName;
    	this.firstName = firstName;
        this.password = password;        
    }
	
//	Getters and Setters:
	public String getTeacherFirstName(){
        if(this.firstName.trim().equals("")){
            return "Error: The teacher name is empty!";
        }
        else return this.firstName;
    }
    
    public String getTeacherLastName(){
        if(this.lastName.trim().equals("")){
            return "Error: The teacher name is empty!";
        }
        else return this.lastName;
    }
    
    public String getTeacherId(){
        if(this.teacherId.trim().equals("")){
            return "Error: The teacher Id is empty!";
        }
        else return this.teacherId;
    }
    public void setTeacherId(String newTeacherId) {
    	this.teacherId = newTeacherId;
    }
    
    public String getTeacherPassword() {
    	return password;
    }
	
//	Methods:
    public void showTeacherInfo() {
    	println("Name: " + firstName);
    	println("Last name: " + lastName);
//    	println("Teacher Id:" + teacherId);
    }
    
    public void addCourseToList(Course course) {
    	createdCoursesList.add(course);
    }
    
}
