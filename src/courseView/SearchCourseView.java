package courseView;

import java.util.ArrayList;

import database.DatabaseSearchController;
import database.DatabaseShowListController;
import models.Course;
import models.Teacher;
import models.User;
import tools.Alerts;
import tools.Cnsl;

import userMenuView.FormForUserSearch;

public class SearchCourseView {
//	Variables:
	private final CourseActionView courseActionView;
	
//	Constructors:
	public SearchCourseView(CourseActionView courseActionView) {
		this.courseActionView = courseActionView;
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
			String courseIdSignature = new DatabaseShowListController().getCourseIdSignature();
			if(courseId.matches(courseIdSignature + "\\d{6}")) {
				
				course = (Course)new DatabaseSearchController().searchIdInList(courseId);
				if(course != null) {
					Alerts.separator();
					Cnsl.println("Course found!");
					courseActionView.whatToDoWithTheCourse(course, user);
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
		
		// Loop for handling input exception:
		while(true) {
			Alerts.separator();
			Cnsl.println("Search course by name");
			Cnsl.print("Name: ");
			String courseName = Cnsl.scan();
			
			if(courseName.equals("back")) {
				return;
			}
			
			Course[] coursesFoundList = new DatabaseSearchController().searchCourseInListByName(courseName);
			
			if(coursesFoundList.length == 1) {
				Alerts.separator();
				Cnsl.println("1 course founded with that name!");
				courseActionView.whatToDoWithTheCourse(coursesFoundList[0], user);
				return;
			}
			else if(coursesFoundList.length > 1) {
				Cnsl.println(coursesFoundList.length + " courses with the name \'" + coursesFoundList[0].getCourseName()
						+ "\' founded!");
				Course course = courseActionView.choiceCourseInList(coursesFoundList);
				if(course != null) {
					Alerts.separator();
					Cnsl.println("Your choice course");
					courseActionView.whatToDoWithTheCourse(course, user);
				}else {
					Cnsl.println("Error: Course card is empty(SearchCourse.java :90");
				}
			}
			else if(coursesFoundList.length == 0) {
				Alerts.tryAgainOrBack();
			}
		}
	}
	
	public void searchCourseByAuthor(User user) {
		Alerts.separator();
		Cnsl.println("Search course by author");
		
//		Cnsl.print("First name: ");
//		String firstName = Cnsl.scan();
//		Cnsl.print("Last name: ");
//		String lastName = Cnsl.scan();
//		Cnsl.print("Author id: ");
//		String authorId = Cnsl.scan();
//		
//		String answer = new Alerts().confirmChangeOrBack();
//		switch(answer) {
//		case "confirm":
//			break;
//		case "change":
//			searchCourseByAuthor(user);
//			return;
//		case "back":
//			return;
//		}
		
		String[] authorFormArray = new FormForUserSearch().formForAuthorSearch();
		
		// Search for all matching authors:
		Teacher[] teachersFoundListArray = new DatabaseSearchController().searchTeachersInList(authorFormArray[0], 
																				authorFormArray[1], authorFormArray[2]);
		if(teachersFoundListArray.length == 0) {
			Cnsl.println("No such author was found!");
			Alerts.tryAgainOrBack();
			searchCourseByAuthor(user);
			return;
		}
		
		// Search for courses by several authors:
		Course[] coursesFoundList = new DatabaseSearchController().searchCourseBySeveralAuthors(teachersFoundListArray);
		if(coursesFoundList.length == 0) {
			Cnsl.println("Not found a course with that aouthor!");
			Alerts.tryAgainOrBack();
			searchCourseByAuthor(user);
		}
		if(coursesFoundList.length == 1) {
			Alerts.separator();
			Cnsl.println("1 cours founded with that author!");
			courseActionView.whatToDoWithTheCourse(coursesFoundList[0], user);
		}
		if(coursesFoundList.length > 1) {
			Alerts.separator();
			Cnsl.println(coursesFoundList.length + " courses by that authors founded!");
			Course course = courseActionView.choiceCourseInList(coursesFoundList);
			if(course != null) {
				courseActionView.whatToDoWithTheCourse(course, user);
			}else {
				Cnsl.println("Error: Course card is empty(SearchCourse.java :145");
			}
		}
	}
}
