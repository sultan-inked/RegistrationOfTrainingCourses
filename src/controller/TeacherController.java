/*
 * TeacherController - a class that handles actions related to teacher.
 */

package controller;

import model.Teacher;
import model.Course;
import database.Database;

public class TeacherController {
//	Methods:
	public static void createCourse(Teacher teacher, String courseName, String courseDescription) {
		Course course = new Course(teacher, courseName, courseDescription);
		Database.addCourseToList(course);
	}
	
	public static void removeCourse() {
		// TODO: Make course remove feature!
	}
}
