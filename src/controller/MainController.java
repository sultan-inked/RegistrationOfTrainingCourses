/*
 * MainController - the main controller that manages the interaction
 * between the model and the view.
 */

package controller;

public class MainController {
	public static String createStudentAndSaveReturnId(String[] formArray) {
		return StudentController.createAndSaveStudentReturnId(formArray);
	}
}
