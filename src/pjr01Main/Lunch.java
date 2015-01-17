package pjr01Main;

import java.util.Scanner;

public class Lunch {
	public static void main (String []args){
		startup();
	}
	
	private static void startup(){
		//load 
		
		//lunch main menu
		mainMenu();
	}

	private static void mainMenu() {
		//draw
		System.out.println("Weclcom plase selct an option use help for a help");
		String test = new String("non");
		reader();
	}
	
	private static void reader(){
		Scanner keyboard = new Scanner(System.in);
		String in = new String(keyboard.nextLine());
		
		switch (in.toLowerCase()) {
		case "help":
			System.out.println("help");
			break;
		
		case "exit":
			System.out.println("shuting down");
			break;
			
		case "":
			reader();
			break;

		default:
			System.out.println("WTF is "+in+ "\ntry agen maybe");
			reader();
			break;
		}
	}
}
