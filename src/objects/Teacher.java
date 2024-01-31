package objects;

import java.util.ArrayList;

import interfaces.User;

public class Teacher implements User{
	public void println(String str) {
		System.out.println(str);
	}
	
//	Parameters:
	private String teacherId, firstName, lastName, password;
	
	private ArrayList<Course> enrollCourseList = new ArrayList<>();
	private ArrayList<Course> createdCoursesList = new ArrayList<>();
	
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
    
    @Override
    public void showUserInfo() {
    	println("Name: " + firstName);
    	println("Last name: " + lastName);
//    	println("Teacher Id:" + teacherId);
    }
    
    
	@Override
	public void enrollInCourse(Course course, User user) {
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
        course.registerUser((Teacher)user);
		
	}
	@Override
	public void unenrollInCourse(Course course, User user) {
		if(enrollCourseList.size() != 0) {
    		for(int i = 0; i < enrollCourseList.size(); i++) {
        		if(enrollCourseList.get(i).getCourseId().equals(course.getCourseId())) {
        			println(course.getCourseName() + " was deleted of course list!");
        			enrollCourseList.remove(i);
        			course.unregisterUser((Teacher)user);
        		}
        	}
    	}
    	println("Your enroll list is empty!");
		
	}
	@Override
	public void showEnrollCourseList() {
		// TODO Auto-generated method stub
		
	}
	
	public void addCourseToList(Course course) {
    	createdCoursesList.add(course);
    }
}
