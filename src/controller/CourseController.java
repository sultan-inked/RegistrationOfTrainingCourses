/*
 * CourseController - a class that handles actions related to course.
 */

package controller;

import model.User;
import model.Student;
import model.Teacher;
import model.Course;

public class CourseController {

	
//	Methods:
	public void registerUser(Course course, User user) {
		if(user instanceof Student) {
			course.addListOfEnrolledStudents((Student)user);
		}
	}
	public void unregisterUser(Course course, User user, int index) {
		if(user instanceof Student) {
			course.removeListOfEnrolledStudent(index);
		}
	}
}
