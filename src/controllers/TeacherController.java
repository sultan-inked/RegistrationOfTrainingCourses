/*
 * TeacherController - a class that handles actions related to teacher.
 */

package controllers;

import database.DatabaseAddController;
import models.Course;
import models.Teacher;

public class TeacherController extends UserController {
//	Methods:
	public String createTeacherCardSaveAndReturnId(String[] listArray) {
		var teacher = new Teacher(listArray[0], listArray[1], listArray[2]);
		new DatabaseAddController().addTeacherToList(teacher);
		return teacher.getUserId();
	}
	
	public void createCourse(Teacher teacher, String courseName, String courseDescription, 
						DatabaseAddController databaseAddRemoveController) {
		Course course = new Course(teacher, courseName, courseDescription);
		databaseAddRemoveController.addCourseToList(course);
	}
	
	public void removeCourse() {
		// TODO: Make course remove feature!
	}
	
//	public void showCreatedCourseList(Teacher teacher) {
//		Course[] courses = teacher.getCreatedCourseListArray();
//		for(Course course: courses) {
//			String[] courseInfo = new CourseController().getCourseInfoArray(course);
//			for(String info: courseInfo) {
//				Cnsl.println(info);
//			}
//		}
//	}
}
