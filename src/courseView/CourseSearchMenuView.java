package courseView;

import models.User;
import tools.Alerts;
import tools.Cnsl;

public class CourseSearchMenuView {
//	Variables:
	private final SearchCourseView searchCourseView;
	
//	Constructors:
	public CourseSearchMenuView(SearchCourseView searchCourse) {
		this.searchCourseView = searchCourse;
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
			searchCourseView.searchCourseById(user);
			courseSearchMenu(user);
			return;
		case "2":
			searchCourseView.searchCourseByName(user);
			courseSearchMenu(user);
			return;
		case "3":
			searchCourseView.searchCourseByAuthor(user);
			courseSearchMenu(user);
			return;
		case "back":
			return;
		}
	}
}
