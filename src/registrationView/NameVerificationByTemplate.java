package registrationView;

import tools.Cnsl;

public class NameVerificationByTemplate {
	public boolean nameCheckForLettersOnly(String name) {
		if(!name.matches("[A-Za-z]+")) {
			Cnsl.println("Name must contain only letters!");
			return false;
		}else {
			return true;
		}
	}
}
