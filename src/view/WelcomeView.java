package view;

import registrationView.RegistrationView;
import tools.Alerts;
import tools.Cnsl;
import view.*;

public class WelcomeView {
	public void start() {
		Alerts.separator();
		Cnsl.println("Hello there!");
		Cnsl.println("Just write number with your choice");
		Cnsl.println("1. Login");
		Cnsl.println("2. Sign up");
		Cnsl.println("\'exit\'");
		while(true) {
			Alerts.wrtHere();
			String choice = Cnsl.scan();
			switch(choice) {
			case "1":
				var loginView = new LoginView();
				loginView.login();
				start();
				return;
			case "2":
				var registrationView = new RegistrationView();
				registrationView.registration();
				registrationView = null;
				start();
				return;
			case "exit":
				return;
			}
		}
	}
}
