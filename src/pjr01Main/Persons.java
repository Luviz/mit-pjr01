package pjr01Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
			sortByName();
			break;
		case "sig":
			sortBySig();
			break;
		case "length":
		case "l":
			sortByLength();
			break;
			

		default:
			System.out.println(SORTHELP);
			break;
		}
	}

	private void sortByName() {
		// TODO Auto-generated method stub
		tmp = new ArrayList<>();	//reseting tmp;
		ArrayList<Person> t = new ArrayList<>(main);
		
		int minIx = 0;
		while(!t.isEmpty()){
			String tocheckM = new String(t.get(0).getfName() + " "+ t.get(0).getsName());
			for (int j = 0; j < t.size(); j++) {
				String check = new String(t.get(j).getfName() + " "+ t.get(j).getsName());
				if (tocheckM.compareTo(check) < 0){
					//min < i					
				}else {
					minIx = j;
					tocheckM = new String(t.get(minIx).getfName() + " "+ t.get(minIx).getsName());
				}
			}
			tmp.add(t.remove(minIx)); //adding to the list ; t size -- 
		}
	}

	private void sortBySig() {
		// TODO Auto-generated method stub
		
	}

	private void sortByLength() {
		// TODO Auto-generated method stub
		
	}
	
	public void write(String url) throws IOException{
		BufferedWriter output = new BufferedWriter(new FileWriter(url));
		for (Person p : main) {
			output.write(p.toWrite());
		}
		output.close();
	}
	
	public void read(String url) throws IOException{
		BufferedReader input = new BufferedReader(new FileReader(url));
		String in = ""; 
		while ((in = input.readLine()) != null){
			main.add(new Person(in));
			System.out.println(in);
		}
		input.close();
	}
	
}
