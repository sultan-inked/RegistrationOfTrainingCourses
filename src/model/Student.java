/*
 * Student - a subclass of User, representing students with
 * additional attributes and methods.
 */

package model;

import tools.Id;

public class Student extends User {
//	Variables:
	private static int studentIdCounter = 0;
    private String studentIdSignature = "STD000000";
    
    public Student(String firstName, String lastName, String password) {
		setFirstName(firstName);
		setLastName(lastName);
		setPassword(password);
		setUserId(Id.create(studentIdSignature, studentIdCounter++));
	}
    
    @Override
    public String toString() {
    	return "Student";
    }
}
