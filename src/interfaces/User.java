package interfaces;

import objects.Course;

public interface User {
	
	void showUserInfo();
	void enrollInCourse(Course course, User user);
	void unenrollInCourse(Course course, User user);
	void showEnrollCourseList();
	
}
