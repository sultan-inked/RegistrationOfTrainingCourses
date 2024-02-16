package courseView;

import controller.MainController;
import model.Teacher;
import model.User;
import tools.Alerts;
import tools.Cnsl;

public class CourseCreateView {
//	Variables:
	private final MainController mainController;
	
//	Constructor:
	public CourseCreateView(MainController mainController) {
		this.mainController = mainController;
	}
	
//	Methods:
	public void createCourseMenu(Teacher teacher) {
		Alerts.separator();
		Cnsl.println("Course creator");
		String[] courseCreateFormArray = takeDataForCourseCreateForm(teacher);
		
		if(courseCreateFormArray == null) return;
		
		String courseId = mainController.dataTransferToCreateCourseCardAndReturnId(courseCreateFormArray, teacher);
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
