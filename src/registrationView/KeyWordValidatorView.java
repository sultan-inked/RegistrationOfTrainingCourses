package registrationView;

import tools.Alerts;
import tools.Cnsl;

public class KeyWordValidatorView {
	public boolean validateTeacherKeyWord() {
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
					Alerts.tryAgainOrBack();
			}
		}
	}
}
