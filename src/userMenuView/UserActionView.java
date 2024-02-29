package userMenuView;

import courseView.CourseActionView;
import controllers.StudentController;
import controllers.TeacherController;
import models.Teacher;
import models.Student;
import models.User;
import models.Course;
import tools.Alerts;
import tools.Cnsl;

public class UserActionView {
//	Variables:
	private StudentController studentController;
	private TeacherController teacherController;
	private CourseActionView courseActionView;
	
//	Constructors:
	public UserActionView() {
		studentController = new StudentController();
		teacherController = new TeacherController();
		courseActionView = new CourseActionView();
	}
	
//	Methods:
	public User choiceUserInList(User[] usersFoundListArray) {
		if(usersFoundListArray.length == 0) {
			Cnsl.println("User list is empty.");
			return null;
		}
		Cnsl.println(usersFoundListArray.length > 1 ? 
				usersFoundListArray.length + " cards found!" :
					"One card found!");
		for(int i = 0; i < usersFoundListArray.length; i++) {
			Cnsl.println((i+1) + ". Name: " + usersFoundListArray[i].getFirstName() + "\n"
					+ "   Last name: " + usersFoundListArray[i].getLastName() + "\n"
					+ "   Id: " + usersFoundListArray[i].getUserId());
		}
		
		// Loop for handling input exception:
		while(true) {
			Cnsl.print("Choice card and write number:");
			String choice = Cnsl.scan();
			if(choice.equals("back")) return null;
			int choiceInt = 0;
			if(choice.matches("[0-9]+")) {
				choiceInt = Integer.parseInt(choice);
			}
			if(choiceInt > 0 && choiceInt <= usersFoundListArray.length) {
				return usersFoundListArray[choiceInt -1];
			}else {
				Cnsl.println("Wrong, write number between: 1 to " + usersFoundListArray.length + " or write \'back\'");
			}
		}
	}
	
	public void whatToDoWithTheUser(User userOwner, User user) {
		String userType = "student";
		if(user instanceof Teacher) userType = "teacher";
		
		Cnsl.println();
		Cnsl.println("You choice this " + userType + ":");
		if(user instanceof Student)
			studentController.showUserInfo(user);
		if(user instanceof Teacher)
			teacherController.showUserInfo(user);
		Cnsl.println();
		Cnsl.println("What you can do:");
		Cnsl.println("1. Show enrollment list");
		int numberOfChoices = 1;
		if(user instanceof Teacher) {
			Cnsl.println("2. Show list of created courses");
			numberOfChoices = 2;
		}

		
//		Cnsl.println("2. Send message");
//		Cnsl.println("3. Add add a friend");
//		Cnsl.println("4. Remove from friends");
		
		String choice = new Alerts().wrtNmbrScan(numberOfChoices, "back");
		
		switch(choice) {
		case "1":
			Course[] coursesFoundList = null;
			if(user instanceof Student)
				coursesFoundList = studentController.getCourseEnrollmentListArray(user);
			else if(user instanceof Teacher)
				coursesFoundList = teacherController.getCourseEnrollmentListArray(user);
			courseActionView.whatToDoWithTheCourse(
					courseActionView.choiceCourseInList(coursesFoundList), userOwner);
			whatToDoWithTheUser(userOwner, user);
			return;
		case "2":
			Alerts.ftrNotYet();
			whatToDoWithTheUser(userOwner, user);
			return;
		case "back":
			return;
		}
		
	}
}
