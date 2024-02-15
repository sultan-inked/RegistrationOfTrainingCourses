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
	
	private final UserRegistrationView userRegistrationView;
	
	public RegistrationView(UserRegistrationView userRegistrationView) {
		this.userRegistrationView = userRegistrationView;
	}
	
	public void registration() {
		Alerts.separator();
		Cnsl.println("Sign up");
		Cnsl.println("1. Student");
		Cnsl.println("2. Teacher");
		Cnsl.println("\'back\'");
		String choice;
		while(true) {
			Alerts.wrtHere();
			choice = Cnsl.scan();
			if(choice.equals("1") || choice.equals("2") || choice.equals("back")) {
				break;
			}else {
				Alerts.wrtNmbr();
			}
		}
		switch(choice) {
		case "1":
			// It will only be 'false' if the user was written 'back'
			if(userRegistrationView.student()) {
				break;
			}else {
				registration();
				break;
			}
		case "2":
			// It will only be 'false' if the user was written 'back'
			if(userRegistrationView.teacher()) {
				break;
			}else {
				registration();
				break;
			}
		case "back":
			return;
		}
	}
}
