package courseView;

import tools.Alerts;
import tools.Cnsl;

import models.User;
import models.Course;

public class CourseShowListMenuView {
//	Variables:
	private final CourseActionView courseActionView;
	
//	Constructors:
	public CourseShowListMenuView() {
		this.courseActionView = new CourseActionView();
	}
	
//	Methods:
	public void courseShowListMenu(User user) {
		Alerts.separator();
		Cnsl.println("Your course list");
		Course course = courseActionView.choiceCourseInList(user.getCourseEnrollmentListArray());
		if(course != null) {
			courseActionView.whatToDoWithTheCourse(course, user);
		}
	}
}
