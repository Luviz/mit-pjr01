package pjr01Main;

public class Person {

	private String fName; // 1st name
	private String sName; // sir name

	private String sig; // TODO make signature Generator

	private int length;

	private Address address;

	// if need add pointer to Persons here
	// Persons p; //lets keep track of the boss - this will interfere with
	// Presons.add(arr) -

	public Person(Person p) {
		// is this necessary I was never good with calling by ref or copying an
		// obj!
		this.sig = new String(p.getSig());

		this.fName = new String(p.getfName());
		this.sName = new String(p.getsName());

		this.length = p.length;

		this.address = new Address(p.getAddress());
	}

	public Person(String sig, String fName, String sName, int length,
			Address address) {
		this.sig = sig;

		this.fName = fName;
		this.sName = sName;

		this.length = length;

		// TODO call sigGen (fName, sName);

		this.address = address; // TODO pjr01Main.Presons make sure to give it a
								// full address

		// sigGen();
	}

	/**
	 * 
	 */
	public Person() {
		super();
	}

	/**
	 * usage for reading from a File
	 * 
	 * @param in
	 *            - [String: sig]\t[String: fname]\t[String:sname]\t[int:
	 *            length]-[Address Address]\n
	 */
	public Person(String in) {
		String[] inArray = in.split("-"); // spliting Person and the Address
		String[] pArray = inArray[0].split("\t"); // spliting Person ix 0 sig ix
													// 1 fname ix 2 sname ix 3
													// length
		this.sig = pArray[0];
		this.fName = pArray[1];
		this.sName = pArray[2];

		this.length = new Integer(pArray[3]);

		this.address = new Address(inArray[1]);
	}

	/**
	 * Generates a signature for then entry
	 */
	// private void sigGen() {
	// char [] sig = "xxxxxx".toCharArray();
	// int c =0;
	// int ctmp =0;
	//
	// while (fName.length() > ctmp && ctmp <3){
	// sig[c++] = fName.toLowerCase().charAt(ctmp++);
	// }
	// ctmp =0;
	// c = 3;
	// while (sName.length() > ctmp && ctmp <3){
	// sig[c++] = sName.toLowerCase().charAt(ctmp++);
	// }
	//
	// this.sig = new String(sig).replace(" ", "x"); //this will fix names like
	// Bo Erik
	// //System.out.println(sig);//DEBUG
	// }

	public String getSig() {
		return sig;
	}

	public void setSig(String sig) {
		this.sig = new String(sig);

	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	// DONT USE THIS!
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
	public String toString() {
		return sig + "\t" + fName + " " + sName + "\t\t"
				+ new Integer(length).toString();
	}

	public String toWrite() {
		return sig + "\t" + fName + "\t" + sName + "\t"
				+ new Integer(length).toString() + "-" + address.toWrite()
				+ "\n";
	}

}
