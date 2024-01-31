package objects;

import java.util.Scanner;
import interfaces.User;

public class Menu {
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
		Scanner scan = new Scanner(System.in); // TODO: Have to delete this line******************
		println("Log in");
		for(int i = 0; i == 0;) {
			print("Your id:");
			String id = scan.nextLine();
			String shortId = id.substring(0, 3);
			switch(shortId) {
			case "STD":
				Student student = mainList.searchStudentById(id);
				if(student == null) {
					break;
				}
				studentValidator(mainList, student);
				i++;
				break;
			case "TCH":
				Teacher teacher = mainList.searchTeacherById(id);
				if(teacher == null) {
					break;
				}
				teacherValidator(mainList, teacher);
				i++;
				break;
			case "bac":
				i++;
				loginOrSignUp(mainList);
				break;
			default:
				println("Incorrect id!");
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
				println("Hello " + student.getStudentFirstName());
				userMenu(mainList, student);
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
				println("Hello " + teacher.getTeacherFirstName());
				userMenu(mainList, teacher);
			}
			else {
				println("Unvalid password!");
			}
		}
	}
	
//	Users MENU ############################################
	public void userMenu(MainList mainList, User user) {
		
		for(int m = 0; m == 0;) {
			int lN = 3;
			if(user instanceof Student) {
				println("Student menu...");
			}
			if(user instanceof Teacher) {
				println("Teacher menu...");
			}
			println("1. Course");
			println("2. Student");
			println("3. Teacher");
			if(user instanceof Teacher) {
				println("4. Create course");
			}
			println("Or 'exite'");
			for(int i = 0; i == 0;) {
				println("Here:");
				String choice = scan();
				switch (choice) {
				case "1":
					course(mainList, user);
					i++;
					break;
				case "2":
					println("Sorry: This feature has not yet been implemented.");
					i++;
					break;
				case "3":
					println("Sorry: This feature has not yet been implemented.");
					i++;
					break;
				case "4":
					if(user instanceof Teacher) {
						createCourse(mainList, (Teacher)user);
						i++;
						break;
					}
					else {
						println("Error: Write the number with your choice!");
						break;
					}
				case "exite":
					i++;
					m++;
					loginOrSignUp(mainList);
					break;
				default:
					println("Error: Write the number with your choice!");
				}
			}
		}
		
	}
	
//	SearchinG ##########################################
	public void course(MainList mainList, User user) {
		for(int m = 0; m == 0;) {
			println("Course");
			println("1. Search");
			println("2. Show list");
			println("Or 'back'");
			for(int i = 0; i == 0;) {
				print("Here:");
				var choice = scan();
				switch (choice) {
				case "1":
					searchCourse(mainList, user);
					i++;
					break;
				case "2":
					mainList.showCourseList();
					i++;
					break;
				case "back":
					i++;
					m++;
					break;
				default:
					println("Error: Write number with your choice!");
				}
			}
		}
		
	}
	public void searchCourse(MainList mainList, User user) {
		println("Search course");
		print("Name: ");
		var name = scan();
		print("Id: ");
		var id = scan();
		Course course = mainList.searchCourseNameId(name, id);
		if(course != null) {
			for(int m = 0; m == 0;) {
				println("Course with the name: " + course.getCourseName() + " finded!");
				println("Id:" + course.getCourseId());
				println("Author: " + course.getCourseAutorFullName());
				println("Description: " + course.getCourseDescription());
				println("Option for interacting with the course:");
				println("1. Enrolling");
				println("2. Unenrolling");
				println("Or 'back'");
				for(int i = 0; i == 0;) {
					print("Here:");
					var choice = scan();
					switch (choice) {
					case "1":
						if(user instanceof Teacher) {
							((Teacher)user).enrollInCourse(course, (Teacher)user);
							i++;
							break;
						}
						if(user instanceof Student) {
							((Student)user).enrollInCourse(course, (Student)user);
							i++;
							break;
						}
					case "2":
						if(user instanceof Teacher) {
							((Teacher)user).unenrollInCourse(course, (Teacher)user);
							i++;
							break;
						}
						if(user instanceof Student) {
							((Student)user).unenrollInCourse(course, (Student)user);
							i++;
							break;
						}
					case "back":
						i++;
						m++;
						break;
					default:
						println("Error: Write number with your choice!");
					}
				}
			}
			
		}
	}
	
