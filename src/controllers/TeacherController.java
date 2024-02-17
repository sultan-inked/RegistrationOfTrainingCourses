/*
 * TeacherController - a class that handles actions related to teacher.
 */

package controllers;

import database.DatabaseAddRemoveController;
import models.Course;
import models.Teacher;

public class TeacherController extends UserController {
//	Methods:
	public String createTeacherCardSaveAndReturnId(String[] listArray) {
		var teacher = new Teacher(listArray[0], listArray[1], listArray[2]);
		new DatabaseAddRemoveController().addTeacherToList(teacher);
		return teacher.getUserId();
	}
	
	public void createCourse(Teacher teacher, String courseName, String courseDescription, 
						DatabaseAddRemoveController databaseAddRemoveController) {
		Course course = new Course(teacher, courseName, courseDescription);
		databaseAddRemoveController.addCourseToList(course);
	}
	
	public void removeCourse() {
		// TODO: Make course remove feature!
	}
}
