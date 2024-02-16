package courseView;

import java.util.ArrayList;

import controller.CourseController;
import controller.MainController;
import model.Course;
import model.Teacher;
import model.User;
import tools.Alerts;
import tools.Cnsl;

public class CourseSearchMenuView {
//	Variables:
	private final CourseActionView courseActionView;
	private final SearchCourse searchCourse;
	
//	Constructors:
	public CourseSearchMenuView(CourseActionView courseActionView, SearchCourse searchCourse) {
		this.courseActionView = courseActionView;
		this.searchCourse = searchCourse;
	}
	
//	Search course:
	public void courseSearchMenu(User user) {
		Alerts.separator();
		Cnsl.println("Search course");
		Cnsl.println("1. by id");
		Cnsl.println("2. by name");
		Cnsl.println("3. by author");
		
		String choice = new Alerts().wrtNmbrScan(3, "back");
		switch(choice) {
		case "1":
			searchCourse.searchCourseById(user);
			courseSearchMenu(user);
			return;
		case "2":
			searchCourse.searchCourseByName(user);
			courseSearchMenu(user);
			return;
		case "3":
			searchCourse.searchCourseByAuthor(user);
			courseSearchMenu(user);
			return;
		case "back":
			return;
		}
	}
}