//	Course CREATE ######################################
	public void createCourse(MainList mainList, Teacher teacher) {
		println("Course creator");
		String name = "", description = "";
		for(int i = 0; i == 0;) {
			print("Name: ");
			name = scan().trim();
			if(!name.equals("")) {
				i++;
			}
			else{
				println("Name cannot be empty!");
			}
		}
		for(int i = 0; i == 0;) {
			print("Description: ");
			description = scan().trim();
			if(!description.equals("")) {
				i++;
			}
			println("Description cannot be empty!");
		}
		Course course = new Course(teacher, name, description);
		mainList.addCourse(course);
		teacher.addCourseToList(course);
		
	}
	
//	Sign UP ############################################
	public void signUp(MainList mainList) {
		Scanner scan = new Scanner(System.in);
		println("Just write number whith youre choice:");
		println("1. Student");
		println("2. Teacher");
		println("Or 'back'");
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
			case "back":
				loginOrSignUp(mainList);
				i++;
				return;
			default:
				println("Error: Write number with youre choice!");
			}
		}
	}
	
	public void signUpStudent(MainList mainList) {
		Student std = new Student();
		enterUserInfoAndAddToMainList(mainList, std);
		loginOrSignUp(mainList);
	}
	
	public void signUpTeacher(MainList mainList) {
		String passCode = "1234";
		String passCodeAnswer = "";
		for(int i = 0; i == 0;) {
			print("Enter the pass code:");
			passCodeAnswer = scan().trim();
			if(passCodeAnswer.equals(passCode)) {
				i++;
				break;
			}
			if(passCodeAnswer.equals("back")) {
				i++;
				signUp(mainList);
				return;
			}
			println("Error: Pass code not valid! Write 'back' for back.");
		}
		Teacher tch = new Teacher();
		enterUserInfoAndAddToMainList(mainList, (Teacher)tch);
		loginOrSignUp(mainList);
		
	}
	public void enterUserInfoAndAddToMainList(MainList mainList, User user) {
//		var user = student;
		String userType = "student's";
		if(user instanceof Teacher) {
//			user = new Teacher();
			userType = "teacher's";
		}
		for(int i = 0; i == 0;) {
		    if(user instanceof Teacher) {
		    	user = new Teacher(enterFirstName(), enterLastName(), enterPassword());
		    }
		    else if (user instanceof Student) {
		    	user = new Student(enterFirstName(), enterLastName(), enterPassword());
		    }
			println("You wrote the following information:");
//			boolean userStudent = true;
			if(user instanceof Teacher) {
				((Teacher)user).showUserInfo();
//				userStudent = false;
			}
			if(user instanceof Student) {
				((Student)user).showUserInfo();
			}
			println("Save the " + userType + " card?");
			print("yes/no/back:");
			var answer = scan().trim();
			if(answer.equals("yes")) {
				i++;
			}
			if(answer.equals("back")) {
				i++;
				signUp(mainList);
				return;
			}
		}
		if(user instanceof Teacher) {
			mainList.addTeacher((Teacher)user);
			return;
		}
		if(user instanceof Student) {
			mainList.addStudent((Student)user);
		}
	}
	public String enterFirstName() {
		String fName = "";
		for(int i = 0; i == 0;) {
			print("First name: ");
			fName = scan().trim();
			if(!fName.equals("")) {
				i++;
				return fName;
			}
			println("Error: Parameter first name cannot be empty!");
		}
		return fName;
	}
	public String enterLastName() {
		String lName = "";
		for(int i = 0; i == 0;) {
			print("Last name: ");
			lName = scan().trim();
			if(!lName.equals("")) {
				i++;
				return lName;
			}
			println("Error: Parameter last name cannot be empty!");
		}
		return lName;
	}
	public String enterPassword() {
		String pswd = "";
		for(int i = 0; i == 0;) {
			print("Password: ");
			pswd = scan().trim();
			if(!pswd.equals("")) {
				i++;
				return pswd;
			}
			println("Error: Password cannot be empty!");
		}
		return pswd;
	}
	
}
