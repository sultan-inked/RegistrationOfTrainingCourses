package userMenuView;

import tools.Alerts;
import tools.Cnsl;

import models.Student;
import database.DatabaseSearchController;

public class SearchStudentMenuView {
	public void searchStudentMenu() {
		Alerts.separator();
		Cnsl.println("Student search menu");
		
		String[] studentFormArray = new FormForUserSearch().formForStudentSearch();
		
		Student[] studentFoundListArray = new DatabaseSearchController().searchStudentsInList(studentFormArray[0],
				studentFormArray[1], studentFormArray[2]);
		if(studentFoundListArray.length == 0) {
			Cnsl.println("Not found!");
		}
		
		Student student = (Student) new UserActionView().choiceUserInList(studentFoundListArray);
		
		
	}
}
