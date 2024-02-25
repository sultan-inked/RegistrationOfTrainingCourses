package userMenuView;

import database.DatabaseSearchController;
import tools.Alerts;
import tools.Cnsl;

import controllers.TeacherController;

import models.Teacher;
import models.User;

public class SearchTeacherMenuView {
	public void searchTeacherMenu() {
		Alerts.separator();
		Cnsl.println("Teacher search menu");
		
		String[] teacherFormArray = new FormForUserSearch().formForTeacherSearch();
		
		Teacher[] teachersFoundListArray = new DatabaseSearchController().searchTeachersInList(teacherFormArray[0], 
				teacherFormArray[1], teacherFormArray[2]);
		
		Teacher teacher = (Teacher) new UserActionView().choiceUserInList(teachersFoundListArray);
		
		
	}
}
