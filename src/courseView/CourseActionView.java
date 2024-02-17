package courseView;

import java.util.ArrayList;

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
		if(user instanceof Teacher && course.getCourseCreator().equals(user)) {
			Cnsl.println("3. Delete course");
		}
		
		String choice = new Alerts().wrtNmbrScan(3, "back");
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
			if(user instanceof Teacher) {
				// TODO: Make course delete feature
				Alerts.ftrNotYet();
				whatToDoWithTheCourse(course, user);
				break;
			}else {
				Alerts.tryAgainOrBack();
				break;
			}
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
	
	public Course choiceCourseInList(ArrayList<Course> coursesFoundList) {
		for(int i = 0; i < coursesFoundList.size(); i++) {
			Cnsl.println((i+1) + ". Id: " + coursesFoundList.get(i).getCourseId() + "\n"
					+ "   Name: " + coursesFoundList.get(i).getCourseName() + "\n"
					+ "   Author: " + coursesFoundList.get(i).getCourseCreator().getFirstName()
					+ " " + coursesFoundList.get(i).getCourseCreator().getLastName());
			Cnsl.println("   Descriprion: " + coursesFoundList.get(i).getCourseDescription());
		}
		
		// Loop for handling input exception:
		while(true) {
			Cnsl.print("Write number with your course:");
			String choice = Cnsl.scan();
			int choiceInt = 0;
			if(choice.matches("[0-9]+")) {
				choiceInt = Integer.parseInt(choice);
			}
			if(choiceInt > 0 && choiceInt <= coursesFoundList.size()) {
				return coursesFoundList.get(choiceInt -1);
			}else {
				Cnsl.println("Wrong, write number between: 1 to " + coursesFoundList.size());
			}
		}
	}
}
