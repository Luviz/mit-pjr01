package pjr01Main;

public class Address {
	private String add; // post add.
	private String zip; // zipcode
	private String city;

	/**
	 * 
	 * @param add
	 * @param zip
	 * @param city
	 */
	public Address(String add, String zip, String city) {
		this.add = add;
		this.zip = zip;
		this.city = city;
	}

	/**
	 * usage for reading from a File
	 * 
	 * @param string
	 *            - [String: Address]_[String zip]_[String: City]\n
	 */
	public Address(String in) {
		String[] inArray = in.split("_");
		this.add = inArray[0];
		this.zip = inArray[1];
		this.city = inArray[2];

	}

	public Address(Address a) {
		this.add = new String(a.getAdd());
		this.zip = new String(a.getZip());
		this.city = new String(a.getCity());
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return add + "\t" + zip + "\t" + city;
	}

	public String toWrite() {
		return add + "_" + zip + "_" + city;
	}

}
