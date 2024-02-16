/*
 * Database - a class that manages a database using ArrayList.
 */

package database;

import java.util.List;

import models.Course;
import models.Student;
import models.Teacher;
import models.User;

import java.util.ArrayList;

import tools.Cnsl;

public class Database {
//	Variables;
	private static List<Student> studentList = new ArrayList<>();
	private static List<Teacher> teacherList = new ArrayList<>();
	private static List<Course> courseList = new ArrayList<>();
	
	private static String studentIdSignature = new Student().getStudentIdSignature().substring(0, 3);
	private static String teacherIdSignature = new Teacher().getTeacherIdSignature().substring(0, 3);
	private static String courseIdSignature = new Course().getCourseIdSignature().substring(0, 3);
	
//	Getters and Setters:
	public static String getCourseIdSignature() {
		return courseIdSignature;
	}
	
//	Methods:
	// Show lists []->{ )
	public static void showList() {
		// TODO: Show list feature!
	}
	public static void showTeacherListIdName() {
		for(Teacher teacher: teacherList) {
			Cnsl.println(teacher.getUserId() + teacher.getFirstName());
		}
	}
	
	// Add to list ->[]
	public static void addStudentToList(Student student) {
		if(!listAlreadyContain(student)){
			studentList.add(student);
		}
	}
	public static void addTeacherToList(Teacher teacher) {
		if(!listAlreadyContain(teacher)) {
			teacherList.add(teacher);
		}
	}
	public static void addCourseToList(Course course) {
		if(!listAlreadyContain(course)) {
			courseList.add(course);
		}
	}
	private static boolean listAlreadyContain(Object object) { // TODO:	Method requires optimization!
		if(object instanceof Student && studentList.size() != 0) {
			for(int i = 0; i < studentList.size(); i++) {
				if(studentList.get(i).getUserId().equals(((Student)object).getUserId())){
					Cnsl.println("Error: " + (Student)object + " list is already contain id" + ((Student)object).getUserId());
					return true;
				}
			}
		}
		if(object instanceof Teacher && teacherList.size() != 0) {
			for(int i = 0; i < teacherList.size(); i++) {
				if(teacherList.get(i).getUserId().equals(((Teacher)object).getUserId())){
					Cnsl.println("Error: " + (Teacher)object + " list is already contain id" + ((Teacher)object).getUserId());
					return true;
				}
			}
		}
		if(object instanceof Course && courseList.size() != 0) {
			for(int i = 0; i < courseList.size(); i++) {
				if(courseList.get(i).getCourseId().equals(((Course)object).getCourseId())){
					Cnsl.println("Error: " + (Course)object + " list is already contain id" + ((Course)object).getCourseId());
					return true;
				}
			}
		}
		return false;
	}
	
	// Remove from list X<-[]
	public static void removeStudentFromList(Student student) {
		if(student != null && studentList.size() != 0) {
			for(int i = 0; i < studentList.size(); i++) {
				if(studentList.get(i).getUserId().equals(student.getUserId())) {
					studentList.remove(i);
					Cnsl.println(student + " with id: " + student.getUserId() + " removed!");
				}
			}
		}else {
			Cnsl.println("Error: " + student + " card or list are empty!");
		}
	}
	public static void removeTeacherFromList(Teacher teacher) {
		if(teacher != null && teacherList.size() != 0) {
			for(int i = 0; i < teacherList.size(); i++) {
				if(teacherList.get(i).getUserId().equals(teacher.getUserId())) {
					teacherList.remove(i);
					Cnsl.println(teacher + " with id: " + teacher.getUserId() + " removed!");
				}
			}
		}else {
			Cnsl.println("Error: " + teacher + " card or list are empty!");
		}
	}
	public static void removeCourseFromList(Course course) {
		if(course != null && courseList.size() != 0) {
			for(int i = 0; i < courseList.size(); i++) {
				if(courseList.get(i).getCourseId().equals(course.getCourseId())) {
					courseList.remove(i);
					Cnsl.println(course + " with id: " + course.getCourseId() + " removed!");
				}
			}
		}else {
			Cnsl.println("Error: " + course + " card or list are empty!");
		}
	}
	
