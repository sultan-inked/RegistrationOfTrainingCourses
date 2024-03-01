/*
 * Teacher - a subclass of User, representing teachers with
 * additional attributes and methods.
 */

package models;

import java.util.List;
import java.util.ArrayList;

import tools.Id;

public class Teacher extends User {
//	Variables:
	private static int teacherIdCounter = 0;
	private String teacherIdSignature = "TCH000000";
	
	private List<Course> createdCourseList = new ArrayList<>();
	
//	Constructors:
	public Teacher() {
		
	}
	
	public Teacher(String firstName, String lastName, String password) {
		setFirstName(firstName);
		setLastName(lastName);
		setPassword(password);
		setUserId(new Id().create(teacherIdSignature, ++teacherIdCounter));
	}
	
//	Getters and Setters:
	public String getTeacherIdSignature() {
		return teacherIdSignature;
	}
	
	public Course[] getCreatedCourseListArray() {
		return createdCourseList.toArray(new Course[createdCourseList.size()]);
	}
	
	public void addToCreatedCourseList(Course course) {
		createdCourseList.add(course);
	}
	
//	Methods:
	@Override
	public String toString() {
		return "Teacher";
	}
}
