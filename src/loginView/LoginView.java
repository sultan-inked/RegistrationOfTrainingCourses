package loginView;

import controller.MainController;
import tools.Alerts;
import tools.Cnsl;
import view.UserMenuView;
import model.User;
import model.Student;
import model.Teacher;

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
