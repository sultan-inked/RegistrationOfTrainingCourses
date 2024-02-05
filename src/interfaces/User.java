package interfaces;

import objects.Course1;

public interface User {
	
	void showUserInfo();
	void enrollInCourse(Course1 course, User user);
	void unenrollInCourse(Course1 course, User user);
	void showEnrollCourseList();
	
}
