package loginView;

import database.DatabaseSearchController;
import models.User;
import tools.Alerts;
import tools.Cnsl;

public class idAndPassword {
	public User takeIdValidateAndReturnUser() {
		while(true) {
			Cnsl.print("Your id: ");
			String userId = Cnsl.scan();
			if(userId.equals("back")) {
				return null;
			}else {
				User user = (User)new DatabaseSearchController().searchIdInList(userId);
				if(user != null) {
					return user;
				}else {
					Alerts.tryAgainOrBack();
				}
			}
		}
	}
	
	public boolean takePasswordForValidate(User user) {
		while(true) {
			Cnsl.print("Password: ");
			String userPassword = Cnsl.scan();
			if(userPassword.equals("back")) return false;
			else if(userPassword.equals(user.getPassword())) {
				return true;
			}
			else {
				Cnsl.println("Incorrect password!");
				Alerts.tryAgainOrBack();
			}
		}
	}
}
