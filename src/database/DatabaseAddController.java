package database;

import models.Course;
import models.Student;
import models.Teacher;
import tools.Cnsl;

public class DatabaseAddController {
//	Variables:
	private Database database;
	
//	Constructors:
	public DatabaseAddController() {
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
		Object[] objectListArray = null;
		String objectId = "";
		String objectTypeName = "";
		
		if(object instanceof Student) {
			objectListArray = database.getStudentListArray();
			objectTypeName = ((Student)object).toString();
			objectId = ((Student)object).getUserId();
		}
		
		if(object instanceof Teacher) {
			objectListArray = database.getTeacherListArray();
			objectTypeName = ((Teacher)object).toString();
			objectId = ((Teacher)object).getUserId();
		}
		
		if(object instanceof Course) {
			objectListArray = database.getCourseListArray();
			objectTypeName = ((Course)object).toString();
			objectId = ((Course)object).getCourseId();
		}
		
		return listContainObject(object, objectListArray, objectTypeName, objectId);
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
}
