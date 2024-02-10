/*
 * CourseController - a class that handles actions related to course.
 */

package controller;

import java.util.Arrays;

import model.User;
import tools.Cnsl;
import model.Student;
import model.Teacher;
import model.Course;
import database.Database;

public class CourseController {

	
//	Methods:
	public static String createCourseCardSaveAndReturnId(String[] formArray, Teacher teacher) {
		var course = new Course(teacher, formArray[0], formArray[1]);
		Database.addCourseToList(course);
		return course.getCourseId();
	}
	
	public static String[] getCourseInfoArray(Course course) {
		var courseInfoArray = new String[4];
		courseInfoArray[0] = "Author: " + course.getCourseCreator().getFirstName() + " " + course.getCourseCreator().getLastName();
		courseInfoArray[1] = "Name: " + course.getCourseName();
		courseInfoArray[2] = "Id: " + course.getCourseId();
		courseInfoArray[3] = "Description: " + course.getCourseDescription();
		return courseInfoArray;
		
	}
	
	public void registerUser(Course course, User user) {
		if(user instanceof Student) {
			course.addListOfEnrolledStudents((Student)user);
		}
	}
	public void unregisterUser(Course course, User user) {
		if(user instanceof Student) {
			course.removeListOfEnrolledStudent((Student)user);
		}
		if(user instanceof Teacher) {
			course.removeListOfEnrolledTeacher((Teacher)user);
		}
	}
}
