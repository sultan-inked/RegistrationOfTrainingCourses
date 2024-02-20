package registrationView;

import tools.Cnsl;

public class PasswordVeryficationByTemplate {
	public boolean checkPassword(String password) {
		if(password.matches(".* .*")) {
			Cnsl.println("The password must be without spases.");
			return false;
		}
		else if(!password.matches(".{8,16}")) {
			Cnsl.println("The password must contain 8 to 16 characters.");
			return false;
		}
		else if(!password.matches(".*[A-Z].*")) {
			Cnsl.println("The password must containe at least one upper case character.");
			return false;
		}
		else if(!password.matches(".*[a-z].*")) {
			Cnsl.println("The password must containe at least one lower case character.");
			return false;
		}
		else if(!password.matches(".*\\d.*")) {
			Cnsl.println("The password must containe at least one digit.");
			return false;
		}
		else if(!password.matches(".*[!@#$%^&*()].*")) {
			Cnsl.println("The password must containe at least one character from the following list:");
			Cnsl.println("\"!@#$%^&*()\"");
			return false;
		}else {
			return true;
		}
	}
}
