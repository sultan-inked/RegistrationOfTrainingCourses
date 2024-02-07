/*
 * Alerts - class with standard message for client.
 */

package view;

import tools.Cnsl;

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
}
