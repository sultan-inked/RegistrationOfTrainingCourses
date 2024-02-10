/*
 * User - an abstract class representing common attributes and methods
 * for teachers and students.
 */

package model;

import java.util.List;
import java.util.ArrayList;

import model.Course;

public abstract class User {
//	Variables:
	private String firstName, lastName, userId, password;
	
	private List<Course> courseEnrollmentList = new ArrayList<>();

	//	Getters and Setters:
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Course> getCourseEnrollmentList() {
		return courseEnrollmentList;
	}

//	public void setCourseEnrollmentList(List<Course> courseEnrollmentList) {
//		this.courseEnrollmentList = courseEnrollmentList;
//	}
	
	public void addCourseEnrollmentList(Course course) {
		this.courseEnrollmentList.add(course);
	}
	
	public void removeCourseEnrollentList(Course course) {
		for(int i = 0; i < courseEnrollmentList.size(); i++) {
			if(courseEnrollmentList.get(i) == course) {
				courseEnrollmentList.remove(i);
			}
		}
	}
	

	
}
