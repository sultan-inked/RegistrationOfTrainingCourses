package main;

import view.WelcomeView;
import database.AddDefaultObjects;

public class MainApplication {
	public static void main(String[] args) {
		// Create default objects for test:
		new AddDefaultObjects().add();
		
		// Start program:
		new WelcomeView().start();
	}
}

/*
* TODO:
* 1. Optimize and remove static methods ---
* 2. Optimize and remove infinite loops ---
* 3. Add feature with course: search, show list and create
* 		(Show who enrolled in every course by request)
* 
*/