/*
 * TeacherController - a class that handles actions related to teacher.
 */

package controllers;

import database.Database;
import models.Course;
import models.Teacher;

public class TeacherController extends UserController {
//	Methods:
	public String createTeacherCardSaveAndReturnId(String[] listArray, Database database) {
		var teacher = new Teacher(listArray[0], listArray[1], listArray[2]);
		database.addTeacherToList(teacher);
		return teacher.getUserId();
	}
	
	public void createCourse(Teacher teacher, String courseName, String courseDescription, Database database) {
		Course course = new Course(teacher, courseName, courseDescription);
		database.addCourseToList(course);
	}
	
	public void removeCourse() {
		// TODO: Make course remove feature!
	}
}
