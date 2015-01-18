package pjr01Main;

import java.util.ArrayList;
import java.util.Random;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class Persons {
	
	private final String SORTHELP = ""
			+ "sort the list\n"
			+ "Usage: sort [Option]\n"
			+ "name\tsort by name\n"
			+ "sig\tsort by signature\n"
			+ "l or length\tsort by Length";

	private ArrayList<Person> main;		
	private ArrayList<Person> tmp;
	
	/**
	 * this is going to be transparent
	 */
	private ArrayList<Person> todisp;
	
	public Persons (){
		main = new ArrayList<>();
		tmp = new ArrayList<>(main);
		todisp = new ArrayList<>(main);
	}
	
	/**
	 * @param cap - set the capacity of the array
	 */
	public Persons(int cap){
		main = new ArrayList<>(cap);
		tmp = new ArrayList<>(main);
		todisp = new ArrayList<>(main);
	}
	
	/**
	 * if need u can import an old arraylist to this one
	 * @param arr - array - ArrayList <Person>
	 */
	public Persons(ArrayList<Person> arr){
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
	
	public ArrayList<Person> show(){
		if (todisp.isEmpty()){
			todisp = new ArrayList<>(tmp);
			if (tmp.isEmpty()){
				todisp = new ArrayList<>(main);
			}
		}
		return todisp;
	}
	
	public Person find(String in){
		for (Person p : main) {
			if(p.getSig().compareTo(in) == 0){
				return p;
			}
		}
		return null;
	}
	
	public Person remove (String in){
		for (int i =0 ; i < main.size() ; i++) {
			if(main.get(i).getSig().compareTo(in) == 0){
				return main.remove(i);
			}
		}
		return null;
	}
	
	public void sort(String in){
		switch (in) {
		case "name":
			
			break;
		case "sig":
			
			break;
		case "length":
		case "l":
			
			break;
			

		default:
			System.out.println(SORTHELP);
			break;
		}
	}
	
}
