/*
 * CourseView - class representing the form for viewing and enrollment in courses.
 */

package view;

import java.util.Arrays;

import model.User;
import model.Student;
import model.Teacher;
import model.Course;
import controller.MainController;
import controller.StudentController;
import controller.TeacherController;
import controller.CourseController;

import tools.Cnsl;

public class CourseView {
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
				searchCourse(user);
				return;
			case "2":
				Alerts.ftrNotYet();
				// TODO: Make feature: Show course list
				break;
			case "3":
				if(user instanceof Teacher) {
					Alerts.ftrNotYet();
					// TODO: Make feature: Create course
				}else {
					Alerts.wrtNmbr();
				}
				courseMenu(user);
				return;
			case "back":
				return;
				default:
					Alerts.wrtNmbr();
			}
		}
	}
	
	// Search course:
	public void searchCourse(User user) {
		Alerts.separator();
		Cnsl.println("Search course");
		Cnsl.println("1. by id");
		Cnsl.println("2. by name");
		Cnsl.println("3. by author");
		Cnsl.println("\'back\'");
		while(true) {
			Alerts.wrtHere();
			String choice = Cnsl.scan();
			switch(choice) {
			case "1":
				searchCourseById(user);
				return;
			case "2":
				Alerts.ftrNotYet();
				break;
			case "3":
				Alerts.ftrNotYet();
				break;
			case "back":
				courseMenu(user);
				return;
				default:
					Alerts.wrtNmbr();
			}
		}
	}
	public void searchCourseById(User user) {
		Alerts.separator();
		Cnsl.println("Search course by id");
		Course course;
		while(true) {
			Cnsl.print("Id: ");
			String courseId = Cnsl.scan();
			if(courseId != null && !courseId.equals("") && courseId.length() == 9) {
				whatToDoWithTheCourse(course = MainController.searchCourseById(courseId), user);
				return;
			}
			else if(courseId.equals("back")) {
				searchCourse(user);
				return;
			}
			else {
				Cnsl.println("Incorrect course id!");
				Alerts.tryAgainOrBack();
			}
		}
		
	}
	
	
	// Course action:
	public void whatToDoWithTheCourse(Course course, User user) {
		Alerts.separator();
		Cnsl.println("Course found!");
		String[] courseInfoArray = CourseController.getCourseInfoArray(course);
		for(String info: courseInfoArray) {
			Cnsl.println(info);
		}
		Cnsl.println("");
		Cnsl.println("What you can do with the course:");
		Cnsl.println("1. Enrollincourse");
		Cnsl.println("2. Unenrollincourse");
		if(user instanceof Teacher) {
			Cnsl.println("3. Delete course");
		}
		Cnsl.println("\'back\'");
		while(true) {
			Alerts.wrtHere();
			String choice = Cnsl.scan();
			switch(choice) {
			case "1":
				MainController.enrollInCourse(user, course);
				whatToDoWithTheCourse(course, user);
				return;
			case "2":
				MainController.unenrollInCourse(user, course);
				whatToDoWithTheCourse(course, user);
				return;
			case "3":
				if(user instanceof Teacher) {
					Alerts.ftrNotYet();
					break;
				}else {
					Alerts.wrtNmbr();
					break;
				}
			case "back":
				searchCourse(user);
				return;
				default:
					Alerts.wrtNmbr();
			}
			
		}
	}
}










