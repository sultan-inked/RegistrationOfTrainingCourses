package main;

import view.WelcomeView;

import database.Database;

public class MainApplication {
	public static void main(String[] args) {
		// Create default objects for test:
		var database = new Database();
		database.addDefaultUserCards();
		database.addDefaultCoursesCards();
		
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