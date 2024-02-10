/*
 * Student - a subclass of User, representing students with
 * additional attributes and methods.
 */

package model;

import tools.Id;

public class Student extends User {
//	Variables:
	private static int studentIdCounter = 0;
    private static String studentIdSignature = "STD000000";
    
//  Constructors:
    public Student(String firstName, String lastName, String password) {
		setFirstName(firstName);
		setLastName(lastName);
		setPassword(password);
		setUserId(Id.create(studentIdSignature, ++studentIdCounter));
	}
    
//    Getters and Setters:
    public static String getStudentIdSignature() {
    	return studentIdSignature;
    }
    
//    Methods:
    @Override
    public String toString() {
    	return "Student";
    }
}
