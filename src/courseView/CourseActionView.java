package courseView;

import controllers.CourseController;
import controllers.StudentController;
import controllers.TeacherController;
import models.Course;
import models.Student;
import models.Teacher;
import models.User;
import tools.Alerts;
import tools.Cnsl;

public class CourseActionView {
	public void whatToDoWithTheCourse(Course course, User user) {
		if(course == null || user == null) return;
		Cnsl.println();
		Cnsl.println("You choice this course:");
		String[] courseInfoArray = new CourseController().getCourseInfoArray(course);
		for(String info: courseInfoArray) {
			Cnsl.println(info);
		}
		Cnsl.println();
		Cnsl.println("What you can do with the course:");
		Cnsl.println("1. Enrollincourse");
		Cnsl.println("2. Unenrollincourse");
		int numberOfChoices = 2;
		if(user instanceof Teacher && course.getCourseCreator().equals(user)) {
			Cnsl.println("3. Delete course");
			numberOfChoices = 3;
		}
		
		String choice = new Alerts().wrtNmbrScan(numberOfChoices, "back");
		switch(choice) {
		case "1":
			enrollInCourse(user, course);
			whatToDoWithTheCourse(course, user);
			return;
		case "2":
			unenrollInCourse(user, course);
			whatToDoWithTheCourse(course, user);
			return;
		case "3":
			Alerts.ftrNotYet();
			whatToDoWithTheCourse(course, user);
			break;
		case "back":
			return;
		}
	}
	public void enrollInCourse(User user, Course course) {
		if(user instanceof Student) {
			new StudentController().enrollInCourse(new CourseController(), course, user);
		}
		if(user instanceof Teacher) {
			new TeacherController().enrollInCourse(new CourseController(), course, user);
		}
	}
	public void unenrollInCourse(User user, Course course) {
		if(user instanceof Student) {
			new StudentController().unenrollInCourse(new CourseController(), course, user);	
		}
		if(user instanceof Teacher) {
			new TeacherController().unenrollInCourse(new CourseController(), course, user);
		}
	}
	
	public Course choiceCourseInList(Course[] coursesFoundListArray) {
		if(coursesFoundListArray == null || coursesFoundListArray.length == 0) {
			Cnsl.println("Course list is empty.");
			return null;
		}
		for(int i = 0; i < coursesFoundListArray.length; i++) {
			Cnsl.println((i+1) + ". Id: " + coursesFoundListArray[i].getCourseId() + "\n"
					+ "   Name: " + coursesFoundListArray[i].getCourseName() + "\n"
					+ "   Author: " + coursesFoundListArray[i].getCourseCreator().getFirstName()
					+ " " + coursesFoundListArray[i].getCourseCreator().getLastName());
			Cnsl.println("   Descriprion: " + coursesFoundListArray[i].getCourseDescription());
		}
		
		// Loop for handling input exception:
		while(true) {
			Cnsl.print("Write number with your course:");
			String choice = Cnsl.scan();
			if(choice.equals("back")) return null;
			int choiceInt = 0;
			if(choice.matches("[0-9]+")) {
				choiceInt = Integer.parseInt(choice);
			}
			if(choiceInt > 0 && choiceInt <= coursesFoundListArray.length) {
				return coursesFoundListArray[choiceInt -1];
			}else {
				Cnsl.println("Wrong, write number between: 1 to " + coursesFoundListArray.length + " or write \'back\'");
			}
		}
	}
}