	// Search in list and return object []->*
	public static Object searchIdInList(String objectId) {
		if(objectId.length() < 3) {
			Cnsl.println("Incorrect id!");
			return null;
		}
		if(objectId.substring(0, 3).equals(studentIdSignature)) {
			return searchStudentInList(objectId);
		}
		if(objectId.substring(0, 3).equals(teacherIdSignature)) {
			return searchTeacherInList(objectId);
		}
		if(objectId.substring(0, 3).equals(courseIdSignature)) {
			return searchCourseInList(objectId);
		}
		Cnsl.println("Incorrect id!");
		return null;

	}
	
	// Search Student:
	public static Student searchStudentInList(String studentId){
		if(studentList.size() == 0) {
			Cnsl.println("Student list is empty!");
			return null;
		}
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getUserId().equals(studentId)) {
				return studentList.get(i);
			}
		}
		Cnsl.println("Not found a student with the id: " + studentId);
		return null;
	}
	
	// Search Teacher:
	public static Teacher searchTeacherInList(String teacherId) {
		if(teacherListIsEmpty()) return null;
		for(int i = 0; i < teacherList.size(); i++) {
			if(teacherList.get(i).getUserId().equals(teacherId)) {
				return teacherList.get(i);
			}
		}
		Cnsl.println("Not found a teacher with the id: " + teacherId);
		return null;
	}
	public static ArrayList<Teacher> searchTeacherInList(String firstName, String lastName, String teacherId){
		ArrayList<Teacher> teachersFoundListThreeMatches = new ArrayList<>();
		ArrayList<Teacher> teachersFoundListTwoMatches = new ArrayList<>();
		ArrayList<Teacher> teachersFoundListOneMatches = new ArrayList<>();
		ArrayList<Teacher> teachersFoundListCommon = new ArrayList<>();
		if(teacherListIsEmpty()) return null;
		for(int i = 0; i < teacherList.size(); i++) {
			int matchesCounter = 0;
			if(firstName != null && teacherList.get(i).getFirstName().equals(firstName)) matchesCounter++;
			if(lastName != null && teacherList.get(i).getLastName().equals(lastName)) matchesCounter++;
			if(teacherId != null && teacherList.get(i).getUserId().equals(teacherId)) matchesCounter++;
			
			if(matchesCounter == 3) teachersFoundListThreeMatches.add(teacherList.get(i));
			else if(matchesCounter == 2) teachersFoundListTwoMatches.add(teacherList.get(i));
			else if(matchesCounter == 1) teachersFoundListOneMatches.add(teacherList.get(i));
		}
		for(Teacher teacher: teachersFoundListThreeMatches) {
			teachersFoundListCommon.add(teacher);
		}
		for(Teacher teacher: teachersFoundListTwoMatches) {
			teachersFoundListCommon.add(teacher);
		}
		for(Teacher teacher: teachersFoundListOneMatches) {
			teachersFoundListCommon.add(teacher);
		}
		return teachersFoundListCommon;
	}
	private static boolean teacherListIsEmpty() {
		if(teacherList.size() == 0) {
			Cnsl.println("Teacher list is empty!");
			return true;
		}else {
			return false;
		}
	}
	
	// Search Course:
	public static Course searchCourseInList(String courseId) {
		if(courseListIsEmpty()) return null;
		for(int i = 0; i < courseList.size(); i++) {
			if(courseList.get(i).getCourseId().equals(courseId)) {
				return courseList.get(i);
			}
		}
		Cnsl.println("Not found a course with the id: " + courseId);
		return null;
	}
	public static ArrayList<Course> searchCourseInListByName(String courseName){
		if(courseListIsEmpty() || courseName.equals("")) return null;
		ArrayList<Course> coursesFoundList = new ArrayList<>();
		for(int i = 0; i < courseList.size(); i++) {
			if(courseList.get(i).getCourseName().equals(courseName)) {
				coursesFoundList.add(courseList.get(i));
			}
		}
		if(coursesFoundList.size() == 0) {
			Cnsl.println("Not found a course with the name: " + courseName);
		}
		return coursesFoundList;
	}
	public static ArrayList<Course> searchCourseBySeveralAuthors(ArrayList<Teacher> teachersFoundArray){
		if(courseListIsEmpty()) return null;
		ArrayList<Course> coursesFoundArray = new ArrayList<>();
		for(int i = 0; i < courseList.size(); i++) {
			for(int j = 0; j < teachersFoundArray.size(); j++) {
				if(teachersFoundArray.get(j) == courseList.get(i).getCourseCreator()) {
					coursesFoundArray.add(courseList.get(i));
				}
			}
		}
		return coursesFoundArray;
	}
	private static boolean courseListIsEmpty() {
		if(courseList.size() == 0) {
			Cnsl.println("Course list is empty!");
			return true;
		}else {
			return false;
		}
	}
	
