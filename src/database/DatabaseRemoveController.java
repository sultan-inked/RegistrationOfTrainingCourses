package database;

import models.Course;
import models.Student;
import models.Teacher;
import tools.Cnsl;

public class DatabaseRemoveController {
//	Variables:
	private Database database;
	
//	Constructors:
	public DatabaseRemoveController() {
		this.database = new Database();
	}
	
//	Methods:
	// Remove objects from list X<-[]
		public void removeStudentFromList(Student student) {
			if(student != null && database.studentListSize() != 0) {
				for(int i = 0; i < database.studentListSize(); i++) {
					if(database.studentListGet(i).getUserId().equals(student.getUserId())) {
						database.studentListRemove(i);
						Cnsl.println(student + " with id: " + student.getUserId() + " removed!");
						return;
					}
				}
				Cnsl.println("Not found " + student + " with id: " + student.getUserId());
			}else {
				Cnsl.println("Error: " + student + " card or list are empty!");
			}
		}
		public void removeTeacherFromList(Teacher teacher) {
			if(teacher != null && database.teacherListSize() != 0) {
				for(int i = 0; i < database.teacherListSize(); i++) {
					if(database.teacherListGet(i).getUserId().equals(teacher.getUserId())) {
						database.teacherListRemove(i);
						Cnsl.println(teacher + " with id: " + teacher.getUserId() + " removed!");
						return;
					}
				}
				Cnsl.println("Not found " + teacher + " with id: " + teacher.getUserId());
			}else {
				Cnsl.println("Error: " + teacher + " card or list are empty!");
			}
		}
		public void removeCourseFromList(Course course) {
			if(course != null && database.courseListSize() != 0) {
				for(int i = 0; i < database.courseListSize(); i++) {
					if(database.courseListGet(i).getCourseId().equals(course.getCourseId())) {
						database.courseListRemove(i);
						Cnsl.println(course + " with id: " + course.getCourseId() + " removed!");
						return;
					}
				}
				Cnsl.println("Not found " + course + " with id: " + course.getCourseId());
			}else {
				Cnsl.println("Error: " + course + " card or list are empty!");
			}
		}
}
