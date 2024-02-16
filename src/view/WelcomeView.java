package view;

import registrationView.RegistrationView;
import tools.Alerts;
import tools.Cnsl;
import view.*;
import loginView.*;
import registrationView.*;

public class WelcomeView {
	public void start() {
		Alerts.separator();
		Cnsl.println("Hello there!");
		Cnsl.println("1. Login");
		Cnsl.println("2. Sign up");
		
		String choice = new Alerts().wrtNmbrScan(2, "exit");
		switch(choice) {
		case "1":
			new LoginView(new idAndPassword()).login();
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
