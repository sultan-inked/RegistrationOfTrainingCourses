package registrationView;

import tools.Cnsl;

public class FormView {
	public String[] one() {
		var formArray = new String[3];
		while(true) {
			Cnsl.print("First name:");
			formArray[0] = Cnsl.scan();
			Cnsl.print("Last name:");
			formArray[1] = Cnsl.scan();
			Cnsl.print("Password:");
			formArray[2] = Cnsl.scan();
			while(true) {
				Cnsl.println("\'confirm\', \'change' or \'back\'");
				Cnsl.print("Write:");
				String answer = Cnsl.scan();
				switch(answer) {
				case "confirm":
					return formArray;
				case "change":
					break;
				case "back":
					var registrationView = new RegistrationView();
					registrationView.registration();
					registrationView = null;
					return null;
				}
			}
		}
		
	}
}
