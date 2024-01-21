
package objects;
//import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class MainList {
	public void println(String str) {
		System.out.println(str);
	}
	public void print(String str) {
		System.out.print(str);
	}
    public String scan() {
    	var scan = new Scanner(System.in);
    	return scan.nextLine();
    }
	
	static private ArrayList<Course> courseList = new ArrayList<Course>();
    static private ArrayList<Student> studentList = new ArrayList<Student>();
    static private ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
    
    private static int courseIdCount = 0, studentIdCount = 0, teacherIdCount = 0;
    
//    Methods:
//    ADD ##################################################
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
//    SEARCHING ###########################################
    public void showCourseList() {
    	if(courseList.size() != 0) {
    		for(int i = 0; i < courseList.size(); i++) {
    			println((i+1) + ". " + courseList.get(i).getCourseName() + " " +
    								courseList.get(i).getCourseId() + " " +
    								courseList.get(i).getCourseAutorFullName());
    		}
    	}
    	else {
    		println("Course list is empty!");
    	}
    }
    public void showStudentList() {
    	if(studentList.size() != 0) {
    		for(int i = 0; i < studentList.size(); i++) {
    			println((i+1) + ". " + studentList.get(i).getStudentFirstName() + " " +
    								studentList.get(i).getStudentLastName() + " " +
    								studentList.get(i).getStudentId());
    		}
    	}
    	else {
    		println("Student list is empty!");
    	}
    }
    public void showTeacherList() {
    	if(teacherList.size() != 0) {
    		for(int i = 0; i < teacherList.size(); i++) {
    			println((i+1) + ". " + teacherList.get(i).getTeacherFirstName() + " " +
    								teacherList.get(i).getTeacherLastName() + " " +
    								teacherList.get(i).getTeacherId());
    		}
    	}
    	else {
    		println("Teacher list is empty");
    	}
    }
    
//    course:
    public Course searchCourseNameId(String name, String id) {
    	if(courseList.size() == 0) {
    		println("Course list is empty!");
    		return null;
    	}
    	if(id.trim().equals("")) {
    		return searchCourseName(name);
    	}
    	
    	for(int i = 0; i < courseList.size(); i++) {
    		if(courseList.get(i).getCourseId().equals(id)){
    			return courseList.get(i);
    		}
    	}
    	println("Course with id:" + id + " is not found!");
    	return searchCourseName(name);
    }
    public Course searchCourseName(String name) {
    	int cntr = 1;
		ArrayList<Course> courseListTemp = new ArrayList<Course>();
		for(int i = 0; i < courseList.size(); i++) {
			if(courseList.get(i).getCourseName().equals(name)) {
				println(cntr + ". " + courseList.get(i).getCourseName() + " " +
						courseList.get(i).getCourseId() + " " +
						courseList.get(i).getCourseAutorFullName());
				println("   Description: " + courseList.get(i).getCourseDescription());
				courseListTemp.add(courseList.get(i));
			}
		}
		if(courseListTemp.size() != 0) {
			for(int i = 0; i == 0;) {
				print("Choice course:");
	    		var choice = scan();
	    		if(!choice.trim().equals("")) {
	    			int choiceInt = Integer.parseInt(choice);
	    			if(choiceInt <= courseListTemp.size()) {
	    				i++;
	    				return courseListTemp.get(choiceInt - 1);
	    			}
	    		}
	    		else {
	    			println("Error: Write number with your choice!");
	    		}
			}
		}
		println("Not found course with the name: " + name);
		return null;
    }
    
//    student:
    
//    teacher:
    
    
//    login search:
    public Student searchStudentById(String studentId) {
    	if(studentList.size() == 0) {
    		println("Student cards list is empty!");
    		return null;
    	}
    	for(int i = 0; i < studentList.size(); i++) {
    		if(studentList.get(i).getStudentId().equals(studentId)) {
    			return studentList.get(i);
    		}
    	}
    	println("Student with id:" + studentId + " is not found!");
    	return null;
    }
    
    public Teacher searchTeacherById(String teacherId) {
    	if(teacherList.size() == 0) {
    		println("Teacher cards list is empty!");
    		return null;
    	}
    	for(int i = 0; i < teacherList.size(); i++) {
    		if(teacherList.get(i).getTeacherId().equals(teacherId)) {
    			return teacherList.get(i);
    		}
    	}
    	println("Teacher with id:" + teacherId + " is not found!");
    	return null;
    }
}
