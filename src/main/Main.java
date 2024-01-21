package main;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

import objects.MainList;
import objects.Menu;
import objects.Teacher;
import objects.Student;
import objects.Course;

public class Main {
    public static void println(String str){
        System.out.println(str);
    }
    public static void print(String str){
        System.out.print(str);
    }
//    Main:
    public static void main(String[] args) {
    	var mainList = new MainList();
    	var menu = new Menu();
        var scan = new Scanner(System.in);
        
//        Default users:
        var tchList = new ArrayList<Teacher>();
        tchList.add(new Teacher("Walter", "White", "1234"));
        tchList.add(new Teacher("Gustaf", "Fring", "1234"));
        tchList.add(new Teacher("Saul", "Goodman", "1234"));
        tchList.add(new Teacher("Hank", "Schrader", "1234"));
        for(int i = 0; i < tchList.size(); i++) {
        	mainList.addTeacher(tchList.get(i));
        }
        
        var stdList = new ArrayList<Student>();
        stdList.add(new Student("Jesse", "Pinkman", "1234"));
        stdList.add(new Student("Flin", "White", "1234"));
        stdList.add(new Student("Gale", "Botticher", "1234"));
        stdList.add(new Student("Skyler", "White", "1234"));
        stdList.add(new Student("Bagher", "Dude", "1234"));
        stdList.add(new Student("Skinny", "Pete", "1234"));
        stdList.add(new Student("Hector", "Salamanka", "1234"));
        stdList.add(new Student("Christian", "Combo", "1234"));
        stdList.add(new Student("Tuco", "Salamanka", "1234"));
        for(int i = 0; i < stdList.size(); i++) {
        	mainList.addStudent(stdList.get(i));
        }
        
        var crsList = new ArrayList<Course>();
        crsList.add(new Course( tchList.get(0), "Meth LAB", "We will making the Meth Lab!"));
        crsList.add(new Course( tchList.get(1), "Meth MARKET", "We study how to make a meth delivery and sell store."));
        crsList.add(new Course( tchList.get(2), "Interrogation", "How to behave in a police interrogation."));
        crsList.add(new Course( tchList.get(3), "Surveillance", "How to do surveillance."));
        for(int i = 0; i < crsList.size(); i++) {
        	mainList.addCourse(crsList.get(i));
        }
        
        
        
//        Start program:
        menu.loginOrSignUp(mainList);
        
    }    
}
