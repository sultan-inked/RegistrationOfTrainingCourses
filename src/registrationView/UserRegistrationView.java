package registrationView;

import controllers.StudentController;
import controllers.TeacherController;
import database.DatabaseAddController;
import tools.Alerts;
import tools.Cnsl;

public class UserRegistrationView {
//	Variables:
	private final FormView formView;
	private final KeyWordValidatorView keyWordValidatorView;
	
//	Constructors:
	public UserRegistrationView(FormView formView, KeyWordValidatorView keyWordValidatorView) {
		this.formView = formView;
		this.keyWordValidatorView = keyWordValidatorView;
	}
	
//	Methods:
	public boolean student() {
		return studentOrTeacherRegistration("Student");
	}
	
	public boolean teacher() {
		if(keyWordValidatorView.validateTeacherKeyWord()) {
			return studentOrTeacherRegistration("Teacher");
		}else {
			return false;
		}
	}
	
	private boolean studentOrTeacherRegistration(String userTypeString) {
		Alerts.separator();
		Cnsl.println(userTypeString + " registration");
		
		// Taking user info for registration:
		String[] userRegistrationFormArray = formView.userRegistrationFormOne();
		
		// If user write 'back' formView return 'null' to back to registration()
		if(userRegistrationFormArray == null) {
			return false;
		}
		
		// Take user Id for show to user
		String userId = userTypeString.equals("Student") ?
				new StudentController().createStudentCardSaveAndReturnId(userRegistrationFormArray):
					new TeacherController().createTeacherCardSaveAndReturnId(userRegistrationFormArray);
		Cnsl.println(userTypeString + " card created!");
		Cnsl.println("Your id: " + userId);
		
		return true;
	}
}
