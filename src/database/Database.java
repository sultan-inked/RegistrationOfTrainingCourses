/*
 * Database - a class that manages a database using ArrayList.
 */

package database;

import java.util.List;
import java.util.ArrayList;

import model.Student;
import model.Teacher;
import model.User;
import model.Course;
import tools.Cnsl;

public class Database {
//	Variables;
	private static List<Student> studentList = new ArrayList<>();
	private static List<Teacher> teacherList = new ArrayList<>();
	private static List<Course> courseList = new ArrayList<>();
	
	private static String studentIdSignature = Student.getStudentIdSignature().substring(0, 3);
	private static String teacherIdSignature = Teacher.getTeacherIdSignature().substring(0, 3);
	private static String courseIdSignature = Course.getCourseIdSignature().substring(0, 3);
	
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
		if(teacherList.size() == 0) {
			Cnsl.println("Teacher list is empty!");
			return null;
		}
		for(int i = 0; i < teacherList.size(); i++) {
			if(teacherList.get(i).getUserId().equals(teacherId)) {
				return teacherList.get(i);
			}
		}
		Cnsl.println("Not found a teacher with the id:" + teacherId);
		return null;
	}

//	Create default objects:
	public static void addDefaultUserCards() {
		addTeacherToList(new Teacher("Walter", "White", "1234"));
		addTeacherToList(new Teacher("Gustaf", "Fring", "1234"));
		addTeacherToList(new Teacher("Saul", "Goodman", "1234"));
		addTeacherToList(new Teacher("Hank", "Schrader", "1234"));
		
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
	}
	
	public static void addDefaultCoursesCards() {
		addCourseToList(new Course(teacherList.get(0), "MethLab", "About how to cook meht."));
		addCourseToList(new Course(teacherList.get(1), "MethMarket", "How to delivery meth."));
		addCourseToList(new Course(teacherList.get(2), "Lawyer", "How to behave in an interrogation."));
		addCourseToList(new Course(teacherList.get(3), "Raid", "How to storm the house where the meth lab is."));
	}
	
	
	
	
}
