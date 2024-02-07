package view;

import model.User;
import model.Student;
import model.Teacher;

import tools.Cnsl;

public class UserMenuView {
	public void userMenu(User user) {
		Alerts.separator();
		Cnsl.println("Hello " + user.getFirstName());
		Cnsl.println(user + " menu");
		Cnsl.println("1. Courses");
		Cnsl.println("2. Students");
		Cnsl.println("3. Teachers");
		Cnsl.println("\'exite\'");
		while(true) {
			Alerts.wrtHere();
			String choice = Cnsl.scan();
			switch(choice) {
			case "1":
				var courseView = new CourseView();
				courseView.courseMenu(user);
				courseView = null;
				userMenu(user);
				return;
			case "2":
				Alerts.ftrNotYet();
				// TODO: Make feature with Student
				break;
			case "3":
				Alerts.ftrNotYet();
				// TODO: Make feature with Teacher
				break;
			case "exit":
				WelcomeView.start();
				return;
				default:
					Alerts.wrtNmbr();
			}
		}
		
	}
	
}
