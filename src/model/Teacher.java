/*
 * Teacher - a subclass of User, representing teachers with
 * additional attributes and methods.
 */

package model;

import java.util.List;
import java.util.ArrayList;

import tools.Id;

public class Teacher extends User {
//	Variables:
	private static int teacherIdCounter = 0;
	private String teacherIdSignature = "TCH00000";
	
	private List<Course> createdCourse = new ArrayList<>();
	
//	Constructors:
	public Teacher(String firstName, String lastName, String password) {
		setFirstName(firstName);
		setLastName(lastName);
		setPassword(password);
		setUserId(Id.create(teacherIdSignature, teacherIdCounter));
	}
	
//	Methods:
	@Override
	public String toString() {
		return "Teacher";
	}
}
