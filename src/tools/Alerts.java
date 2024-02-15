/*
 * Alerts - class with standard message for client.
 */

package tools;

public class Alerts {
	public static void wrtNmbr() {
		Cnsl.println("Write number with your choice!");
	}
	
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
		Cnsl.println("Try again or write \'back\'");
	}
	
	public String confirmChangeOrBack() {
		while(true) {
			Cnsl.println("\'confirm\', \'change' or \'back\'");
			Cnsl.print("Write:");
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
