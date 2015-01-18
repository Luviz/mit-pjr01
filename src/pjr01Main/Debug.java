package pjr01Main;

public class Debug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("Bo Erik", "Hello", 120, new Address("1", "2", "3"));
		
		System.out.println("nr\tsig\tName\t\tLength(cm)");
		System.out.println("1.\t"+p.toString());
		
	}

}
