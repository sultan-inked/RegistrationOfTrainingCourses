package database;

import models.Course;
import models.Student;
import models.Teacher;
import tools.Cnsl;

public class DatabaseAddRemoveController {
//	Variables:
	private Database database;
	
//	Constructors:
	public DatabaseAddRemoveController() {
		this.database = new Database();
	}
	
//	Methods:
	// Add to list ->[]
		public void addStudentToList(Student student) {
			if(!listAlreadyContain(student)){
				database.studentListAdd(student);
			}
		}
		public void addTeacherToList(Teacher teacher) {
			if(!listAlreadyContain(teacher)) {
				database.teacherListAdd(teacher);
			}
		}
		public void addCourseToList(Course course) {
			if(!listAlreadyContain(course)) {
				database.courseListAdd(course);
			}
		}
		private boolean listAlreadyContain(Object object) { // TODO:	Method requires optimization!
			if(object instanceof Student && database.studentListSize() != 0) {
				for(int i = 0; i < database.studentListSize(); i++) {
					if(database.studentListGet(i).getUserId().equals(((Student)object).getUserId())){
						Cnsl.println("Error: " + (Student)object + " list is already contain id" + ((Student)object).getUserId());
						return true;
					}
				}
			}
			if(object instanceof Teacher && database.teacherListSize() != 0) {
				for(int i = 0; i < database.teacherListSize(); i++) {
					if(database.teacherListGet(i).getUserId().equals(((Teacher)object).getUserId())){
						Cnsl.println("Error: " + (Teacher)object + " list is already contain id" + ((Teacher)object).getUserId());
						return true;
					}
				}
			}
			if(object instanceof Course && database.courseListSize() != 0) {
				for(int i = 0; i < database.courseListSize(); i++) {
					if(database.courseListGet(i).getCourseId().equals(((Course)object).getCourseId())){
						Cnsl.println("Error: " + (Course)object + " list is already contain id" + ((Course)object).getCourseId());
						return true;
					}
				}
			}
			return false;
		}
		
		// Remove from list X<-[]
		public void removeStudentFromList(Student student) {
			if(student != null && database.studentListSize() != 0) {
				for(int i = 0; i < database.studentListSize(); i++) {
					if(database.studentListGet(i).getUserId().equals(student.getUserId())) {
						database.studentListRemove(i);
						Cnsl.println(student + " with id: " + student.getUserId() + " removed!");
					}
				}
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
					}
				}
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
					}
				}
			}else {
				Cnsl.println("Error: " + course + " card or list are empty!");
			}
		}
}
