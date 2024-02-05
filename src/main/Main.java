package main;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

import objects.MainList;
import objects.Menu;
import objects.Teacher1;
import objects.Student1;
import objects.Course1;

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
        var tchList = new ArrayList<Teacher1>();
        tchList.add(new Teacher1("Walter", "White", "1234"));
        tchList.add(new Teacher1("Gustaf", "Fring", "1234"));
        tchList.add(new Teacher1("Saul", "Goodman", "1234"));
        tchList.add(new Teacher1("Hank", "Schrader", "1234"));
        for(int i = 0; i < tchList.size(); i++) {
        	mainList.addTeacher(tchList.get(i));
        }
        
        var stdList = new ArrayList<Student1>();
        stdList.add(new Student1("Jesse", "Pinkman", "1234"));
        stdList.add(new Student1("Flin", "White", "1234"));
        stdList.add(new Student1("Gale", "Botticher", "1234"));
        stdList.add(new Student1("Skyler", "White", "1234"));
        stdList.add(new Student1("Bagher", "Dude", "1234"));
        stdList.add(new Student1("Skinny", "Pete", "1234"));
        stdList.add(new Student1("Hector", "Salamanka", "1234"));
        stdList.add(new Student1("Christian", "Combo", "1234"));
        stdList.add(new Student1("Tuco", "Salamanka", "1234"));
        for(int i = 0; i < stdList.size(); i++) {
        	mainList.addStudent(stdList.get(i));
        }
        
        var crsList = new ArrayList<Course1>();
        crsList.add(new Course1( tchList.get(0), "Meth LAB", "We will making the Meth Lab!"));
        crsList.add(new Course1( tchList.get(1), "Meth MARKET", "We study how to make a meth delivery and sell store."));
        crsList.add(new Course1( tchList.get(2), "Interrogation", "How to behave in a police interrogation."));
        crsList.add(new Course1( tchList.get(3), "Surveillance", "How to do surveillance."));
        for(int i = 0; i < crsList.size(); i++) {
        	mainList.addCourse(crsList.get(i));
        }
        
        
        
//        Start program:
        menu.loginOrSignUp(mainList);
        
    }    
}
