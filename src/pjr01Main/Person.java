package pjr01Main;

public class Person {
	
	String fName;	//1st name
	String sName;	//sir name
	
	String sig;		//TODO make signature Generator 
	
	int length;	
	
	Address address;
	
	//if need add pointer to Persons here
	//Persons p; 		//lets keep track of the boss - this will interfere with Presons.add(arr) -
	
	
	public Person(String fName, String sName, int length, Address address) {
		this.fName = fName;
		this.sName = sName;
		
		this.length = length;
		
		//TODO call sigGen (fName, sName);
		
		this.address = address; // TODO pjr01Main.Presons make sure to give it a full address
	}

	
	
	public String getSig() {
		return sig;
	}

	//DONT USE THIS!
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (sig == null) {
			if (other.sig != null)
				return false;
		} else if (!sig.equals(other.sig))
			return false;
		return true;
	}
	
	
	
}
