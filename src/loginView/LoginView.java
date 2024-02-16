package loginView;

import tools.Alerts;
import tools.Cnsl;
import view.UserMenuView;
import mainController.MainController;
import models.Student;
import models.Teacher;
import models.User;

public class LoginView {
//	Variables:
	private final idAndPassword idAndPassword;
	
//	Constructors:
	public LoginView(idAndPassword idAndPassword) {
		this.idAndPassword = idAndPassword;
	}
	
//	Methods:
	public void login() {
		Alerts.separator();
		Cnsl.println("Login");
		User user = idAndPassword.takeIdValidateAndReturnUser();
		if(user == null) return;
		if(idAndPassword.takePasswordForValidate(user)) {
			new UserMenuView().userMenu(user);
		}
	}
}
