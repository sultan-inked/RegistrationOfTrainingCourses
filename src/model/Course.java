/*
 * Course - a class representing courses.
 */

package model;

import java.util.ArrayList;
import java.util.List;

import model.Teacher;
import tools.Id;

public class Course {
//	Variables:
	private String courseName, courseDescription, courseId;
    private Teacher courseCreator;
    
    private static int courseIdCounter = 0;
    private static final String courseIdSignature = "CRS000000";
    
    private List<Student> listOfEnrolledStudents = new ArrayList<>();
    private List<Teacher> listOfEnrolledTeachers = new ArrayList<>();
    
//	Constructors:
    public Course(Teacher courseCreator, String courseName, String courseDescription){
    	this.courseCreator = courseCreator;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseId = Id.create(courseIdSignature, courseIdCounter++);
    }
    
//	Getters and Setters:
    public static String getCourseIdSignature() {
    	return courseIdSignature;
    	
    }
    
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public Teacher getCourseCreator() {
		return courseCreator;
	}
	public void setCourseCreator(Teacher courseCreator) {
		this.courseCreator = courseCreator;
	}
	public List<Student> getListOfEnrolledStudents() {
		return listOfEnrolledStudents;
	}

	public List<Teacher> getListOfEnrolledTeachers() {
		return listOfEnrolledTeachers;
	}
    
//	Methods:
	
	public void addListOfEnrolledStudents(Student student) {
		this.listOfEnrolledStudents.add(student);
	}
	public void addListOfEnrolledTeachers(Teacher teacher) {
		this.listOfEnrolledTeachers.add(teacher);
	}
	
	public void removeListOfEnrolledStudent(int index) {
		this.listOfEnrolledStudents.remove(index);
	}
	
	public void removeListOfEnrolledTeacher(int index) {
		this.listOfEnrolledTeachers.remove(index);
	}
    
	@Override
	public String toString() {
		return "Course";
	}
}
