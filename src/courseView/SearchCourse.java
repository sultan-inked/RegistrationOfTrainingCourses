package courseView;

import java.util.ArrayList;

import controllers.MainController;
import models.Course;
import models.Teacher;
import models.User;
import tools.Alerts;
import tools.Cnsl;

public class SearchCourse {
//	Variables:
	private final CourseActionView courseActionView;
	private final MainController mainController;
	
//	Constructors:
	public SearchCourse(CourseActionView courseActionView, MainController mainController) {
		this.courseActionView = courseActionView;
		this.mainController = mainController;
	}
	
//	Methods:
	public void searchCourseById(User user) {
		Alerts.separator();
		Cnsl.println("Search course by id");
		Course course;
		
		// Loop for handling input exceptions:
		while(true) {
			Cnsl.print("Id: ");
			String courseId = Cnsl.scan();
			
			// Checking for matching the id template
			if(courseId.length() > 2 && courseId.substring(0, 3).equals(mainController.getCourseIdSignature()) 
					&& courseId != null && !courseId.equals("") && courseId.length() == 9) {
				
				course = mainController.searchCourseById(courseId);
				if(course != null) {
					Alerts.separator();
					Cnsl.println("Course found!");
					courseActionView.whatToDoWithTheCourse(course, user, mainController);
					searchCourseById(user);
					return;
				}
				Alerts.tryAgainOrBack();
			}
			else if(courseId.equals("back")) {
				return;
			}
			else {
				Cnsl.println("Incorrect course id!");
				Alerts.tryAgainOrBack();
			}
		}
	}
	
	public void searchCourseByName(User user) {
		Alerts.separator();
		Cnsl.println("Search course by name");
		
		// Loop for handling input exception:
		while(true) {
			Cnsl.print("Name: ");
			String courseName = Cnsl.scan();
			
			if(courseName.equals("back")) {
				return;
			}
			
			ArrayList<Course> coursesFoundList = mainController.searchCourseByNameAndReturnArrayList(courseName);
			
			if(coursesFoundList.size() == 1) {
				Alerts.separator();
				Cnsl.println("1 course founded with that name!");
				courseActionView.whatToDoWithTheCourse(coursesFoundList.get(0), user, mainController);
				return;
			}
			else if(coursesFoundList.size() > 1) {
				Cnsl.println(coursesFoundList.size() + " courses with the name \'" + coursesFoundList.get(0).getCourseName()
						+ "\' founded!");
				Course course = courseActionView.choiceCourseInList(coursesFoundList);
				if(course != null) {
					Alerts.separator();
					Cnsl.println("Your choice course");
					courseActionView.whatToDoWithTheCourse(course, user, mainController);
				}else {
					Cnsl.println("Error: Course card is empty(SearchCourse.java :90");
				}
			}
			else if(coursesFoundList.size() == 0) {
				Alerts.tryAgainOrBack();
//				searchCourseByName(user); //**************
//				return;
			}
		}
	}
	
	public void searchCourseByAuthor(User user) {
		Alerts.separator();
		Cnsl.println("Search course by author");
		
		Cnsl.print("First name: ");
		String firstName = Cnsl.scan();
		Cnsl.print("Last name: ");
		String lastName = Cnsl.scan();
		Cnsl.print("Author id: ");
		String authorId = Cnsl.scan();
		
		String answer = new Alerts().confirmChangeOrBack();
		switch(answer) {
		case "confirm":
			break;
		case "change":
			searchCourseByAuthor(user);
			return;
		case "back":
			return;
		}
		
		// Search for all matching authors:
		ArrayList<Teacher> teachersFoundList = 
				mainController.searchTeacherAndReturAllOfMatches(firstName, lastName, authorId);
		if(teachersFoundList.size() == 0) {
			Cnsl.println("No such author was found!");
			Alerts.tryAgainOrBack();
			searchCourseByAuthor(user);
		}
		
		// Search for courses by several authors:
		ArrayList<Course> coursesFoundList = mainController.searchCourseBySeveralAuthorsAndReturnArrayList(teachersFoundList);
		if(coursesFoundList.size() == 0) {
			Cnsl.println("Not found a course with that aouthor!");
			Alerts.tryAgainOrBack();
			searchCourseByAuthor(user);
		}
		if(coursesFoundList.size() == 1) {
			Alerts.separator();
			Cnsl.println("1 cours founded with that author!");
			courseActionView.whatToDoWithTheCourse(coursesFoundList.get(0), user, mainController);
		}
		if(coursesFoundList.size() > 1) {
			Alerts.separator();
			Cnsl.println(coursesFoundList.size() + " courses by that authors founded!");
			Course course = courseActionView.choiceCourseInList(coursesFoundList);
			if(course != null) {
				courseActionView.whatToDoWithTheCourse(course, user, mainController);
			}else {
				Cnsl.println("Error: Course card is empty(SearchCourse.java :145");
			}
		}
	}
}
