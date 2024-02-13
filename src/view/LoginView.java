package view;

import controller.MainController;
import tools.Alerts;
import tools.Cnsl;
import model.User;
import model.Student;
import model.Teacher;

public class LoginView {
	public static void login() {
		Alerts.separator();
		Cnsl.println("Login");
		
		var user = takeIdAndPasswordForValidating();
		if(user != null) {
			UserMenuView userMenu = new UserMenuView();
			userMenu.userMenu(user);
		}
	}
	
	public static User takeIdAndPasswordForValidating() {
		while(true) {
			Cnsl.print("Your id: ");
			String userId = Cnsl.scan();
			
			// Back to start-screen if write 'back'.
			if(userId.equals("back")) {
				return null;
			}
			
			Cnsl.print("Password:");
			String userPassword = Cnsl.scan();
			
			var user = MainController.idAndPasswordValidator(userId, userPassword);
			if(user != null) {
				if(user instanceof Student) {
					return (Student)user;
				}
				if(user instanceof Teacher) {
					return (Teacher)user;
				}
			}else {
				Cnsl.println("Try again or write \'back\'");
			}
		}
	}
}
