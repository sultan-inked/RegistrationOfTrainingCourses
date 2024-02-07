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
				Alerts.ftrNotYet();
				// TODO: Make feature: Search course
				break;
			case "2":
				Alerts.ftrNotYet();
				// TODO: Make feature: Show course list
				break;
			case "3":
				if(user instanceof Teacher) {
					Alerts.ftrNotYet();
					// TODO: Make feature: Create course
				}else {
					Alerts.wrtNmbr();
				}
				courseMenu(user);
				return;
			case "back":
				return;
				default:
					Alerts.wrtNmbr();
			}
		}
	}
}
