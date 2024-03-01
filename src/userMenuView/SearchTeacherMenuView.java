//package userMenuView;
//
//import database.DatabaseSearchController;
//import tools.Alerts;
//import tools.Cnsl;
//
//import models.Teacher;
//import models.User;
//
//public class SearchTeacherMenuView {
////	Variables:
//	private UserActionView userActionView;
//	
////	Constructors:
//	public SearchTeacherMenuView() {
//		userActionView = new UserActionView();
//	}
//	
//	
////	Methods:
//	public void searchTeacherMenu(User teacherOwner) {
//		Alerts.separator();
//		Cnsl.println("Teacher search menu");
//		
//		String[] teacherFormArray = new FormForUserSearch().formForTeacherSearch();
//		
//		if(teacherFormArray == null) return;
//		
//		Teacher[] teachersFoundListArray = new DatabaseSearchController().searchTeachersInList(teacherFormArray[0], 
//				teacherFormArray[1], teacherFormArray[2]);
//		
//		if(teachersFoundListArray.length == 0) {
//			Cnsl.println("Not found!");
//		}
//		
//		Teacher teacher = (Teacher) userActionView.choiceUserInList(teachersFoundListArray);
//		
//		userActionView.whatToDoWithTheUser(teacherOwner, teacher);
//	}
//}
