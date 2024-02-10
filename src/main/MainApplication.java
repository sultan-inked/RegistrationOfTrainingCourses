package main;

import view.WelcomeView;

import database.Database;

public class MainApplication {
	public static void main(String[] args) {
		// Add default users and courses for test:
		Database.addDefaultUserCards();
		Database.addDefaultCoursesCards();
		
		// Start program:
		WelcomeView.start();
	}
}

/*
* TODO:
* 1. Optimize and remove static methods
* 2. Optimize and remove infinite loops
* 3. Add feature with course: search, show list and create
* 		(Show who enrolled in every course by request)
* 4. Fix bag with unenrolling of course when you already enrolling on another course
*/