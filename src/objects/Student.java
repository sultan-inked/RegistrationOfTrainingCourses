package objects;

public class Student {
    public static void println(String str){
        System.out.println(str);
    }
//    Parameters:
    private String studentId;
    private String studentName;
    
//    Constructors:
    public Student(String studentId, String studentName){
        this.studentId = studentId;
        this.studentName = studentName;        
    }
//    Setters and Getters:
    public String getStudentName(){
        if(this.studentName.trim().equals("")){
            return "Error: The student name is empty!";
        }
        else return this.studentName;
    }
//    Methods:
    public void enrollInCourse(Course course){
        println("Enroll in course: " + course.getCourseName());
        course.registerStudent(this);
    }
}
