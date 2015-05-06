package pjr01Main;

public class Debug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("nr\tsig\tName\t\tLength(cm)");
		// System.out.println("1.\t"+p.toString());

		Persons p = new Persons();

		for (Person person : p.show()) {
			System.out.println(person);
		}
	}

}
