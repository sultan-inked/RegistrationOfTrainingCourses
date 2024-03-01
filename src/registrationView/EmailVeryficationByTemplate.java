package registrationView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tools.Cnsl;

public class EmailVeryficationByTemplate {
	public boolean checkEmail(String email) {
		
		String regax = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regax);
		
		Matcher matcher = pattern.matcher(email);
		
		if(matcher.matches()) {
			return true;
		}else {
			Cnsl.println("Incorrect email!");
			return false;
		}
	}
}
