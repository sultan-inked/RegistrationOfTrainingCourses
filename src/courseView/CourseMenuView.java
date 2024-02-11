/*
 * CourseView - class representing the form for viewing and enrollment in courses.
 */

package courseView;

import java.util.Arrays;
import java.util.ArrayList;

import model.User;
import model.Student;
import model.Teacher;
import model.Course;
import controller.MainController;
import controller.StudentController;
import controller.TeacherController;
import controller.CourseController;

import tools.Cnsl;
import view.Alerts;

public class CourseMenuView {
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
				break;
//				showCourseList();
//				courseMenu(user);
//				return;
			case "3":
				if(user instanceof Teacher) {
					createCourseMenu((Teacher)user);
					courseMenu(user);
					return;
				}else {
					Alerts.wrtNmbr();
					break;
				}
			case "back":
				return;
				default:
					Alerts.wrtNmbr();
			}
		}
	}
	
//	Course action:
	public void whatToDoWithTheCourse(Course course, User user) {
		Cnsl.println();
		Cnsl.println("You choice this course:");
		String[] courseInfoArray = CourseController.getCourseInfoArray(course);
		for(String info: courseInfoArray) {
			Cnsl.println(info);
		}
		Cnsl.println();
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
	
//	Search course:
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
				searchCourseByName(user);
				return;
			case "3":
				searchCourseByAuthor(user);
				return;
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
			if(courseId.substring(0, 3).equals(MainController.getCourseIdSignature()) 
					&& courseId != null && !courseId.equals("") && courseId.length() == 9) {
				course = MainController.searchCourseById(courseId);
				if(course != null) {
					Alerts.separator();
					Cnsl.println("Course found!");
					whatToDoWithTheCourse(course, user);
					return;
				}
				Alerts.tryAgainOrBack();
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
	public void searchCourseByName(User user) {
		Alerts.separator();
		Cnsl.println("Search course by name");
		Cnsl.print("Name: ");
		String courseName = Cnsl.scan();
		if(courseName.equals("back")) {
			searchCourse(user);
			return;
		}
		ArrayList<Course> coursesFoundList = MainController.searchCourseByNameAndReturnArrayList(courseName);
		if(coursesFoundList.size() == 0) {
			Alerts.tryAgainOrBack();
			searchCourseByName(user);
			return;
		}
		if(coursesFoundList.size() == 1) {
			Alerts.separator();
			Cnsl.println("1 course founded with that name!");
			whatToDoWithTheCourse(coursesFoundList.get(0), user);
			return;
		}
		if(coursesFoundList.size() > 1) {
			Cnsl.println(coursesFoundList.size() + " courses with the name \'" + coursesFoundList.get(0).getCourseName()
					+ "\' founded!");
			Course course = choiceCourseInList(coursesFoundList);
			if(course != null) {
				Alerts.separator();
				Cnsl.println("Your choice course");
				whatToDoWithTheCourse(course, user);
			}
		}
	}
	public void searchCourseByAuthor(User user) {
		Alerts.separator();
		Cnsl.println("Search course by author");
		Cnsl.print("First name: ");
		String firstName = Cnsl.scan();
		if(firstName.equals("back")) {
			searchCourse(user);
		}
		Cnsl.print("Last name: ");
		String lastName = Cnsl.scan();
		Cnsl.print("Author id: ");
		String authorId = Cnsl.scan();
		ArrayList<Teacher> teachersFoundList = MainController.searchTeacherAndReturAllOfMatches(firstName, lastName, authorId);
		if(teachersFoundList.size() == 0) {
			Cnsl.println("No such author was found!");
			Alerts.tryAgainOrBack();
			searchCourseByAuthor(user);
		}
		// TODO: Search course by several authors *******
		ArrayList<Course> coursesFoundList = MainController.searchCourseBySeveralAuthorsAndReturnArrayList(teachersFoundList);
		if(coursesFoundList.size() == 0) {
			Cnsl.println("Not found a course with that aouthor!");
			Alerts.tryAgainOrBack();
			searchCourseByAuthor(user);
		}
		if(coursesFoundList.size() == 1) {
			Alerts.separator();
			Cnsl.println("1 cours founded with that aouthor!");
			whatToDoWithTheCourse(coursesFoundList.get(0), user);
		}
		if(coursesFoundList.size() > 1) {
			Alerts.separator();
			Cnsl.println(coursesFoundList.size() + " courses by that authors founded!");
			Course course = choiceCourseInList(coursesFoundList);
			if(course != null) {
				whatToDoWithTheCourse(course, user);
			}
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
		while(true) {
			Cnsl.print("Write number with your course:");
			String choice = Cnsl.scan();
			String numbersForCheck = "123456789";
			int choiceInt = 0;
			if(choice.length() == 1 && numbersForCheck.contains(choice)) {
				choiceInt = Integer.parseInt(choice);
			}
			if(choice.length() == 2 && numbersForCheck.contains(choice.substring(0, 1))) {
				if(numbersForCheck.contains(choice.substring(1, 2))) {
					choiceInt = Integer.parseInt(choice);
				}
			}
			if(choiceInt > 0 && choiceInt <= coursesFoundList.size()) {
				return coursesFoundList.get(choiceInt -1);
			}else {
				Cnsl.println("Wrong, write number between: 1 to " + coursesFoundList.size());
			}
		}
	}
	
//	Show course list
	public void showCourseList() {
//		var courseList = MainController.returnCourseList();
		// TODO: Make feature, show course list
	}
	
//	Create course:
	public void createCourseMenu(Teacher teacher) {
		Alerts.separator();
		Cnsl.println("Course creator");
		var courseCreateFormArray = takeDataForCourseCreateForm(teacher);
		if(courseCreateFormArray == null) return;
		String courseId = MainController.dataTransferToCreateCourseCardAndReturnId(courseCreateFormArray, teacher);
		Cnsl.println("Course with id: " + courseId + " created!");
	}
	public String[] takeDataForCourseCreateForm(Teacher teacher) {
		var courseCreateFormArray = new String[2];
		Cnsl.print("Course name: ");
		courseCreateFormArray[0] = Cnsl.scan();
		Cnsl.print("Description: ");
		courseCreateFormArray[1] = Cnsl.scan();
		while(true) {
			Cnsl.print("Write \'confirm\', \'again\' or \'back:\'");
			String answer = Cnsl.scan();
			switch(answer) {
			case "confirm":
				return courseCreateFormArray;
			case "again":
				createCourseMenu(teacher);
				return null;
			case "back":
				courseMenu((User)teacher);
				return null;
				default:
					Cnsl.println("Wrong!");
			}
		}
	}
}










