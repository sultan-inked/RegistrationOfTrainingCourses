package tools;

public class Password {
	public boolean checkTemplate(String password) {
		if(!password.matches(".{8-16}")) {
			Cnsl.println("The password must contain 8 to 16 characters.");
			return false;
		}
		if(!password.matches(".*[A-Z].*")) {
			Cnsl.println("The password must containe at least one upper case character.");
			return false;
		}
		if(!password.matches(".*[a-z].*")) {
			Cnsl.println("The password must containe at least one lower case character.");
			return false;
		}
		if(!password.matches(".*\\d.*")) {
			Cnsl.println("The password must containe at least one digit.");
			return false;
		}
		if(!password.matches("^[!@#$%^&*()]+$")) {
			Cnsl.println("The password must containe at least ont character from the following list.");
			return false;
		}
		return true;
	}
}
