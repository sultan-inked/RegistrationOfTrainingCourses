/*
 * RegistrationView - class representing the registration and authorization form.
 */

package view;

import java.util.Arrays;

import controller.MainController;
import tools.Alerts;
import tools.Cnsl;

public class RegistrationView {
	private final static String teacherKeyWord = "1234";
	
	public static void registration() {
		Alerts.separator();
		Cnsl.println("Sign up");
		Cnsl.println("1. Student");
		Cnsl.println("2. Teacher");
		Cnsl.println("\'back\'");
		String choice = studentOrTeacher();
		switch(choice) {
		case "Student":
			registrationStudent();
			break;
		case "Teacher":
			registrationTeacher();
			break;
		}
	}
	public static String studentOrTeacher() {
		while(true) {
			Cnsl.print("Here:");
			String choice = Cnsl.scan();
			switch(choice) {
			case "1":
				return "Student";
			case "2":
				return "Teacher";
			case "back":
				WelcomeView.start();
				break;
				default:
					Alerts.wrtNmbr();
			}
		}
	}
	
	public static void registrationStudent() {
		Alerts.separator();
		Cnsl.println("Student registration");
		var formArray = formOne();
		String studentId = MainController.dataTransferToCreateStudentCardAndReturnId(formArray);
		Cnsl.println("Student card created!");
		Cnsl.println("Your id: " + studentId);
	}
	
	public static void registrationTeacher() {
		Alerts.separator();
		Cnsl.println("Teacher regitration");
		if(keyWordValidator()) {
			var formArray = formOne();
			// TODO: make teacher card and save to database
			String teacherId = MainController.dataTransferToCreateTeacherCardAndReturnId(formArray);
			Cnsl.println("Teacher card created!");
			Cnsl.println("Your id: " + teacherId);
		}
	}
	public static boolean keyWordValidator() {
		while(true) {
			Cnsl.print("Write key word:");
			String answer = Cnsl.scan();
			switch(answer) {
			case teacherKeyWord:
				Cnsl.println("Access granted!");
				return true;
			case "back":
				registration();
				return false;
				default:
					Cnsl.println("Wrong, try again or write \'back\'");
			}
			if(answer.equals(teacherKeyWord)) {
				
			}else {
				
			}
		}
	}
	
	public static String[] formOne() {
		var formArray = new String[3];
		while(true) {
			Cnsl.print("First name:");
			formArray[0] = Cnsl.scan();
			Cnsl.print("Last name:");
			formArray[1] = Cnsl.scan();
			Cnsl.print("Password:");
			formArray[2] = Cnsl.scan();
			while(true) {
				Cnsl.println("\'confirm\', \'change' or \'back\'");
				Cnsl.print("Write:");
				String answer = Cnsl.scan();
				switch(answer) {
				case "confirm":
					return formArray;
				case "change":
					break;
				case "back":
					registration();
					return null;
				}
			}
		}
		
	}
	
}
