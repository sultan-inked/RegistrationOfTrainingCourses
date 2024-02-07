/*
 * MainController - the main controller that manages the interaction
 * between the model and the view.
 */

package controller;

import database.Database;
import model.User;
import tools.Cnsl;
import model.Student;

public class MainController {
	// It's using in RegistrationView.java
	public static String dataTransferToCreateStudentCardAndReturnId(String[] formArray) {
		return StudentController.createStudentCardSaveAndReturnId(formArray);
	}
	public static String dataTransferToCreateTeacherCardAndReturnId(String[] formArray) {
		return TeacherController.createTeacherCardSaveAndReturnId(formArray);
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

	
}
