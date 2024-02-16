/*
 * CourseView - class representing the form for viewing and enrollment in courses.
 */

package courseView;

import java.util.Arrays;
import java.util.ArrayList;

import model.User;
import model.Student;
import model.Teacher;
import model.Course;
import controller.MainController;
import controller.StudentController;
import controller.TeacherController;
import controller.CourseController;
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
		Cnsl.println("\'back\'");
		while(true) {
			Alerts.wrtHere();
			String choice = Cnsl.scan();
			switch(choice) {
			case "1":
				new CourseSearchMenuView(new CourseActionView(), 
						new SearchCourse(new CourseActionView(), new MainController())).courseSearchMenu(user);
				courseMenu(user);
				return;
			case "2":
				// TODO: Make show course list feature
				Alerts.ftrNotYet();
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
}
