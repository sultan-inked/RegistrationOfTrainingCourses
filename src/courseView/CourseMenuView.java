/*
 * CourseView - class representing the form for viewing and enrollment in courses.
 */

package courseView;

import java.util.Arrays;

import controllers.CourseController;
import controllers.MainController;
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
					new SearchCourse(new CourseActionView(), new MainController())).courseSearchMenu(user);
			courseMenu(user);
			return;
		case "2":
			// TODO: Make show course list feature
			Alerts.ftrNotYet();
			courseMenu(user);
			break;
		case "3":
			if(user instanceof Teacher) {
				new CourseCreateView(new MainController()).createCourseMenu((Teacher)user);
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
