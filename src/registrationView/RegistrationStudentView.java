package registrationView;

import controller.MainController;
import tools.Alerts;
import tools.Cnsl;

public class RegistrationStudentView {
	public boolean registrationStudent() {
		Alerts.separator();
		Cnsl.println("Student registration");
		String[] userRegistrationFormArray = new FormView().userRegistrationFormOne();
		
		// If user write 'back' formView return null
		if(userRegistrationFormArray == null) {
			return false;
		}
		
		String studentId = new MainController().dataTransferToCreateStudentCardAndReturnId(userRegistrationFormArray);
		Cnsl.println("Student card created!");
		Cnsl.println("Your id: " + studentId);
		
		return true;
	}
}
