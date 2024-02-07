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
	public static String createStudentAndSaveReturnId(String[] formArray) {
		return StudentController.createAndSaveStudentReturnId(formArray);
	}
	
	public static User idPasswordValidator(String userId, String userPassword) {
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
