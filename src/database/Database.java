/*
 * Database - a class that manages a database using ArrayList.
 */

package database;

import java.util.List;
import java.util.ArrayList;

import model.Student;
import model.Teacher;
import model.Course;
import tools.Cnsl;

public class Database {
//	Variables;
	private static List<Student> studentList = new ArrayList<>();
	private static List<Teacher> teacherList = new ArrayList<>();
	private static List<Course> courseList = new ArrayList<>();
	
//	Methods:
	// Add to list ->[]
	public void addStudentToList(Student student) {
		if(!listAlreadyContain(student)){
			studentList.add(student);
		}
	}
	public void addTeacherToList(Teacher teacher) {
		if(!listAlreadyContain(teacher)) {
			teacherList.add(teacher);
		}
	}
	public void addCourseToList(Course course) {
		if(!listAlreadyContain(course)) {
			courseList.add(course);
		}
	}
	public boolean listAlreadyContain(Object object) { // TODO:	Method requires optimization!
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
	public void removeStudentFromList(Student student) {
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
	public void removeTeacherFromList(Teacher teacher) {
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
	public void removeCourseFromList(Course course) {
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
	
	
}
