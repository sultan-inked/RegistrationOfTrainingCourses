/*
 * StudentController - a class that handles actions related to students.
 */

package controller;

import model.Student;
import database.Database;

public class StudentController extends UserController {
//	Methods:
	public String createStudentCardSaveAndReturnId(String[] formArray) {
		var student = new Student(formArray[0], formArray[1], formArray[2]);
		Database.addStudentToList(student);
		return student.getUserId();
	}
}
