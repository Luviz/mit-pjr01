package pjr01Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Shell {

	private final String REMOVEHELP = ""
			+ "remove - remove an item from the list\n" + "Usage: remove [sig]";

	private final String ADDHELP = ""
			+ "add - adds a new Entry to the list.\n "
			+ "Usage: add [fName] [sName] [length(cm)] [Addreas] [Zip Code] [City]";
	private final String SOHWHELP = "" + "show - show the list items\n"
			+ "Usage: show [option] [modifer]\n" + "Options:\n" + "\t	\thelp\n"
			+ "\t	\tlim [range]\t e.g. show lim 0-5\n"
			+ "\t	\tsteplim [size]\t e.g. show steplim 5";
	private final String FINDHELP = "" + "finds using the signature\n"
			+ "Usage: find [sig]";

	private final String EDITHELP = ""
			+ "Edit u use to edit entrys in the list\n"
			+ "Usage: Edit [sig] [Option] [Arg]\n" + "\t	Options:\n"
			+ "\t	\t	-f - edit First Name [String]\n"
			+ "\t	\t	-s - edit Last Name [String]\n"
			+ "\t	\t	-l - edit leagth [int]\n"
			+ "\t	\t	-a - edit Address [String]\n"
			+ "\t	\t	-z - edit Zipcode [String]\n"
			+ "\t	\t	-c - edit City [String]\n"
			+ "\t	\t	--sig - edit signature [String]";
	private final String SORTHELP = "" + "Sorts the list\n"
			+ "Usage: sort [option]\n" + "\t	options\n"
			+ "\t	\t	-s - sort by signatue\n" + "\t	\t	-n - sort by name\n"
			+ "\t	\t	-l - sort by leangth";

	private Persons persons;
	private Scanner s;

	public Shell() {
		System.out.println("Weclcome! plase use help for a help");
		persons = new Persons();
		s = new Scanner(System.in);
	}

	public void start() {
		String[] commands = { "exit", "help", "add", "edit", "remove", "show",
				"sort", "write", "read", "find", "fun", "encrypt", "decrypt" };

		String input; // readLine will read the input line
		String[] inputArray; // and then it will brake in to a array
		boolean bRun = true;

		while (bRun) {
			System.out.print(">");
			input = readLine();
			inputArray = input.split(" ");
			if (inputArray.length == 0) {
			} else {

				int nIx = -1; // index number
				int i = 0;
				for (String s : commands) { // will check for a valid command
					if (s.compareTo(inputArray[0]) == 0) {
						nIx = i;
					} else {
						i++;
					}
				}
				// System.out.println(nIx);//DEBUG

				switch (nIx) {
				case 0: // exit
					bRun = false;
					shutdown();
					break;
				case 1: // help
					help(inputArray, commands);
					break;
				case 2: // add
					add(inputArray);
					break;
				case 3: // Edit
					edit(inputArray);
					break;
				case 4: // remove
					remove(inputArray);
					break;
				case 5: // show
					show(inputArray);
					break;
				case 6: // sort
					sort(inputArray);
					break;
				case 7: // write

					if (inputArray.length == 2) {
						try {
							persons.write(inputArray[1]);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else {
						System.out.println("write [fileName]");
					}
					break;
				case 8: // read
					if (inputArray.length == 2) {
						try {
							persons.read(inputArray[1]);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("read [fileName]");
					}
					break;
				case 9: // find
					find(inputArray);
					break;
				case 10: // fun
					persons.fun();
					break;
				case 11: // encrypt
					if (inputArray.length == 3) {
						try {
							persons.encrypt(inputArray[1], inputArray[2]);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						System.out
								.println("encrypt [fileName] [seed/password]");
					}
					break;
				case 12: // decrypt
					if (inputArray.length == 3) {
						try {
							persons.decrypt(inputArray[1], inputArray[2]);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						System.out
								.println("decrypt [fileName] [seed/password]");
					}
					break;
				default:
					System.out.println("Unknown command!");
					break;
				}
			}
		}
	}

	private void sort(String[] inputArray) {
		if (inputArray.length > 1) {
			persons.sort(inputArray[1]);
		} else {
			System.out.println(SORTHELP);
		}

	}

	private void edit(String[] inputArray) {
		if (inputArray.length > 3) {
			Person p = persons.edit(inputArray);
			if (p != null) {
				System.out.println(p.toWrite());
				System.out.println("has been changded");
			} else {
				System.out.println("unable to edit");
			}
		} else {
			System.out.println(EDITHELP);
		}
	}

	private void remove(String[] inputArray) {
		if (inputArray.length < 2) {
			System.out.println(REMOVEHELP);
		} else {
			Person p = persons.remove(inputArray[1]);
			if (p == null) {
				System.out
						.println("unable to find signature: " + inputArray[1]);
			} else {
				System.out.println("removing: " + inputArray[1]);
				System.out.println(p.toWrite());
				System.out.println("has been remvoed");
				persons.updateTmp();
			}
		}
	}

	private void find(String[] inputArray) {
		if (inputArray.length > 1) {
			Person p = persons.find(inputArray[1]);
			if (p != null) {
				System.out.println("" + "Signature:\n" + p.getSig() + "\n"
						+ "Name:\n" + p.getfName() + "\t" + p.getsName() + "\n"
						+ "=================\n" + "Address:\n"
						+ p.getAddress().getAdd() + "\n"
						+ p.getAddress().getZip() + "\n"
						+ p.getAddress().getCity() + "\n");

			} else {
				System.out.println("nothing was found");
			}

		} else {
			System.out.println(FINDHELP);
		}
	}

	private void shutdown() {
		System.out
				.println("Shuting down the system, all unsaved chagnes will removed");
		System.out.print("Are you ready to shutdown (Y/N) ");
		String ans = s.nextLine();
		// System.out.println(ans.toLowerCase().contains("y"));//DEBUG
		if (ans.toLowerCase().contains("y")) {
			System.out.println("Shutting down...");
			s.close();
		} else {
			start();
		}

	}

	private void add(String[] inputArray) {
		// TODO Auto-generated method stub
		System.out.println("adding...");
		if (inputArray.length == 7) {
			System.out.println("Adding " + inputArray[1] + inputArray[2]
					+ inputArray[3]);// DEBUG
			persons.Add(inputArray[1], inputArray[2],
					new Integer(inputArray[3]), inputArray[4], inputArray[5],
					inputArray[6]);
		} else {
			System.out.println(ADDHELP);
		}
	}

	private void show(String[] inArray) {
		ArrayList<Person> pArray = new ArrayList<>(persons.show());
		if (inArray.length > 1) {
			switch (inArray[1]) {
			case "":

				break;
			case "lim":

				if (inArray.length < 3) {
					while (!pArray.isEmpty()) {
						// runnig default. That is 20
						for (int i = 0; i < 20; i++) {
							if (!pArray.isEmpty())
								System.out.println(pArray.remove(0));
						}
					}
				} else {
					boolean stop = false;
					while (!pArray.isEmpty() && !stop) {
						// runnig default. That is inArray 2
						for (int i = 0; i < new Integer(inArray[2]); i++) {
							if (!pArray.isEmpty())
								System.out.println(pArray.remove(0));
						}
						System.out.println("Type 'n' for Next 'x' to exit");
						if (s.next().contains("x")) {
							stop = true;
						}
					}
				}
				break;

			case "help":
				System.out.println(SOHWHELP);
				break;

			default:
				System.out.println(SOHWHELP);
				break;
			}
		} else {

			for (Person person : pArray) {
				System.out.println(person);
			}
		}
		System.out.println();

	}

	private void help(String[] inputArray, String[] commands) {
		System.out.println();
		for (String s : commands) {
			System.out.println(s);
		}
	}

	private String readLine() {
		String ret = s.nextLine();
		return ret;

	}

}
