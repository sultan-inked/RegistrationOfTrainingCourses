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
				logIn();
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
	
	public void logIn() {
		Scanner scan = new Scanner(System.in);
	}
	
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
