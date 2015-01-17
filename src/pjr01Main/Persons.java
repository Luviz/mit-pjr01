package pjr01Main;

import java.util.ArrayList;
import java.util.Random;

public class Persons {

	private ArrayList<Person> main;		
	private ArrayList<Person> tmp;
	
	/**
	 * this is going to be transparent
	 */
	private ArrayList<Person> todisp;
	
	Persons (){
		main = new ArrayList<>();
		tmp = new ArrayList<>(main);
		todisp = new ArrayList<>(main);
	}
	
	/**
	 * @param cap - set the capacity of the array
	 */
	Persons(int cap){
		main = new ArrayList<>(cap);
		tmp = new ArrayList<>(main);
		todisp = new ArrayList<>(main);
	}
	
	/**
	 * if need u can import an old arraylist to this one
	 * @param arr - array - ArrayList <Person>
	 */
	Persons(ArrayList<Person> arr){
		main = new ArrayList<>(arr);
		tmp = new ArrayList<>(main);
		todisp = new ArrayList<>(main);
	}
	
	/**
	 * 
	 * @param fName		- first Name
	 * @param sName		- sir Name
	 * @param length	
	 * @param add		- address
	 * @param zip		- zip code
	 * @param city		- city
	 */
	public void Add(String fName, String sName, int length, String add, String zip, String city){
		main.add(new Person(fName, sName, length, new Address(add, zip, city)));
	}
	
	public void fun(){
		todisp = new ArrayList<>();	//reset todisp
		ArrayList<Person> tmp = new ArrayList<>(main);
		
		Random rand = new Random();
		for (int i = 0; i < main.size(); i++) {
			todisp.add(tmp.remove(rand.nextInt(tmp.size())));
		}
		
	}
	
}
