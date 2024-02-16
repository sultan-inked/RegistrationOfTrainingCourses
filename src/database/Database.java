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
	
//	Constructors:
	public Database() {
	}
	
//	Getters and Setters:
	public String getCourseIdSignature() {
		return courseIdSignature;
	}
	
	public void studentListAdd(Student student) {
		studentList.add(student);
	}
	public void teacherListAdd(Teacher teacher) {
		teacherList.add(teacher);
	}
	public void courseListAdd(Course course) {
		courseList.add(course);
	}
	
	public int studentListSize() {
		return studentList.size();
	}
	public int teacherListSize() {
		return teacherList.size();
	}
	public int courseListSize() {
		return courseList.size();
	}
	
	public Student studentListGet(int index) {
		return studentList.get(index);
	}
	public Teacher teacherListGet(int index) {
		return teacherList.get(index);
	}
	public Course courseListGet(int index) {
		return courseList.get(index);
	}
	
	public void studentListRemove(int index) {
		studentList.remove(index);
	}
	public void teacherListRemove(int index) {
		teacherList.remove(index);
	}
	public void courseListRemove(int index) {
		courseList.remove(index);
	}
	
	
//	Methods:
	// Show lists []->{ )
	public void showList() {
		// TODO: Show list feature!
	}
	
	// Search in list and return object []->*
	public Object searchIdInList(String objectId) {
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
	public Student searchStudentInList(String studentId){
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
	public Teacher searchTeacherInList(String teacherId) {
		if(teacherListIsEmpty()) return null;
		for(int i = 0; i < teacherList.size(); i++) {
			if(teacherList.get(i).getUserId().equals(teacherId)) {
				return teacherList.get(i);
			}
		}
		Cnsl.println("Not found a teacher with the id: " + teacherId);
		return null;
	}
	public ArrayList<Teacher> searchTeacherInList(String firstName, String lastName, String teacherId){
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
	private boolean teacherListIsEmpty() {
		if(teacherList.size() == 0) {
			Cnsl.println("Teacher list is empty!");
			return true;
		}else {
			return false;
		}
	}
	
	// Search Course:
	public Course searchCourseInList(String courseId) {
		if(courseListIsEmpty()) return null;
		for(int i = 0; i < courseList.size(); i++) {
			if(courseList.get(i).getCourseId().equals(courseId)) {
				return courseList.get(i);
			}
		}
		Cnsl.println("Not found a course with the id: " + courseId);
		return null;
	}
	public ArrayList<Course> searchCourseInListByName(String courseName){
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
	public ArrayList<Course> searchCourseBySeveralAuthors(ArrayList<Teacher> teachersFoundArray){
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
	private boolean courseListIsEmpty() {
		if(courseList.size() == 0) {
			Cnsl.println("Course list is empty!");
			return true;
		}else {
			return false;
		}
	}
	
//	Create default objects:
	public void addDefaultUserCards() {
		var d = new DatabaseAddRemoveController();
		d.addStudentToList(new Student("Jesse", "Pinkman", "1234"));
		d.addStudentToList(new Student("Flin", "White", "1234"));
		d.addStudentToList(new Student("Gale", "Botticher", "1234"));
		d.addStudentToList(new Student("Skyler", "White", "1234"));
		d.addStudentToList(new Student("Bagher", "Dude", "1234"));
		d.addStudentToList(new Student("Skinny", "Pete", "1234"));
		d.addStudentToList(new Student("Hector", "Salamanka", "1234"));
		d.addStudentToList(new Student("Christian", "Combo", "1234"));
		d.addStudentToList(new Student("Tuco", "Salamanka", "1234"));
		d.addStudentToList(new Student("Sultan", "Abdrakhmanov", "12345"));
		
		d.addTeacherToList(new Teacher("Walter", "White", "1234"));
		d.addTeacherToList(new Teacher("Gustaf", "Fring", "1234"));
		d.addTeacherToList(new Teacher("Saul", "Goodman", "1234"));
		d.addTeacherToList(new Teacher("Hank", "Schrader", "1234"));
		
		d.addCourseToList(new Course(teacherList.get(0), "MethLab", "About how to cook meht."));
		d.addCourseToList(new Course(teacherList.get(1), "MethMarket", "How to delivery meth."));
		d.addCourseToList(new Course(teacherList.get(2), "Lawyer", "How to behave in an interrogation."));
		d.addCourseToList(new Course(teacherList.get(3), "Raid", "How to storm the house where the meth lab is."));
		d.addCourseToList(new Course(teacherList.get(1), "MethLab", "About how to building must of big and proffesional meth lab."));
		d.addCourseToList(new Course(teacherList.get(0), "MethLab", "About how to create temporal meth lab in the motor-house."));
		d.addCourseToList(new Course(teacherList.get(3), "MethLab", "How I can hate meth lab in the motor-house."));
		
		// Teachers and courses for course searching by id testing:
		d.addTeacherToList(new Teacher("Five", "Five", "1234")); // TCH000005
		d.addTeacherToList(new Teacher("nothing", "Five", "1234")); // TCH000006
		d.addTeacherToList(new Teacher("Five", "nothing", "1234")); // TCH000007
		d.addTeacherToList(new Teacher("Five", "Five", "1234")); // TCH000008
		
		d.addCourseToList(new Course(teacherList.get(4), "1", "1"));
		d.addCourseToList(new Course(teacherList.get(7), "2", "2"));
		d.addCourseToList(new Course(teacherList.get(7), "3", "3"));
		d.addCourseToList(new Course(teacherList.get(4), "4", "4"));
		d.addCourseToList(new Course(teacherList.get(5), "5", "5"));
		d.addCourseToList(new Course(teacherList.get(7), "6", "6"));
		d.addCourseToList(new Course(teacherList.get(6), "7", "7"));
		d.addCourseToList(new Course(teacherList.get(4), "8", "8"));
		d.addCourseToList(new Course(teacherList.get(4), "1", "1"));
		d.addCourseToList(new Course(teacherList.get(7), "2", "2"));
		d.addCourseToList(new Course(teacherList.get(7), "3", "3"));
		d.addCourseToList(new Course(teacherList.get(4), "4", "4"));
		d.addCourseToList(new Course(teacherList.get(5), "5", "5"));
		d.addCourseToList(new Course(teacherList.get(7), "6", "6"));
		d.addCourseToList(new Course(teacherList.get(6), "7", "7"));
		d.addCourseToList(new Course(teacherList.get(4), "8", "8"));
	}
	
	
	
	
}