//	Create default objects:
	public static void addDefaultUserCards() {
		addStudentToList(new Student("Jesse", "Pinkman", "1234"));
		addStudentToList(new Student("Flin", "White", "1234"));
		addStudentToList(new Student("Gale", "Botticher", "1234"));
		addStudentToList(new Student("Skyler", "White", "1234"));
		addStudentToList(new Student("Bagher", "Dude", "1234"));
		addStudentToList(new Student("Skinny", "Pete", "1234"));
		addStudentToList(new Student("Hector", "Salamanka", "1234"));
		addStudentToList(new Student("Christian", "Combo", "1234"));
		addStudentToList(new Student("Tuco", "Salamanka", "1234"));
		addStudentToList(new Student("Sultan", "Abdrakhmanov", "12345"));
		
		addTeacherToList(new Teacher("Walter", "White", "1234"));
		addTeacherToList(new Teacher("Gustaf", "Fring", "1234"));
		addTeacherToList(new Teacher("Saul", "Goodman", "1234"));
		addTeacherToList(new Teacher("Hank", "Schrader", "1234"));
		
		// Teachers and courses for course searching by id testing:
		addTeacherToList(new Teacher("Five", "Five", "1234")); // TCH000005
		addTeacherToList(new Teacher("nothing", "Five", "1234")); // TCH000006
		addTeacherToList(new Teacher("Five", "nothing", "1234")); // TCH000007
		addTeacherToList(new Teacher("Five", "Five", "1234")); // TCH000008
		
		
	}
	
	public static void addDefaultCoursesCards() {
		addCourseToList(new Course(teacherList.get(0), "MethLab", "About how to cook meht."));
		addCourseToList(new Course(teacherList.get(1), "MethMarket", "How to delivery meth."));
		addCourseToList(new Course(teacherList.get(2), "Lawyer", "How to behave in an interrogation."));
		addCourseToList(new Course(teacherList.get(3), "Raid", "How to storm the house where the meth lab is."));
		addCourseToList(new Course(teacherList.get(1), "MethLab", "About how to building must of big and proffesional meth lab."));
		addCourseToList(new Course(teacherList.get(0), "MethLab", "About how to create temporal meth lab in the motor-house."));
		addCourseToList(new Course(teacherList.get(3), "MethLab", "How I can hate meth lab in the motor-house."));
		
		addCourseToList(new Course(teacherList.get(4), "1", "1"));
		addCourseToList(new Course(teacherList.get(7), "2", "2"));
		addCourseToList(new Course(teacherList.get(7), "3", "3"));
		addCourseToList(new Course(teacherList.get(4), "4", "4"));
		addCourseToList(new Course(teacherList.get(5), "5", "5"));
		addCourseToList(new Course(teacherList.get(7), "6", "6"));
		addCourseToList(new Course(teacherList.get(6), "7", "7"));
		addCourseToList(new Course(teacherList.get(4), "8", "8"));
		addCourseToList(new Course(teacherList.get(4), "1", "1"));
		addCourseToList(new Course(teacherList.get(7), "2", "2"));
		addCourseToList(new Course(teacherList.get(7), "3", "3"));
		addCourseToList(new Course(teacherList.get(4), "4", "4"));
		addCourseToList(new Course(teacherList.get(5), "5", "5"));
		addCourseToList(new Course(teacherList.get(7), "6", "6"));
		addCourseToList(new Course(teacherList.get(6), "7", "7"));
		addCourseToList(new Course(teacherList.get(4), "8", "8"));
	}
	
	
	
	
}
