package view;

import registrationView.RegistrationView;
import tools.Alerts;
import tools.Cnsl;
import view.*;
import registrationView.*;

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
				new RegistrationView(new UserRegistrationView(new FormView(), new KeyWordValidatorView())).registration();
				start();
				return;
			case "exit":
				return;
			}
		}
	}
}
