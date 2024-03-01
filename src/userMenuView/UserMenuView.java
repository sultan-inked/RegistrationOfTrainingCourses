package userMenuView;

import courseView.CourseMenuView;
import models.User;
import tools.Alerts;
import tools.Cnsl;

public class UserMenuView {
	public void userMenu(User user) {
		Alerts.separator();
		Cnsl.println("Hello " + user.getFirstName() + " " + user.getLastName());
		Cnsl.println(user + " menu");
		Cnsl.println("1. Courses");
		Cnsl.println("2. Students");
		Cnsl.println("3. Teachers");
		
		String choice = new Alerts().wrtNmbrScan(3, "exit");
		switch(choice) {
		case "1":
			new CourseMenuView().courseMenu(user);
			userMenu(user);
			return;
		case "2":
			new SearchUserMenuView().searchStudentMenu(user);
			userMenu(user);
			break;
		case "3":
			new SearchUserMenuView().searchTeacherMenu(user);
			userMenu(user);
			break;
		case "exit":
			return;
		case "":
			default:
		}	
	}
}
