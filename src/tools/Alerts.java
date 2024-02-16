/*
 * Alerts - class with standard message for client.
 */

package tools;

public class Alerts {
	
	public static void separator() {
		Cnsl.println("_____________________________________");
	}
	
	public static void ftrNotYet() {
		Cnsl.println("This feature has not yet been developed.");
	}
	
	public static void wrtHere() {
		Cnsl.print("Write here: ");
	}
	
	public static void tryAgainOrBack() {
		Cnsl.println("Try again or write \'back\'.");
	}
	
	public static void wrtNmbr() {
		Cnsl.println("Just write number with your choice.");
	}
	public static void wrtNmbrOrBack() {
		Cnsl.println("Just write number with your choice or 'back'.");
	}
	public static void wrtNmbrOrExit() {
		Cnsl.println("Just write number with your choice or 'exit'.");
	}
	
	public String wrtNmbrScan(int numberOfChoices, String backOrExit) {
		while(true) {
			String choice = Cnsl.scanWrtHere();
			for(int i = 1; i <= numberOfChoices; i++) {
				if(choice.matches("[0-9]+") ? Integer.parseInt(choice) == i : 
						!choice.equals("") ? choice.equals(backOrExit) : false) {
					return choice;
				}
			}
			
			switch(backOrExit) {
			case "back":
				wrtNmbrOrBack();
				break;
			case "exit":
				wrtNmbrOrExit();
				break;
			case "":
				wrtNmbr();
				break;
			}
		}
	}
	
	public String confirmChangeOrBack() {
		while(true) {
			Cnsl.println("\'confirm\', \'change' or \'back\'");
			wrtHere();
			String answer = Cnsl.scan();
			switch(answer) {
			case "confirm":
			case "change":
			case "back":
				return answer;
			}
		}
	}
}
