package loginView;

import database.DatabaseSearchController;
import models.User;
import tools.Alerts;
import tools.Cnsl;
import tools.HashCode;

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
			String userPasswordHash = new HashCode().makeHashCode(userPassword);
			if(userPasswordHash.equals(user.getPassword())) {
				return true;
			}
			else {
				Cnsl.println("Incorrect password!");
				Alerts.tryAgainOrBack();
			}
		}
	}
}
