package registrationView;

import tools.Cnsl;
import tools.Alerts;
import tools.HashCode;

public class FormView {
	public String[] userRegistrationFormOne() {
		var userRegistrationFormArray = new String[3];
		while(true) {
			userRegistrationFormArray[0] = takeAndCheckName("First");
			userRegistrationFormArray[1] = takeAndCheckName("Last");
			userRegistrationFormArray[2] = takeAndCheckPassword();
			
			String answer = new Alerts().confirmChangeOrBack();
			switch(answer) {
			case "confirm":
				return userRegistrationFormArray;
			case "change":
				break;
			case "back":
				return null;
			}
		}
	}
	private String takeAndCheckName(String firstOrLastName) {
		while(true) {
			Cnsl.print(firstOrLastName + " name:");
			String name = Cnsl.scan();
			if(new NameVerificationByTemplate().nameCheckForLettersOnly(name)) {
				return name.substring(0, 1).toUpperCase() + name.substring(1);
			}
		}
	}
	private String takeAndCheckPassword() {
		while(true) {
			Cnsl.println("Password: ");
			String password = Cnsl.scan();
			if(new PasswordVeryficationByTemplate().checkPassword(password)) {
				return new HashCode().makeHashCode(password);
			}
		}
	}
}
