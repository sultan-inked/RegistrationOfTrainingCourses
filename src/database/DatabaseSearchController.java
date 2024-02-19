package database;

import java.util.ArrayList;

import models.Course;
import models.Student;
import models.Teacher;
import tools.Cnsl;

public class DatabaseSearchController {
//	Variables:
	private Database database;
	
//	Constructors:
	public DatabaseSearchController() {
		this.database = new Database();
	}
	
//	Methods:
	// Search in list and return object []->*
	public Object searchIdInList(String objectId) {
		if(objectId.length() < 3) {
			Cnsl.println("Incorrect id!");
			return null;
		}
		if(objectId.substring(0, 3).equals(database.getStudentIdSignature())) {
			return searchStudentInList(objectId);
		}
		if(objectId.substring(0, 3).equals(database.getTeacherIdSignature())) {
			return searchTeacherInList(objectId);
		}
		if(objectId.substring(0, 3).equals(database.getCourseIdSignature())) {
			return searchCourseInList(objectId);
		}
		Cnsl.println("Incorrect id!");
		return null;
	}
	
	// Search Student by Id:
	public Student searchStudentInList(String studentId){
		if(database.studentListSize() == 0) {
			Cnsl.println("Student list is empty!");
			return null;
		}
		for(int i = 0; i < database.studentListSize(); i++) {
			if(database.studentListGet(i).getUserId().equals(studentId)) {
				return database.studentListGet(i);
			}
		}
		Cnsl.println("Not found a student with the id: " + studentId);
		return null;
	}
	
	
	// Search Teacher by Id:
	public Teacher searchTeacherInList(String teacherId) {
		if(teacherListIsEmpty()) return null;
		for(int i = 0; i < database.teacherListSize(); i++) {
			if(database.teacherListGet(i).getUserId().equals(teacherId)) {
				return database.teacherListGet(i);
			}
		}
		Cnsl.println("Not found a teacher with the id: " + teacherId);
		return null;
	}
	// Search for teachers in the list by matches:
	public Teacher[] searchTeachersInList(String firstName, String lastName, String teacherId){
		
		if(teacherListIsEmpty()) return null;
		
		ArrayList<Teacher> teachersFoundListThreeMatches = new ArrayList<>();
		ArrayList<Teacher> teachersFoundListTwoMatches = new ArrayList<>();
		ArrayList<Teacher> teachersFoundListOneMatches = new ArrayList<>();
		
		for(int i = 0; i < database.teacherListSize(); i++) {
			Teacher teacher = database.teacherListGet(i);
			int matchesCounter = 0;
			if(firstName != null && teacher.getFirstName().equals(firstName)) matchesCounter++;
			if(lastName != null && teacher.getLastName().equals(lastName)) matchesCounter++;
			if(teacherId != null && teacher.getUserId().equals(teacherId)) matchesCounter++;
			
			if(matchesCounter == 3) teachersFoundListThreeMatches.add(database.teacherListGet(i));
			else if(matchesCounter == 2) teachersFoundListTwoMatches.add(database.teacherListGet(i));
			else if(matchesCounter == 1) teachersFoundListOneMatches.add(database.teacherListGet(i));
		}
		
		ArrayList<Teacher> teachersFoundListCommon = new ArrayList<>();
		teachersFoundListCommon.addAll(teachersFoundListThreeMatches);
		teachersFoundListCommon.addAll(teachersFoundListTwoMatches);
		teachersFoundListCommon.addAll(teachersFoundListOneMatches);
		
		return teachersFoundListCommon.toArray(new Teacher[teachersFoundListCommon.size()]);
	}
	// Check Teachers list:
	private boolean teacherListIsEmpty() {
		if(database.teacherListSize() == 0) {
			Cnsl.println("Teacher list is empty!");
			return true;
		}else {
			return false;
		}
	}	
	
	
	// Search Course by Id:
	public Course searchCourseInList(String courseId) {
		if(courseListIsEmpty()) return null;
		for(int i = 0; i < database.courseListSize(); i++) {
			if(database.courseListGet(i).getCourseId().equals(courseId)) {
				return database.courseListGet(i);
			}
		}
		Cnsl.println("Not found a course with the id: " + courseId);
		return null;
	}	
	public ArrayList<Course> searchCourseInListByName(String courseName){
		if(courseListIsEmpty()) return null;
		ArrayList<Course> coursesFoundList = new ArrayList<>();
		for(int i = 0; i < database.courseListSize(); i++) {
			if(database.courseListGet(i).getCourseName().equals(courseName)) {
				coursesFoundList.add(database.courseListGet(i));
			}
		}
		if(coursesFoundList.size() == 0) {
			Cnsl.println("Not found a course with the name: " + courseName);
		}
		return coursesFoundList;
	}
	public ArrayList<Course> searchCourseBySeveralAuthors(Teacher[] teachersFoundListArray){
		if(courseListIsEmpty()) return null;
		ArrayList<Course> coursesFoundArray = new ArrayList<>();
		for(int i = 0; i < database.courseListSize(); i++) {
			for(int j = 0; j < teachersFoundListArray.length; j++) {
				if(teachersFoundListArray[j] == database.courseListGet(i).getCourseCreator()) {
					coursesFoundArray.add(database.courseListGet(i));
				}
			}
		}
		return coursesFoundArray;
	}
	private boolean courseListIsEmpty() {
		if(database.courseListSize() == 0) {
			Cnsl.println("Course list is empty!");
			return true;
		}else {
			return false;
		}
	}
}
