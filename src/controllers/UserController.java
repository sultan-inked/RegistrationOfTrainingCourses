/*
 * UserController - an abstract class that handles action related to user.
 */

package controllers;

import models.Course;
import models.User;
import tools.Cnsl;

public abstract class UserController {
//	Variables:
	
//	Constructors:
	public UserController() {
		
	}
	
//	Methods:
	public Course[] getCourseEnrollmentListArray(User user) {
		return user.getCourseEnrollmentListArray();
	}
	
	public void showUserInfo(User user) {
    	Cnsl.println("Name: " + user.getFirstName());
    	Cnsl.println("Last name: " + user.getLastName());
    	if(!user.getUserId().equals(null)) {
    		Cnsl.println("Id:" + user.getUserId());
    	}
    }
	
	public void enrollInCourse(CourseController courseController, Course course, User user){
    	if(user.getCourseEnrollmentListArray().length != 0) {
    		for(int i = 0; i < user.getCourseEnrollmentListArray().length; i++) {
        		if(user.getCourseEnrollmentListArray()[i].equals(course)) {
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
    	if(user.getCourseEnrollmentListArray().length != 0) {
    		for(int i = 0; i < user.getCourseEnrollmentListArray().length; i++) {
        		if(user.getCourseEnrollmentListArray()[i].getCourseId().equals(course.getCourseId())) {
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
