package database;

import database.Database;

public class DatabaseShowListController {
//	Variables:
	private Database database;
	
//	Constructors:
	public DatabaseShowListController() {
		this.database = new Database();
	}
	
//	Methods:
	// It's using in CourseView.java
	public String getCourseIdSignature() {
		return database.getCourseIdSignature();
	}
	
	// Show lists []->{ )
	public void showListOfFiveItems() {
		// TODO: Show list feature!
	}
}
