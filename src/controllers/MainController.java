/*
 * MainController - the main controller that manages the interaction
 * between the model and the view.
 */

/*
Using the MainController class as a general gateway for managing interactions between the model and the 
view can have both pros and cons. Let's consider them:

Pros:

Simplified Usage: It allows isolating complex actions and methods related to database interaction in one place.
This makes the code more convenient to use and maintain since developers can simply call MainController methods
without worrying about implementation details.

Hiding Complexity: If interaction with the database or other components is complex and subject to change,
MainController can hide this complexity, providing a simpler interface for working with these components.

Cons:

Potential Loss of Flexibility: The MainController class may become a bottleneck that ties too many different
system components together. This can lead to loss of flexibility, as any changes in one of the components may
affect MainController and, consequently, all its clients.

Testing Complexity: If MainController contains too much functionality, it can complicate testing since it's
necessary to consider all possible execution paths and dependencies on other components.

Possible Violation of SRP: If MainController starts to contain too many different methods responsible for
various aspects of the system, it may violate the Single Responsibility Principle (SRP), as a class should be
responsible for only one part of functionality.

So, using MainController as a general gateway can be an effective approach if properly designed and used.
However, it's important to be mindful of potential drawbacks and ensure that the class does not become too
complex and violate good design principles.
 */

package controllers;

import java.util.ArrayList;

import database.*;
import models.*;
import tools.Cnsl;

public class MainController {
//	Variables:
	private Database database;
	
//	Constructors:
	public MainController() {
		this.database = new Database();
	}
	
//	Methods:
	// It's using in RegistrationView.java
	public String dataTransferToCreateStudentCardAndReturnId(String[] formArray) {
		return new StudentController().createStudentCardSaveAndReturnId(formArray, new DatabaseAddRemoveController());
	}
	public String dataTransferToCreateTeacherCardAndReturnId(String[] formArray) {
		return new TeacherController().createTeacherCardSaveAndReturnId(formArray, new DatabaseAddRemoveController());
	}
	public String dataTransferToCreateCourseCardAndReturnId(String[] formArray, Teacher teacher) {
		return new CourseController().createCourseCardSaveAndReturnId(formArray, teacher, new DatabaseAddRemoveController());
	}
	
	// It's using in LoginView.java
	public User transferIdForValidate(String userId) {
		return (User)database.searchIdInList(userId);
	}
	
	// Search user:
	public ArrayList<Teacher> searchTeacherAndReturAllOfMatches(String firstName, 
																	String lastName, String teacherId){
		return database.searchTeacherInList(firstName, lastName, teacherId);
	}
	
	// It's using in CourseView.java
	public String getCourseIdSignature() {
		return database.getCourseIdSignature();
	}
	
	public Course searchCourseById(String courseId) {
		return (Course)database.searchIdInList(courseId);
	}
	
	public ArrayList<Course> searchCourseByNameAndReturnArrayList(String courseName){
		return database.searchCourseInListByName(courseName);
	}
	
	public ArrayList<Course> searchCourseBySeveralAuthorsAndReturnArrayList(ArrayList<Teacher> teachersFoundList){
		return database.searchCourseBySeveralAuthors(teachersFoundList);
	}
	
	// Enroll and unenroll in course methods:
	public void enrollInCourse(User user, Course course) {
		if(user instanceof Student) {
			new StudentController().enrollInCourse(new CourseController(), course, user);
		}
		if(user instanceof Teacher) {
			new TeacherController().enrollInCourse(new CourseController(), course, user);
		}
	}
	public void unenrollInCourse(User user, Course course) {
		if(user instanceof Student) {
			new StudentController().unenrollInCourse(new CourseController(), course, user);	
		}
		if(user instanceof Teacher) {
			new TeacherController().unenrollInCourse(new CourseController(), course, user);
		}
	}
}
