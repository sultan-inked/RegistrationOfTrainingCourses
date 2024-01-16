package main;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

import objects.Course;
import objects.Student;
import objects.CourseStudentList;

public class Main {
    public static void println(String str){
        System.out.println(str);
    }
    public static void print(String str){
        System.out.print(str);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean stop = true;
        boolean stop2 = true;
        
        CourseStudentList courseStudentList = new CourseStudentList();
        
        println("Hello there!");
        println("It's 'Registration of training courses' programm.");
        
        while(stop){
            println("Main menu");
            println("You can:");
            println("1. Make a course");
            println("2. Created a student card");
            println("3. Enrolled in a course");
            print("Just write a number whith your choice:");
            stop2 = true;
            while(stop2){
                String choice = scan.nextLine();
                switch(choice){
                    case "1":
                    	courseStudentList.addCourse(makeCourse());
                        stop2 = false;
                        break;
                    case "2":
                    	courseStudentList.addStudent(createStudentCard());
                        stop2 = false;
                        break;
                    case "3":
                        enrolledInCourse(courseStudentList);
                        stop2 = false;
                        break;
                    case "stop":
                        stop = false;
                        break;
                    default:
                        println("Error: Plese write number whith your choice");
                }

            }
            
        }
        
//        Student stud1 = new Student("1902", "Sultan");
//        Student stud2 = new Student("0317", "Vitaly");
//        Student stud3 = new Student("4241", "Ulan");
//        Course course1 = new Course("1259", "GitHub");
//        
//        stud1.enrollInCourse(course1);
//        stud2.enrollInCourse(course1);
//        stud3.enrollInCourse(course1);
//        
//        course1.showStudentList();
    }
    
//    Methods:
    public static void mainMenu() {
    	
    }
    
    public static void scanChoiceMunu() {
    	
    }
    
    public static Course makeCourse(){
        Scanner scan = new Scanner(System.in);
        print("Name of coure: ");
        String courseName = scan.nextLine();
        print("Course ID: ");
        String courseId = scan.nextLine();
        Course course = new Course(courseId,courseName);
        return course;
    }
    
    public static Student createStudentCard(){
    	Scanner scan = new Scanner(System.in);
    	print("Name of student: ");
        String courseName = scan.nextLine();
        print("Student ID: ");
        String courseId = scan.nextLine();
        Student student = new Student(courseId, courseName);
        return null;
    }
    
    public static void enrolledInCourse(CourseStudentList courseStudentList){
    	Scanner scan = new Scanner(System.in);
    	print("Write student name:");
    	String studentName = scan.nextLine();
    	print("Write student ID:");
    	String studentId = scan.nextLine();
    	
    }
}
