/*
 * UserController - an abstract class that handles action related to user.
 */

package controller;

import model.User;
import model.Course;
import model.Student;
import tools.Cnsl;

public abstract class UserController {
//	Variables:
	
//	Constructors:
	public UserController() {
		
	}
	
//	Methods:
	public void showUserInfo(User user) {
    	Cnsl.println("Name: " + user.getFirstName());
    	Cnsl.println("Last name: " + user.getLastName());
    	if(!user.getUserId().equals(null)) {
    		Cnsl.println("Student Id:" + user.getUserId());
    	}
    }
	
	public void enrollInCourse(CourseController courseController, Course course, User user){
    	if(user.getCourseEnrollmentList().size() != 0) {
    		for(int i = 0; i < user.getCourseEnrollmentList().size(); i++) {
        		if(user.getCourseEnrollmentList().get(i).equals(course)) {
        			Cnsl.println("You are already enrolling on that course!");
        			return;
        		}
        	}
    	}
        Cnsl.println("You'r enrolled in course: " + course.getCourseName());
        user.addCourseEnrollmentList(course);
        courseController.registerUser(course, user);
    }
	
	public void unenrollInCourse(CourseController courseController, Course course, User user) {
    	if(user.getCourseEnrollmentList().size() != 0) {
    		for(int i = 0; i < user.getCourseEnrollmentList().size(); i++) {
        		if(user.getCourseEnrollmentList().get(i).getCourseId().equals(course.getCourseId())) {
        			user.removeCourseEnrollentList(course);
        			courseController.unregisterUser(course, user);
        			
        			Cnsl.println(course.getCourseName() + " was deleted of your course list!");
        			
        		}
        	}
    	}else {
    		Cnsl.println("Your enroll list is empty!");
    	}
    }
}
