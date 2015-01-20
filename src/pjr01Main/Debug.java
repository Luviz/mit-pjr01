package pjr01Main;

public class Debug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("Bo Erik", "Hello", 120, new Address("1", "2", "3"));
		
		//System.out.println("nr\tsig\tName\t\tLength(cm)");
		//System.out.println("1.\t"+p.toString());
		
		String test = new String("barjed01\tBardia\tJedi\t178-Address 24_34124_hellowrold");
		System.out.println(test);
		String []inArray = test.split("-");
		System.out.println(inArray[0].toString());
		System.out.println(inArray[1].toString());
		
		System.out.println("---");
		String [] pArray = inArray[0].split("\t");
		for(String a : pArray){
			System.out.println(a);
		}
		String []addArray = inArray[1].split("_");
		
		for(String a : addArray){
			System.out.println(a);
		}
		
		System.out.println("\n-----\n");
		
		p = new Person(test);
		System.out.println(p.toString());
		System.out.println(p.toWrite());
	}
}
