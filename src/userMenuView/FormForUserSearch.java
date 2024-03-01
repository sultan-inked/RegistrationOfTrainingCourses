package userMenuView;

import tools.Alerts;
import tools.Cnsl;

import models.User;

public class FormForUserSearch {
	
	public String[] formForStudentSearch() {
		return formForStudentOrTeacherSearch("Student");
	}
	
	public String[] formForTeacherSearch() {
		return formForStudentOrTeacherSearch("Teacher");
	}
	
	public String[] formForAuthorSearch() {
		return formForStudentOrTeacherSearch("Author");
	}
	
	public String[] formForUserSearch(String userType) {
		return formForStudentOrTeacherSearch(userType);
	}
	
	private String[] formForStudentOrTeacherSearch(String studentOrTeacher) {
		while(true) {
			String[] userFormArray = new String[3];
			Cnsl.print("First name: ");
			userFormArray[0] = Cnsl.scan();
			Cnsl.print("Last name: ");
			userFormArray[1] = Cnsl.scan();
			Cnsl.print(studentOrTeacher + " id: ");
			userFormArray[2] = Cnsl.scan();
			
			String answer = new Alerts().confirmChangeOrBack();
			switch(answer) {
			case "confirm":
				return userFormArray;
			case "change":
				break;
			case "back":
				return null;
			}
		}
		
	}
}
