package objects;

import java.util.Scanner;

public class Menu {
	public void println(String str) {
		System.out.println(str);
	}
	public void print(String str) {
		System.out.print(str);
	}
	
	public void loginOrSignUp(MainList mainList) {
		Scanner scan = new Scanner(System.in);
		println("Hello there!");
		println("Just write number whith youre choice:");
		println("1. Log in");
		println("2. Sign up");
		for(int i = 0; i == 0;) {
			print("Here:");
			String choice = scan.nextLine();
			switch(choice) {
			case "1":
				logIn(mainList);
				i++;
				break;
			case "2":
				signUp(mainList);
				i++;
				break;
			default:
				println("Error: Write number with youre choice!");
			}
		}
		
	}
	
//	Log IN ############################################
	public void logIn(MainList mainList) {
		Scanner scan = new Scanner(System.in);
		println("Log in");
		for(int i = 0; i == 0;) {
			print("Your id:");
			String id = scan.nextLine();
			String shortId = id.substring(0, 2);
			switch(shortId) {
			case "STD":
				Student student = mainList.searchStudentById(shortId);
				if(student == null) {
					break;
				}
				studentValidator(mainList, student);
			case "TCH":
				Teacher teacher = mainList.searchTeacherById(shortId);
				if(teacher == null) {
					break;
				}
				teacherValidator(mainList, teacher);
			case "back":
				i++;
				loginOrSignUp(mainList);
				break;
			}
		}
		
		
	}
	
	public void studentValidator(MainList mainList, Student student) {
		Scanner scan = new Scanner(System.in);
		println("Log in");
		for(int i = 0; i == 0;) {
			print("Password:");
			String studentPassword = scan.nextLine();
			if(student.getStudentPassword().equals(studentPassword)) {
				i++;
				studentMenu(mainList, student);
			}
			else {
				println("Unvalid password!");
			}
		}
	}
	
	public void teacherValidator(MainList mainList, Teacher teacher) {
		Scanner scan = new Scanner(System.in);
		println("Log in");
		for(int i = 0; i == 0;) {
			print("Password:");
			String teacherPswrd = scan.nextLine();
			if(teacher.getTeacherPassword().equals(teacherPswrd)) {
				i++;
				teacherMenu(mainList, teacher);
			}
			else {
				println("Unvalid password!");
			}
		}
	}
	
//	Student MENU ############################################
	public void studentMenu(MainList mainList, Student student) {
		
	}
	
//	Teacher MENU ############################################
	public void teacherMenu(MainList mainList, Teacher teacher) {
		
	}
	
//	Sign UP ############################################
	public void signUp(MainList mainList) {
		Scanner scan = new Scanner(System.in);
		println("Just write number whith youre choice:");
		println("1. Student");
		println("2. Teacher");
		for(int i = 0; i == 0;) {
			print("Here:");
			String choice = scan.nextLine();
			switch(choice) {
			case "1":
				signUpStudent(mainList);
				i++;
				break;
			case "2":
				signUpTeacher(mainList);
				i++;
				break;
			default:
				println("Error: Write number with youre choice!");
			}
		}
	}
	
	public void signUpStudent(MainList mainList) {
		Scanner scan = new Scanner(System.in);
		print("First name: ");
		var fName = scan.nextLine();
		print("Last name: ");
		var lName = scan.nextLine();
		print("Password: ");
		var pswd = scan.nextLine();
		var std = new Student(fName, lName, pswd);
		mainList.addStudent(std);
		loginOrSignUp(mainList);
	}
	
	public void signUpTeacher(MainList mainList) {
		String passCode = "1234";
		Scanner scan = new Scanner(System.in);
		print("Enter pass code:");
		var str = scan.nextLine();
		if(str.equals(passCode)) {
			print("First name: ");
			var fName = scan.nextLine();
			print("Last name: ");
			var lName = scan.nextLine();
			print("Password: ");
			var pswd = scan.nextLine();
			var tch = new Teacher(fName, lName, pswd);
			mainList.addTeacher(tch);
			loginOrSignUp(mainList);
		}
		else {
			println("Error: Pass code is not valid!");
			loginOrSignUp(mainList);
		}
	}
	
}
