package main;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

import objects.MainList;
import objects.Menu;

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
        
        menu.loginOrSignUp(mainList);
        
        mainList.showStudentList();
    }
    
//    Methods:
    
    
}
