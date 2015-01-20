package pjr01Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Shell {
	private Persons persons;
	final String ADDHELP = ""
			+ "add - adds a new Entry to the list.\n "
			+ "Usage add [fName] [sName] [length(cm)] [Addreas] [Zip Code] [City]";
	final String SOHWHELP = ""
			+ "show - show the list items\n"
			+ "Usage show [option] [modifer]\n"
			+ "Options:\n"
			+ "\t	\thelp\n"
			+ "\t	\tlim [range]\t e.g. show lim 0-5\n"
			+ "\t	\tsteplim [size]\t e.g. show steplim 5";
	private Scanner s;
	
	public Shell(){
		System.out.println("Weclcome! plase use help for a help");
		persons = new Persons();
		s = new Scanner(System.in);
	}
	
	public void start(){
		String [] commands = {
				"exit" , "help", "add" , "edit"	 , "remove" , "show" , "sort" , "write" , "read"
		};
		
		String input;			//readLine will read the input line 
		String [] inputArray;	//and then it will brake in to a array
		boolean bRun = true;
		
		while (bRun){
			System.out.print(">");
			input = readLine();
			inputArray = input.split(" ");
			if (inputArray.length == 0){				
			}else{
				
				int nIx = -1; 	//index number
				int i =0;
				for (String s : commands) { 		// will check for a valid command
					if (s.compareTo(inputArray[0]) == 0){
						nIx =i;
					}else {
						i++;
					}
				}
				//System.out.println(nIx);//DEBUG
				
				switch (nIx) {
				case 0:	//exit
					bRun = false ;
					shutdown();
					break;
				case 1:	//help
					help(inputArray , commands);
					break;
				case 2:	//add
					add(inputArray);
					break;
				case 3: //Edit
					break;
				case 4: //remove
					break;
				case 5: //show
					show(inputArray);
					break;
				case 7: //write
					try {
						persons.write(inputArray[1]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 8: //read
					try {
						persons.read(inputArray[1]);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				default:
					break;
				}
			}
		}
	}

	private void shutdown() {
		System.out.println("Shuting down the system, all unsaved chagnes will removed");
		System.out.print("Are you ready to shutdown (Y/N) ");
		String ans = s.nextLine();
		//System.out.println(ans.toLowerCase().contains("y"));//DEBUG
		if (ans.toLowerCase().contains("y")){
			System.out.println("Shutting down...");
			s.close();
		}else{
			start();
		}
		
	}

	private void add(String[] inputArray) {
		// TODO Auto-generated method stub
		System.out.println("adding...");
		if (inputArray.length == 7){
			System.out.println("Adding " + inputArray[1] + inputArray[2] + inputArray[3] );//DEBUG
			persons.Add(inputArray[1], inputArray[2], new Integer(inputArray[3]), inputArray[4], inputArray[5], inputArray[6]);
		}else{
			System.out.println(ADDHELP);
		}
	}

	private void show(String[] inArray) {
		ArrayList<Person> pArray = new ArrayList<>(persons.show());
		switch (inArray[1]) {
		case "lim":
			
			break;
			
		case "help":
			System.out.println(SOHWHELP);
			break;

		default:
			for (Person person : pArray) {
				System.out.println(person);
			}
			break;
		}
		
		
	}
	
	private void help(String[] inputArray, String[] commands) {
		System.out.println();
		for (String s : commands){
			System.out.println(s);
		}
	}

	private String readLine() {
		String ret = s.nextLine();
		return ret;
		
	}
	
	
	
}
