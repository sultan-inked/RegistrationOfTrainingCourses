/*
 * MainController - the main controller that manages the interaction
 * between the model and the view.
 */

package controllers;

import java.util.ArrayList;

import controllers.*;
import database.Database;
import models.*;
import tools.Cnsl;

public class MainController {
	// It's using in RegistrationView.java
	public String dataTransferToCreateStudentCardAndReturnId(String[] formArray) {
		var studentController = new StudentController();
		return studentController.createStudentCardSaveAndReturnId(formArray);
	}
	public String dataTransferToCreateTeacherCardAndReturnId(String[] formArray) {
		var teacherController = new TeacherController();
		return teacherController.createTeacherCardSaveAndReturnId(formArray);
	}
	public String dataTransferToCreateCourseCardAndReturnId(String[] formArray, Teacher teacher) {
		return new CourseController().createCourseCardSaveAndReturnId(formArray, teacher);
	}
	
	// It's using in LoginView.java
	public User idAndPasswordValidator(String userId, String userPassword) {
		var user = (User)Database.searchIdInList(userId);
		if(user == null) {
			return null;
		}
		if(user.getPassword().equals(userPassword)) {
			return user;
		}else {
			Cnsl.println("Invalid password!");
			return null;
		}
	}
	public User transferIdForValidate(String userId) {
		return (User)Database.searchIdInList(userId);
	}
	
	// Search user:
	public ArrayList<Teacher> searchTeacherAndReturAllOfMatches(String firstName, String lastName, String teacherId){
		return Database.searchTeacherInList(firstName, lastName, teacherId);
	}
	
	// It's using in CourseView.java
	public String getCourseIdSignature() {
		return Database.getCourseIdSignature();
	}
	
	
	
	public Course searchCourseById(String courseId) {
		if(courseId != null && !courseId.equals("")) {
			var course = Database.searchIdInList(courseId);
			if(course != null) {
				return (Course)course;
			}
		}
		return null;
	}
	
	public ArrayList<Course> searchCourseByNameAndReturnArrayList(String courseName){
		if(courseName != null && !courseName.equals("")) {
			return Database.searchCourseInListByName(courseName);
		}
		return null;
	}
	
	public ArrayList<Course> searchCourseBySeveralAuthorsAndReturnArrayList(ArrayList<Teacher> teachersFoundList){
		return Database.searchCourseBySeveralAuthors(teachersFoundList);
	}
	
	public void enrollInCourse(User user, Course course) {
		if(user == null || course == null) {
			Cnsl.println("Error: User or Course is empty(null)");
			return;
		}
		if(user instanceof Student) {
			var studentController = new StudentController();
			studentController.enrollInCourse(new CourseController(), course, user);
		}
		if(user instanceof Teacher) {
			var teacherController = new TeacherController();
			teacherController.enrollInCourse(new CourseController(), course, user);
		}
	}
	public void unenrollInCourse(User user, Course course) {
		if(user == null || course == null) {
			Cnsl.println("Error: User or Course is empty(MainController.java :95)");
			return;
		}
		if(user instanceof Student) {
			var studentController = new StudentController();
			studentController.unenrollInCourse(new CourseController(), course, user);
			studentController = null;		
		}
		if(user instanceof Teacher) {
			var teacherController = new TeacherController();
			teacherController.unenrollInCourse(new CourseController(), course, user);
			teacherController = null;
		}
	}
}
