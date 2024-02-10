/*
 * Abstract class that implements tools for outputting and
 * inputting information to the user.
 */

package tools;

import java.util.Scanner;

public abstract class Cnsl {
	
//	.print:
	public static void println() {
		System.out.println();
	}
	
	public static void println(String str) {
		System.out.println(str);
	}
	public static void print(String str) {
		System.out.print(str);
	}
	
	public static void println(int number) {
		System.out.println(number);
	}
	public static void print(int number) {
		System.out.print(number);
	}
	
//	.scan:
	public static String scan() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine().trim();
	}
}
