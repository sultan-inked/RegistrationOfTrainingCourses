package registrationView;

import controller.MainController;
import tools.Cnsl;

public class UserRegistrationView {
	public boolean studentOrTeacherRegistration(String userTypeString) {
		Cnsl.println(userTypeString + " registration");
		
		// check if trying to register teacher card
		// return 'false' for back to registration() if user write 'back'
		if(userTypeString.equals("Teacher") && !(new KeyWordValidatorView().teacher())) {
			return false;
		}
		
		String[] userRegistrationFormArray = new FormView().userRegistrationFormOne();
		
		// If user write 'back' formView return 'null' to back to registration()
		if(userRegistrationFormArray == null) {
			return false;
		}
		
		// Take user Id for show to user
		String userId = "";
		if(userTypeString.equals("Student")) {
			userId = new MainController().dataTransferToCreateStudentCardAndReturnId(userRegistrationFormArray);
		}
		else if(userTypeString.equals("Teacher")) {
			userId = new MainController().dataTransferToCreateTeacherCardAndReturnId(userRegistrationFormArray);
		}
		Cnsl.println(userTypeString + " card created!");
		Cnsl.println("Your id: " + userId);
		
		return true;
	}
}
