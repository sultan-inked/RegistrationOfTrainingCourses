package main;

import view.WelcomeView;

import database.DatabaseAddRemoveController;
import database.Database;
import models.Course;
import models.Student;
import models.Teacher;

public class MainApplication {
	public static void main(String[] args) {
		// Create default objects for test:
		new Database().addDefaultUserCards();
		
		// Start program:
		new WelcomeView().start();
	}
}

/*
* TODO:
* 1. Optimize and remove static methods
* 2. Optimize and remove infinite loops
* 3. Add feature with course: search, show list and create
* 		(Show who enrolled in every course by request)
* 
*/