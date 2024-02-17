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
	// Add objects to list ->[]
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
		
		private boolean listAlreadyContain(Object object) {
			Object[] objectArray = null;
			String objectId = "";
			String objectTypeName = "";
			
			if(object instanceof Student) {
				objectArray = database.getStudentListArray();
				objectTypeName = ((Student)object).toString();
				objectId = ((Student)object).getUserId();
			}
			
			if(object instanceof Teacher) {
				objectArray = database.getTeacherListArray();
				objectTypeName = ((Teacher)object).toString();
				objectId = ((Teacher)object).getUserId();
			}
			
			if(object instanceof Course) {
				objectArray = database.getCourseListArray();
				objectTypeName = ((Course)object).toString();
				objectId = ((Course)object).getCourseId();
			}
			
			return listContainObject(object, objectArray, objectTypeName, objectId);
		}
		private boolean listContainObject(Object object, Object[] objectArray, 
											String objectTypeName, String objectId) {
			for(int i = 0; i < objectArray.length; i++) {
				if(objectArray[i].equals(object)) {
					Cnsl.println("Error: " + objectTypeName + " list is already contain id: " + objectId);
					return true;
				}
			}
			return false;
		}
		
		// Remove objects from list X<-[]
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
