package courseView;

import controllers.CourseController;
import models.Teacher;
import tools.Alerts;
import tools.Cnsl;

public class CourseCreateView {
//	Variables:

	
//	Constructor:
	public CourseCreateView() {
		
	}
	
//	Methods:
	public void createCourseMenu(Teacher teacher) {
		Alerts.separator();
		Cnsl.println("Course creator");
		String[] courseCreateFormArray = takeDataForCourseCreateForm(teacher);
		
		if(courseCreateFormArray == null) return;
		
		String courseId = new CourseController().createCourseCardSaveAndReturnId(courseCreateFormArray, teacher);
		Cnsl.println("Course with id: " + courseId + " created!");
	}
	public String[] takeDataForCourseCreateForm(Teacher teacher) {
		var courseCreateFormArray = new String[2];
		Cnsl.print("Course name: ");
		courseCreateFormArray[0] = Cnsl.scan();
		Cnsl.print("Description: ");
		courseCreateFormArray[1] = Cnsl.scan();
		
		String answer = new Alerts().confirmChangeOrBack();
		switch(answer) {
		case "confirm":
			return courseCreateFormArray;
		case "change":
			createCourseMenu(teacher);
			return null;
		case "back":
			return null;
		}
		return null;
	}
}
