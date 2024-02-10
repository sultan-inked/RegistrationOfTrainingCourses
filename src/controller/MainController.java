/*
 * MainController - the main controller that manages the interaction
 * between the model and the view.
 */

package controller;

import database.Database;
import model.*;
import tools.Cnsl;
import controller.*;

public class MainController {
	// It's using in RegistrationView.java
	public static String dataTransferToCreateStudentCardAndReturnId(String[] formArray) {
		return StudentController.createStudentCardSaveAndReturnId(formArray);
	}
	public static String dataTransferToCreateTeacherCardAndReturnId(String[] formArray) {
		return TeacherController.createTeacherCardSaveAndReturnId(formArray);
	}
	public static String dataTransferToCreateCourseCardAndReturnId(String[] formArray, Teacher teacher) {
		return CourseController.createCourseCardSaveAndReturnId(formArray, teacher);
	}
	// It's using in LoginView.java
	public static User idAndPasswordValidator(String userId, String userPassword) {
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
	
	// It's using in CourseView.java
	public static Course searchCourseById(String courseId) {
		if(courseId != null && !courseId.equals("")) {
			return (Course)Database.searchIdInList(courseId);
		}
		return null;
	}
	
	public static void enrollInCourse(User user, Course course) {
		if(user == null || course == null) {
			Cnsl.println("Error: User or Course is empty(null)");
			return;
		}
		if(user instanceof Student) {
			var studentController = new StudentController();
			studentController.enrollInCourse(new CourseController(), course, user);
			studentController = null;
		}
		if(user instanceof Teacher) {
			var teacherController = new TeacherController();
			teacherController.enrollInCourse(new CourseController(), course, user);
			teacherController = null;
		}
	}
	
	public static void unenrollInCourse(User user, Course course) {
		if(user == null || course == null) {
			Cnsl.println("Error: User or Course is empty(null)");
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
