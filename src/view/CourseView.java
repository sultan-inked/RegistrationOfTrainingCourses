/*
 * CourseView - class representing the form for viewing and enrollment in courses.
 */

package view;

import model.User;
import model.Student;
import model.Teacher;

import tools.Cnsl;

public class CourseView {
	public void courseMenu(User user) {
		Alerts.separator();
		Cnsl.println("1. Search course");
		Cnsl.println("2. Show course list");
		if(user instanceof Teacher) {
			Cnsl.println("3. Create course");
		}
		Cnsl.println("\'back\'");
		while(true) {
			Alerts.wrtHere();
			String choice = Cnsl.scan();
			switch(choice) {
			case "1":
				
			case "2":
				
			case "3":
				
			case "back":
				return;
				default:
					Alerts.wrtNmbr();
			}
		}
	}
}
