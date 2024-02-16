package view;

import courseView.CourseMenuView;
import models.Student;
import models.Teacher;
import models.User;
import tools.Alerts;
import tools.Cnsl;

public class UserMenuView {
	public void userMenu(User user) {
		Alerts.separator();
		Cnsl.println("Hello " + user.getFirstName());
		Cnsl.println(user + " menu");
		Cnsl.println("1. Courses");
		Cnsl.println("2. Students");
		Cnsl.println("3. Teachers");
		
		String choice = new Alerts().wrtNmbrScan(3, "exit");
		switch(choice) {
		case "1":
			var courseView = new CourseMenuView();
			courseView.courseMenu(user);
			courseView = null;
			userMenu(user);
			return;
		case "2":
			Alerts.ftrNotYet();
			// TODO: Make feature with Student
			userMenu(user);
			break;
		case "3":
			Alerts.ftrNotYet();
			// TODO: Make feature with Teacher
			userMenu(user);
			break;
		case "exit":
			return;
		case "":
			default:
		}	
	}
}
