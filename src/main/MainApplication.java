package main;

import view.WelcomeView;

import database.Database;

public class MainApplication {
	public static void main(String[] args) {
		// Add default users for test:
		Database.addDefaultUserCards();
		
		WelcomeView.start();
	}
}
