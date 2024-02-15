/*
 * RegistrationView - class representing the registration and authorization form.
 */

package registrationView;

import java.util.Arrays;

import controller.MainController;
import tools.Alerts;
import tools.Cnsl;
import view.WelcomeView;

public class RegistrationView {
	
	public void registration() {
		Alerts.separator();
		Cnsl.println("Sign up");
		Cnsl.println("1. Student");
		Cnsl.println("2. Teacher");
		Cnsl.println("\'back\'");
		String choice = studentOrTeacher();
		switch(choice) {
		case "Student":
			// It will only be 'false' if the user was written 'back'
			if(new UserRegistrationView().studentOrTeacherRegistration(choice)) {
				break;
			}else {
				registration();
				break;
			}
		case "Teacher":
			// It will only be 'false' if the user was written 'back'
			if(new UserRegistrationView().studentOrTeacherRegistration(choice)) {
				break;
			}else {
				registration();
				break;
			}
		case "back":
			return;
		}
	}
	public String studentOrTeacher() {
		while(true) {
			Cnsl.print("Here:");
			String choice = Cnsl.scan();
			switch(choice) {
			case "1":
				return "Student";
			case "2":
				return "Teacher";
			case "back":
				return "back";
				default:
					Alerts.wrtNmbr();
			}
		}
	}
}
