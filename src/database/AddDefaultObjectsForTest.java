package database;

import models.Course;
import models.Student;
import models.Teacher;

import tools.HashCode;

public class AddDefaultObjectsForTest {
//	Create default objects:
	public void add() {
		var d = new DatabaseAddController();
		var db = new Database();
		var hc = new HashCode();
		d.addStudentToList(new Student("Jesse", "Pinkman", hc.makeHashCode("1234")));
		d.addStudentToList(new Student("Flin", "White", hc.makeHashCode("1234")));
		d.addStudentToList(new Student("Gale", "Botticher", hc.makeHashCode("1234")));
		d.addStudentToList(new Student("Skyler", "White", hc.makeHashCode("1234")));
		d.addStudentToList(new Student("Bagher", "Dude", hc.makeHashCode("1234")));
		d.addStudentToList(new Student("Skinny", "Pete", hc.makeHashCode("1234")));
		d.addStudentToList(new Student("Hector", "Salamanka", hc.makeHashCode("1234")));
		d.addStudentToList(new Student("Christian", "Combo", hc.makeHashCode("1234")));
		d.addStudentToList(new Student("Tuco", "Salamanka", hc.makeHashCode("1234")));
		d.addStudentToList(new Student("Sultan", "Abdrakhmanov", hc.makeHashCode("12345")));
		
		d.addTeacherToList(new Teacher("Walter", "White", hc.makeHashCode("1234")));
		d.addTeacherToList(new Teacher("Gustaf", "Fring", hc.makeHashCode("1234")));
		d.addTeacherToList(new Teacher("Saul", "Goodman", hc.makeHashCode("1234")));
		d.addTeacherToList(new Teacher("Hank", "Schrader", hc.makeHashCode("1234")));
		
		d.addCourseToList(new Course(db.teacherListGet(0), "MethLab", "About how to cook meht."));
		d.addCourseToList(new Course(db.teacherListGet(1), "MethMarket", "How to delivery meth."));
		d.addCourseToList(new Course(db.teacherListGet(2), "Lawyer", "How to behave in an interrogation."));
		d.addCourseToList(new Course(db.teacherListGet(3), "Raid", "How to storm the house where the meth lab is."));
		d.addCourseToList(new Course(db.teacherListGet(1), "MethLab", "About how to building must of big and proffesional meth lab."));
		d.addCourseToList(new Course(db.teacherListGet(0), "MethLab", "About how to create temporal meth lab in the motor-house."));
		d.addCourseToList(new Course(db.teacherListGet(3), "MethLab", "How I can hate meth lab in the motor-house."));
		
		// Teachers and courses for course searching by id testing:
		d.addTeacherToList(new Teacher("Five", "Five", hc.makeHashCode("1234"))); // TCH000005
		d.addTeacherToList(new Teacher("nothing", "Five", hc.makeHashCode("1234"))); // TCH000006
		d.addTeacherToList(new Teacher("Five", "nothing", hc.makeHashCode("1234"))); // TCH000007
		d.addTeacherToList(new Teacher("Five", "Five", hc.makeHashCode("1234"))); // TCH000008
		
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
