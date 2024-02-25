package userMenuView;

import models.Teacher;
import models.Student;
import models.User;
import tools.Cnsl;

public class UserActionView {
	
	
	
	public Object choiceUserInList(User[] usersFoundListArray) {
		if(usersFoundListArray.length == 0) {
			Cnsl.println("User list is empty.");
			return null;
		}
		for(int i = 0; i < usersFoundListArray.length; i++) {
			Cnsl.println((i+1) + ". Name: " + usersFoundListArray[i].getFirstName() + "\n"
					+ "   Last name: " + usersFoundListArray[i].getLastName() + "\n"
					+ "   Id: " + usersFoundListArray[i].getUserId());
		}
		
		// Loop for handling input exception:
		while(true) {
			Cnsl.print("Write number with your choice:");
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
}
