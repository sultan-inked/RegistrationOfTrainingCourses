
package objects;
import java.util.Arrays;
import java.util.ArrayList;

public class MainList {
	public void println(String str) {
		System.out.println(str);
	}
    static private ArrayList<Course> courseList = new ArrayList<Course>();
    static private ArrayList<Student> studentList = new ArrayList<Student>();
    static private ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
    
    private static int courseIdCount = 0, studentIdCount = 0, teacherIdCount = 0;
    
//    Methods:
    public String idGen(String str) {
    	switch(str) {
    	case "CRS00000":
    		this.courseIdCount++;
    		String crsC = "" + this.courseIdCount;
    		str = str.substring(0, str.length() - crsC.length());
    		str = str + crsC;
    		return str;
    	case "STD00000":
    		this.studentIdCount++;
    		String stdC = "" + this.studentIdCount;
    		str = str.substring(0, str.length() - stdC.length());
    		str = str + stdC;
    		return str;
    	case "TCH00000":
    		this.teacherIdCount++;
    		String tchC = "" + this.teacherIdCount;
    		str = str.substring(0, str.length() - tchC.length());
    		str = str + tchC;
    		return str;
    	}
    	return null;
    }
    
    public void addCourse(Course course){
        if(course != null) {
        	course.setCourseId(idGen("CRS00000"));
        	courseList.add(course);
        	println("Course Id:" + course.getCourseId());
        }
        else {
        	println("Error: Course is empty!");
        }
    }
    
    public void addStudent(Student student){
        if(student != null) {
        	student.setStudentId(idGen("STD00000"));
        	studentList.add(student);
        	println("Your Id:" + student.getStudentId());
        }
        else {
        	println("Error: Student is empty!");
        }
    }
    
    public void addTeacher(Teacher teacher) {
    	if(teacher != null) {
    		teacher.setTeacherId(idGen("TCH00000"));
    		teacherList.add(teacher);
    		println("Your Id:" + teacher.getTeacherId());
    	}
    	else {
    		println("Error: Teacher is empty!");
    	}
    }
    
    public void showStudentList() {
    	if(studentList.size() != 0) {
    		for(int i = 0; i < studentList.size(); i++) {
    			println(studentList.get(i).getStudentFirstName());
    		}
    	}
    }
    
    public void searchStudent(Student student) {
    	
    }
}
