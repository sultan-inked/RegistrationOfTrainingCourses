/*
 * CourseView - class representing the form for viewing and enrollment in courses.
 */

package courseView;

import java.util.Arrays;

import controllers.CourseController;
import controllers.StudentController;
import controllers.TeacherController;
import models.Course;
import models.Student;
import models.Teacher;
import models.User;

import java.util.ArrayList;

import tools.Alerts;
import tools.Cnsl;

public class CourseMenuView {
//	Methods:
	public void courseMenu(User user) {
		Alerts.separator();
		Cnsl.println("1. Search course");
		Cnsl.println("2. Show course list");
		if(user instanceof Teacher) {
			Cnsl.println("3. Create course");
		}
		
		String choice = new Alerts().wrtNmbrScan(3, "back");
		switch(choice) {
		case "1":
			new CourseSearchMenuView(new CourseActionView(), 
					new SearchCourseView(new CourseActionView())).courseSearchMenu(user);
			courseMenu(user);
			return;
		case "2":
			new CourseShowListMenuView().courseShowListMenu(user);
			courseMenu(user);
			break;
		case "3":
			if(user instanceof Teacher) {
				new CourseCreateView().createCourseMenu((Teacher)user);
				courseMenu(user);
				return;
			}else {
				Alerts.wrtNmbr();
				break;
			}
		case "back":
			return;
			default:
				Alerts.wrtNmbr();
		}
	}
}
