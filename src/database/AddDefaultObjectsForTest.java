package database;

import models.Course;
import models.Student;
import models.Teacher;

public class AddDefaultObjectsForTest {
//	Create default objects:
	public void add() {
		var d = new DatabaseAddController();
		var db = new Database();
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
		
		d.addCourseToList(new Course(db.teacherListGet(0), "MethLab", "About how to cook meht."));
		d.addCourseToList(new Course(db.teacherListGet(1), "MethMarket", "How to delivery meth."));
		d.addCourseToList(new Course(db.teacherListGet(2), "Lawyer", "How to behave in an interrogation."));
		d.addCourseToList(new Course(db.teacherListGet(3), "Raid", "How to storm the house where the meth lab is."));
		d.addCourseToList(new Course(db.teacherListGet(1), "MethLab", "About how to building must of big and proffesional meth lab."));
		d.addCourseToList(new Course(db.teacherListGet(0), "MethLab", "About how to create temporal meth lab in the motor-house."));
		d.addCourseToList(new Course(db.teacherListGet(3), "MethLab", "How I can hate meth lab in the motor-house."));
		
		// Teachers and courses for course searching by id testing:
		d.addTeacherToList(new Teacher("Five", "Five", "1234")); // TCH000005
		d.addTeacherToList(new Teacher("nothing", "Five", "1234")); // TCH000006
		d.addTeacherToList(new Teacher("Five", "nothing", "1234")); // TCH000007
		d.addTeacherToList(new Teacher("Five", "Five", "1234")); // TCH000008
		
		d.addCourseToList(new Course(db.teacherListGet(4), "1", "1"));
		d.addCourseToList(new Course(db.teacherListGet(7), "2", "2"));
		d.addCourseToList(new Course(db.teacherListGet(7), "3", "3"));
		d.addCourseToList(new Course(db.teacherListGet(4), "4", "4"));
		d.addCourseToList(new Course(db.teacherListGet(5), "5", "5"));
		d.addCourseToList(new Course(db.teacherListGet(7), "6", "6"));
		d.addCourseToList(new Course(db.teacherListGet(6), "7", "7"));
		d.addCourseToList(new Course(db.teacherListGet(4), "8", "8"));
		d.addCourseToList(new Course(db.teacherListGet(4), "1", "1"));
		d.addCourseToList(new Course(db.teacherListGet(7), "2", "2"));
		d.addCourseToList(new Course(db.teacherListGet(7), "3", "3"));
		d.addCourseToList(new Course(db.teacherListGet(4), "4", "4"));
		d.addCourseToList(new Course(db.teacherListGet(5), "5", "5"));
		d.addCourseToList(new Course(db.teacherListGet(7), "6", "6"));
		d.addCourseToList(new Course(db.teacherListGet(6), "7", "7"));
		d.addCourseToList(new Course(db.teacherListGet(4), "8", "8"));
	}
}
