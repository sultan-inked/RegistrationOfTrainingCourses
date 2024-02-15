package registrationView;

import controller.MainController;
import tools.Alerts;
import tools.Cnsl;

public class RegistrationTeacherView {
	public boolean registrationTeacher() {
		Alerts.separator();
		Cnsl.println("Teacher regitration");
		if(new KeyWordValidatorView().teacher()) {
			String[] userRegistrationFormArray = new FormView().userRegistrationFormOne();
			
			// If user write 'back' formView return null
			if(userRegistrationFormArray == null) {
				return false;
			}
			
			String teacherId = new MainController().dataTransferToCreateTeacherCardAndReturnId(userRegistrationFormArray);
			Cnsl.println("Teacher card created!");
			Cnsl.println("Your id: " + teacherId);
			return true;
		}else {
			return false;
		}
	}
}
