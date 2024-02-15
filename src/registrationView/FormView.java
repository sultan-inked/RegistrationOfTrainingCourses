package registrationView;

import tools.Cnsl;

public class FormView {
	public String[] userRegistrationFormOne() {
		var userRegistrationFormArray = new String[3];
		while(true) {
			Cnsl.print("First name:");
			userRegistrationFormArray[0] = Cnsl.scan();
			Cnsl.print("Last name:");
			userRegistrationFormArray[1] = Cnsl.scan();
			Cnsl.print("Password:");
			userRegistrationFormArray[2] = Cnsl.scan();
			
			String answer = confirmChangeOrBack();
			
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
	public String confirmChangeOrBack() {
		while(true) {
			Cnsl.println("\'confirm\', \'change' or \'back\'");
			Cnsl.print("Write:");
			String answer = Cnsl.scan();
			switch(answer) {
			case "confirm":
				return "confirm";
			case "change":
				return "change";
			case "back":
				return "back";
			}
		}
	}
}
