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
		
		sigGen();
	}

	
	/**
	 * Generates a signature for then entry
	 */
	private void sigGen() {
		char [] sig = "xxxxxx".toCharArray();
		int c =0;
		int ctmp =0;
		
		while (fName.length() > ctmp && ctmp <3){
			sig[c++] = fName.toLowerCase().charAt(ctmp++);
		}
		ctmp =0;
		c = 3;
		while (sName.length() > ctmp && ctmp <3){
			sig[c++] = sName.toLowerCase().charAt(ctmp++);
		}
		
		this.sig = new String(sig).replace(" ", "x");	//this will fix names like Bo Erik
		//System.out.println(sig);//DEBUG
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
	
	@Override
	public String toString(){
		return sig +"\t"+fName + " " + sName +  "\t\t" + new Integer(length).toString(); 
	}
	
}
