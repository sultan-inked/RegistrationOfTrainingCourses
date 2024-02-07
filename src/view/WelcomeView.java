package view;

import tools.Cnsl;
import view.*;

public class WelcomeView {
	public static void start() {
		while(true) {
			Cnsl.println("Hello there!");
			String logInOrRegistration = logInOrSignUp();
			switch(logInOrRegistration) {
			case "Login":
				LoginView.login();
				break;
			case "Registration":
				RegistrationView.registration();
				break;
			case "exit":
				return;
			}
		}
		
	}
	
	public static String logInOrSignUp() {
		Cnsl.println("Just write number with your choice");
		Cnsl.println("1. Login");
		Cnsl.println("2. Sign up");
		while(true) {
			Cnsl.print("Here:");
			String choice = Cnsl.scan();
			switch(choice) {
			case "1":
				return "Login";
			case "2":
				return "Registration";
			case "exit":
				return "exit";
				default:
					Alerts.wrtNmbr();
			}
		}
	}
	
	
}
