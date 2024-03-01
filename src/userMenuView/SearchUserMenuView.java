package userMenuView;

import tools.Alerts;
import tools.Cnsl;

import models.User;
import database.DatabaseSearchController;

public class SearchUserMenuView {
//	Variables:
	private UserActionView userActionView;
	
//	Constructors:
	public SearchUserMenuView() {
		userActionView = new UserActionView();
	}
	
//	Methods:
	public void searchStudentMenu(User userOwner) {
		searchStudentOrTeacherMenu(userOwner, "Student");
	}
	
	public void searchTeacherMenu(User userOwner) {
		searchStudentOrTeacherMenu(userOwner, "Teacher");
	}
	
	private void searchStudentOrTeacherMenu(User userOwner, String userType) {
		Alerts.separator();
		Cnsl.println(userType + " search menu");
		
		// Take data for search -
		String[] userFormArray = new FormForUserSearch().formForUserSearch(userType);
		if(userFormArray == null) return;
		
		// Collecting all matches -
		User[] usersFoundListArray;
		if(userType.equals("Teacher")) {
			usersFoundListArray = new DatabaseSearchController().searchTeachersInList(userFormArray[0],
					userFormArray[1], userFormArray[2]);
		}else {
			usersFoundListArray = new DatabaseSearchController().searchStudentsInList(userFormArray[0],
					userFormArray[1], userFormArray[2]);
		}
		if(usersFoundListArray == null || usersFoundListArray.length == 0) {
			Cnsl.println("Not found " + userType + " whith the name " + 
										userFormArray[0] + " " + userFormArray[1]);
			return;
		}
		
		// Choice user in list -
		User user = userActionView.choiceUserInList(usersFoundListArray);
		if(user == null) return;
		userActionView.whatToDoWithTheUser(userOwner, user);
	}
}
