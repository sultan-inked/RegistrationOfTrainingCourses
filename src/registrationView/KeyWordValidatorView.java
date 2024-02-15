package registrationView;

import tools.Cnsl;

public class KeyWordValidatorView {
	public boolean teacher() {
		final String teacherKeyWord = "1234";
		while(true) {
			Cnsl.print("Write key word:");
			String answer = Cnsl.scan();
			switch(answer) {
			case teacherKeyWord:
				Cnsl.println("Access granted!");
				return true;
			case "back":
				return false;
				default:
					Cnsl.println("Wrong, try again or write \'back\'");
			}
		}
	}
}
