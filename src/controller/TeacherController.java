/*
 * TeacherController - a class that handles actions related to teacher.
 */

package controller;

import model.Teacher;
import model.Course;
import database.Database;

public class TeacherController extends UserController {
//	Methods:
	public String createTeacherCardSaveAndReturnId(String[] listArray) {
		var teacher = new Teacher(listArray[0], listArray[1], listArray[2]);
		Database.addTeacherToList(teacher);
		return teacher.getUserId();
	}
	
	public void createCourse(Teacher teacher, String courseName, String courseDescription) {
		Course course = new Course(teacher, courseName, courseDescription);
		Database.addCourseToList(course);
	}
	
	public void removeCourse() {
		// TODO: Make course remove feature!
	}
}
