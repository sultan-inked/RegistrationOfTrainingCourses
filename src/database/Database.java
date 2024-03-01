/*
 * Database - a class that manages a database using ArrayList.
 */

package database;

import java.util.List;

import models.Course;
import models.Student;
import models.Teacher;

import java.util.ArrayList;

public class Database {
//	Variables;
	
	private static List<Student> studentList = new ArrayList<>();
	private static List<Teacher> teacherList = new ArrayList<>();
	private static List<Course> courseList = new ArrayList<>();
	
	private String studentIdSignature = new Student().getStudentIdSignature().substring(0, 3);
	private String teacherIdSignature = new Teacher().getTeacherIdSignature().substring(0, 3);
	private String courseIdSignature = new Course().getCourseIdSignature().substring(0, 3);
	
//	Constructors:
	public Database() {
	}
	
//	Getters and Setters:
	public String getStudentIdSignature() {
		return studentIdSignature;
	}
	public String getTeacherIdSignature() {
		return teacherIdSignature;
	}
	public String getCourseIdSignature() {
		return courseIdSignature;
	}
	
	public Student[] getStudentListArray(){
		return studentList.toArray(new Student[studentList.size()]);
	}
	public Teacher[] getTeacherListArray() {
		return teacherList.toArray(new Teacher[teacherList.size()]);
	}
	public Course[] getCourseListArray() {
		return courseList.toArray(new Course[courseList.size()]);
	}
	
//	Lists actions:
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
}
