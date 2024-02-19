/*
 * StudentController - a class that handles actions related to students.
 */

package controllers;

import database.DatabaseAddController;
import models.Student;

public class StudentController extends UserController {
//	Methods:
	public String createStudentCardSaveAndReturnId(String[] formArray) {
		var student = new Student(formArray[0], formArray[1], formArray[2]);
		new DatabaseAddController().addStudentToList(student);
		return student.getUserId();
	}
}
